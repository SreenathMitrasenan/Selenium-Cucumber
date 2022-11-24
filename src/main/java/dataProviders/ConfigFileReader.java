package dataProviders;
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;
 
public class ConfigFileReader {
 
 private Properties properties;
 private final String propertyFilePath= "configs//Configuration.properties";
 
 
 public ConfigFileReader(){
	 BufferedReader reader;
	 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 properties = new Properties();
		 try {
			 properties.load(reader);
			 reader.close();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
 	}
 
 public String getChromeDriverPath(){
	 String driverPath = properties.getProperty("ChromeDriverPath");
	 if(driverPath!= null) return driverPath;
	 else throw new RuntimeException("chrome driverPath not specified in the Configuration.properties file."); 
 }
 public String getDoorwardLogoPath(){
	 String driverPath = properties.getProperty("DoorwardImagePath");
	 if(driverPath!= null) return driverPath;
	 else throw new RuntimeException("doorward image/logo not provided in the Configuration.properties file."); 
 }
 public long getDefaultImplicitWait() { 
	 String implicitlyWait = properties.getProperty("defaultImplicitWaitTime");
	 if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
	 else throw new RuntimeException("Default implicit Wait not specified in the Configuration.properties file."); 
 }
 
 public String getDoorwardBaseUrl() {
	 String url = properties.getProperty("doorwardHomeUrl");
	 if(url != null) return url;
	 else throw new RuntimeException("Doorward base url not specified in the Configuration.properties file.");
 }
 
 public DriverType getBrowser() {
	 String browserName = properties.getProperty("browser");
	 if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
	 else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
	 else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
	 else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	 }
	 
public EnvironmentType getEnvironment() {
	 String environmentName = properties.getProperty("environment");
	 if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
	 else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
	 else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	 }
	 
public Boolean getBrowserWindowSize() {
	 String windowSize = properties.getProperty("windowMaximize");
	 if(windowSize != null) return Boolean.valueOf(windowSize);
	 return true;
	 }
	 
public String getReportConfigPath(){
 String reportConfigPath = properties.getProperty("reportConfigPath");
 if(reportConfigPath!= null) return reportConfigPath;
 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
}
 
public String getUtilittyPath(){
	 String reportConfigPath = properties.getProperty("utilityPath");
	 if(reportConfigPath!= null) return reportConfigPath;
	 else throw new RuntimeException("Utility Path not specified in the Configuration.properties file for the Key:utilityPath"); 
	}
 public String getNodeIP() {
	 String nodeIP = properties.getProperty("nodeIp");
	 if(nodeIP!= null) return nodeIP;
	 else throw new RuntimeException("Node IP details not specified in the Configuration.properties file for the Key:nodeIp"); 
 }
 public String getTestDataResourcePath(){
	 String testDataResourcePath = properties.getProperty("testDataResourcePath");
	 if(testDataResourcePath!= null) return testDataResourcePath;
	 else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath"); 
	}
}