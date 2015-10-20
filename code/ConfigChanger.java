package gui;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigChanger {

	public static void changeConfig(String threshold) {
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// set the properties value
			prop.setProperty("threshold", threshold);

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
