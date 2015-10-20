package MonitorStats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataplanePolicy {

	public static String getDataplanePolicyName() {
		String str = getJSONString();
		JSONObject obj = new JSONObject(str);
		JSONArray dataplanes = obj.getJSONArray("vyatta-interfaces-dataplane:dataplane");
		JSONObject dataplane = (JSONObject) dataplanes.get(0);
		String policyname = dataplane.getString("vyatta-policy-qos:qos-policy");
		return policyname;

	}

	public static String getJSONString() {
		URL oracle = null;
		URLConnection yc = null;
		HttpURLConnection connection = null;
		int code = 0;

		try {
			//CHANGE//
			oracle = new URL(
					"http://10.76.110.84:8181/restconf/config/opendaylight-inventory:nodes/node/vRouter-R1/yang-ext:mount/vyatta-interfaces:interfaces/vyatta-interfaces-dataplane:dataplane/dp0p224p1/");

			connection = (HttpURLConnection) oracle.openConnection();

			yc = oracle.openConnection();
			code = connection.getResponseCode();
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

		if (code != 200) {
			
			System.exit(0);

		}
		StringBuffer response = new StringBuffer();
		if (code == 200) {

			BufferedReader in;

			try {
				String inputLine;

				in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while ((inputLine = in.readLine()) != null) {

					if (inputLine.equals(""))

						continue;

					response.append(inputLine + "\n");

				}

			} catch (IOException e1) {

				e1.printStackTrace();
			}

		}
		return response.toString();
	}
}
