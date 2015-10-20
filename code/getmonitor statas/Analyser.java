package MonitorStats;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class Analyser {

	static ArrayList<Long> tailDropList10 = new ArrayList<Long>();
	static LocalTime LastModifiedTime = LocalTime.now();

	public static void monitor(String policyName, String bw, long newTailDrop) {

		if (Analyser.tailDropList10.size() < 10) 
			Analyser.buildBuffer(newTailDrop);
		else {
			Analyser.modifyBuffer(newTailDrop);
		}
		logPolicyChangeHeader(policyName, bw);

		// int congestion = Analyser.analyse();
		int congestion = Analyser.analyseSum();
		if (LocalTime.now().compareTo(LastModifiedTime.plusSeconds(30l)) > 0) {// CHANGE//
			if (congestion == 1) {

				int oldbw = Integer.parseInt(bw.replace("kbps", ""));
				int newbw = oldbw + 256;// CHANGE//
				if (newbw > 2048) {// CHANGE//
					String message = "\nCongestion detected but cannot increase the bandwidth further. Limit Reached!!";
					logPolicyAction(message);
				} else {
					StringBuffer message = new StringBuffer(
							"\nCongestion Detected!!\nReached the threshold set, pushing a Qos policy change to upgrade the bandwidth from "
									+ oldbw + "kbps to " + newbw + "kbps");

					if (PolicyPusher.pushNewPolicy("" + newbw + "kbps") == 200) {
						clearList();
						LastModifiedTime = LocalTime.now();
						logPolicyAction(message
								.append("\nSuccessfully Upgraded bandwidth from " + oldbw + "kbps to " + newbw + "kbps")
								.toString());
					}

				}

			} else if (congestion == -1) {

				int oldbw = Integer.parseInt(bw.replace("kbps", ""));
				int newbw = oldbw - 256;// CHANGE//
				if (newbw < 512) {// CHANGE//
					String message = "\nDespite low bandwidth utilisation can't decrease the bandwidth further. Limit Reached!!";
					logPolicyAction(message);
				} else {
					StringBuffer message = new StringBuffer(
							"\nBandwidth utilisation very less!!\nDowngrading the bandwidth from " + oldbw + "kbps to "
									+ newbw + "kbps");

					if (PolicyPusher.pushNewPolicy("" + newbw + "kbps") == 200) {
						LastModifiedTime = LocalTime.now();
						logPolicyAction(message.append(
								"\nSuccessfully downgraded bandwidth from " + oldbw + "kbps to " + newbw + "kbps")
								.toString());
					}

				}
			} else {

				logPolicyAction("\nMonitoring in Progress");

			}

		} else {
			logPolicyAction("\nMonitoring in Progress");
		}

	}

	private static void logPolicyAction(String message) {
		FileWriter foutLog;
		try {
			foutLog = new FileWriter(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\policyChangeLog.txt",
					true);//CHANGE//
			foutLog.append(message);

			foutLog.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void clearList() {
		for (int i = 0; i < tailDropList10.size(); i++) {
			tailDropList10.set(i, 0l);
		}
	}

	public static void logPolicyChangeHeader(String policyName, String bw) {
		FileWriter foutLog;
		try {
			foutLog = new FileWriter(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\policyChangeLog.txt");
			foutLog.append("Qos Policy Name: " + policyName);
			foutLog.append("\nReal-Time Traffic Bandwidth: " + bw);
			foutLog.append("\nPacket Delay Count in last 10 intervals");
			for (long temp : tailDropList10)
				foutLog.append("\n" + temp);

			// foutLog.append("\nNo of Intervals that experienced packet delay
			// (Threshold/Tolerance=6)= "
			// + getCountTaildropInterval());
			long sum = getSumCountTailDrop();
			System.out.println("tails drops" + sum);
			foutLog.append("\nTotal no. of delayed packets in the last 10 intervals :" + sum);
			foutLog.append("\n Current threshold for congestion : " + ConfigReader.getThreshold() + " delayed packets");
			foutLog.close();

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	/*public static void logPolicyChange(String policyName, String bw, int congestion) {
		FileWriter foutLog;
		try {
			foutLog = new FileWriter(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\policyChangeLog.txt");
			foutLog.append("\nQos Policy Name: " + policyName);
			
			foutLog.append("\nReal-Time Traffic Bandwidth: " + bw);
			

			foutLog.append("\nPacket Delay Count- in last 10 intervals");
			for (long temp : tailDropList10)
				foutLog.append("\n" + temp);

			foutLog.append("\nNo of Intervals that experienced packet delay (Threshold/Tolerance=6)= "
					+ getCountTaildropInterval());
			if (congestion == 1) {
				foutLog.append("\nCongestion Detected!!");
				foutLog.append("\nReached the threshold set, push a Qos policy change to upgrade the bandwidth ");
				foutLog.append("\nQos Policy upgrade push is complete");
				System.out.println("wrote");
			} else {
				if (congestion == -1) {
					foutLog.append("\nReached the threshold set, push a Qos policy change to upgrade the bandwidth ");
				} else {
					foutLog.append("\nNo Congestion Yet.....Monitoring in Progress....");
				}

			}

			foutLog.close();

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}*/

	/*public static int getCountTaildropInterval() {
		int count = 0;
		for (long temp : tailDropList10) {
			if (temp > 0)
				count++;
		}
		return count;
	}*/

	public static long getSumCountTailDrop() {
		long sum = 0l;
		for (long temp : tailDropList10) {
			sum += temp;
		}
		return sum;
	}

	public static int analyseSum() {
		long sum = getSumCountTailDrop();
		int threshold = ConfigReader.getThreshold();
		if (sum > threshold)
			return 1;
		else if (sum == 0)
			return -1;
		else
			return 0;
	}

	/*public static int analyse() {

		int count = getCountTaildropInterval();

		if (count > 6)
			return 1;
		else {
			if (count == 0)
				return -1;
			else
				return 0;
		}
	}*/

	public static void buildBuffer(long newTailDrop) {

		tailDropList10.add(newTailDrop);
	}

	public static void modifyBuffer(long newTailDrop) {
		tailDropList10.remove(0);
		tailDropList10.add(newTailDrop);
	}

}
