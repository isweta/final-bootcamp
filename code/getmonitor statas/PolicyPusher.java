package MonitorStats;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class PolicyPusher {

	public static int pushNewPolicy(String newBw) {
		String policyName = DataplanePolicy.getDataplanePolicyName();
		String payload = formPayload(policyName, newBw);
		return pushPolicy(policyName, payload);
	}

	public static String formPayload(String policyName, String newBw) {

		JSONObject obj = DataplanePolicyDescription.getJSONObject(policyName);
		JSONArray policyAr = obj.getJSONArray("vyatta-policy-qos:qos");
		JSONObject policyObj = (JSONObject) policyAr.get(0);
		JSONObject shaperObj = (JSONObject) policyObj.get("shaper");

		JSONArray classAr = shaperObj.getJSONArray("class");

		for (int j = 0; j < classAr.length(); j++) {

			JSONObject shaperClassObj = classAr.getJSONObject(j);
			JSONArray matchAr = shaperClassObj.getJSONArray("match");
			JSONObject matchObj = matchAr.getJSONObject(0);
			if (matchObj.getString("tagnode").equals("AUDIO_SRC")
					|| matchObj.getString("tagnode").equals("VIDEO_SRC")) {
				JSONObject police = matchObj.getJSONObject("police");
				police.put("bandwidth", newBw);
			}

		}

		JSONArray profileAr = shaperObj.getJSONArray("profile");
		JSONObject tsd_profileObj = profileAr.getJSONObject(0);
		JSONArray trafficClassAr = tsd_profileObj.getJSONArray("traffic-class");
		for (int i = 0; i < trafficClassAr.length(); i++) {

			JSONObject classObj = (JSONObject) trafficClassAr.get(i);
			if (classObj.getInt("tagnode") == 0) {
				classObj.put("bandwidth", newBw);
			}
		}

		return obj.toString();
	}

	public static int pushPolicy(String policyName, String payload) {
		URL oracle = null;

		try {
			oracle = new URL(//CHANGE//
					"http://10.76.110.84:8181/restconf/config/opendaylight-inventory:nodes/node/vRouter-R1/yang-ext:mount/vyatta-policy:policy/vyatta-policy-qos:qos/"
							+ policyName);

			HttpURLConnection connection = (HttpURLConnection) oracle.openConnection();

			connection.setRequestMethod("PUT");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "*/*");
			OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
			osw.write(payload);
			osw.flush();
			osw.close();
			return connection.getResponseCode();
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException p) {
			p.printStackTrace();

		}
		return 0;

	}

}
