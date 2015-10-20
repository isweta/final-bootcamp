package MonitorStats;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	public static int getThreshold() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String threshold = prop.getProperty("threshold");
			return Integer.parseInt(threshold);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}

	public static int getDataplaneName() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String dataplaneName = prop.getProperty("dataplaneName");
			return Integer.parseInt(dataplaneName);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}

	public static int getRouterName() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String routerName = prop.getProperty("routerName");
			return Integer.parseInt(routerName);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}

	public static int getRouterPass() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String routerPass = prop.getProperty("routerPass");
			return Integer.parseInt(routerPass);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}

	public static int getRouterURL() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String routerURL = prop.getProperty("routerURL");
			return Integer.parseInt(routerURL);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}

	public static int getHistoryPath() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String historyPath = prop.getProperty("historyPath");
			return Integer.parseInt(historyPath);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}

	public static int getCurrentPath() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String currentPath = prop.getProperty("currentPath");
			return Integer.parseInt(currentPath);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}

	public static int getTailDropListSize() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String tailDropListSize = prop.getProperty("tailDropListSize");
			return Integer.parseInt(tailDropListSize);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}

	public static int getIncrementSize() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String incrementSize = prop.getProperty("incrementSize");
			return Integer.parseInt(incrementSize);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}

	public static int getUpperLimit() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String upperLimit = prop.getProperty("upperLimit");
			return Integer.parseInt(upperLimit);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}

	public static int getLowerLimit() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String lowerLimit = prop.getProperty("lowerLimit");
			return Integer.parseInt(lowerLimit);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}
	
	public static int getPolicyChangeLogURL() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String policyChangeLogURL = prop.getProperty("policyChangeLogURL");
			return Integer.parseInt(policyChangeLogURL);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}
	
	public static int getControllerURL() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String controllerURL = prop.getProperty("controllerURL");
			return Integer.parseInt(controllerURL);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}
	
	public static int getGraphTextURL() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value
			String graphTextURL = prop.getProperty("graphTextURL");
			return Integer.parseInt(graphTextURL);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return 0;

	}


}
