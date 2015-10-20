package MonitorStats;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	static ArrayList<String> graphList10 = new ArrayList<String>();

	public static void monitor(HashMap<Integer, String> descMap, HashMap<Integer, String> bwMap) {

		String dataPoint = getDataPointString(descMap, bwMap);

		if (Graph.graphList10.size() < 30)
			Graph.buildBuffer(dataPoint);
		else {
			Graph.modifyBuffer(dataPoint);
		}

		printGraphList10();

	}

	public static void clearList() {
		for (int i = 0; i < graphList10.size(); i++) {
			graphList10.remove(0);
		}
	}

	public static void printGraphList10() {

		FileWriter fout;
		try {// CHANGE//
			fout = new FileWriter(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\graphText.txt");

			for (String dataPoint : graphList10) {
				fout.append("\n" + dataPoint);

			}

			fout.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static String getDataPointString(HashMap<Integer, String> descMap, HashMap<Integer, String> bwMap) {
		StringBuffer message = new StringBuffer();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime timestamp = LocalTime.now();
		message.append("{\"Timestamp\": \"" + formatter.format(timestamp) + "\"");
		message.append(",\"" + descMap.get(0) + "\": \"" + bwMap.get(0).replace("kbps", "") + "\"");
		message.append(",\"" + descMap.get(1) + "\": \"" + bwMap.get(1).replace("kbps", "") + "\"");
		message.append(",\"" + descMap.get(2) + "\": \"" + bwMap.get(2).replace("kbps", "") + "\"");
		message.append(",\"" + descMap.get(3) + "\": \"" + bwMap.get(3).replace("kbps", "") + "\"");
		message.append("}");

		return message.toString();

	}

	public static void buildBuffer(String dataPoint) {
		graphList10.add(dataPoint);
	}

	public static void modifyBuffer(String dataPoint) {
		graphList10.remove(0);
		graphList10.add(dataPoint);
	}

}
