package managers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProviders.ConfigFileReader;
import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {
	 private WebDriver driver;
	 private RemoteWebDriver remDriver;
	 private static DriverType driverType;
	 private static EnvironmentType environmentType;
	 private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	 
	 public WebDriverManager() {
	 driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
	 environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	 }
		 
	 public WebDriver getDriver() throws MalformedURLException {
	 if(driver == null) driver = createDriver();
	 return driver;
	 }
	 
	 private WebDriver createDriver() throws MalformedURLException {
	    switch (environmentType) {     
	         case LOCAL : driver = createLocalDriver();
	          break;
	         case REMOTE : driver = createRemoteDriver();
	          break;
	    }
	    return driver;
	 }
	 
	 private WebDriver createRemoteDriver() throws MalformedURLException {
		 String nodeIpnPort=FileReaderManager.getInstance().getConfigReader().getNodeIP();
		 String url="http://"+nodeIpnPort+":4444/wd/hub";
		 switch (driverType) {     
	        case FIREFOX :
	        	DesiredCapabilities caps= new DesiredCapabilities();
	        	driver = new RemoteWebDriver(new URL(url),caps);
	        break;
	        
	        case CHROME :        
	        	ChromeOptions chromeOptions = new ChromeOptions();
	        	chromeOptions.addArguments("--incognito");
	        	chromeOptions.setAcceptInsecureCerts(true);
	        	chromeOptions.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
	        	chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);  
	        	
	        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());      	
	        	driver = new RemoteWebDriver(new URL(url), chromeOptions);
	        	break;
	        	
	        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
	        break;
	        }
	 
	        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) 
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getDefaultImplicitWait(), TimeUnit.SECONDS);
	        return driver;
	 }
	 
	 private WebDriver createLocalDriver() {
	        switch (driverType) {     
	        case FIREFOX : driver = new FirefoxDriver();
	        break;
	        
	        case CHROME : 
	         System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());
	         DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("test-type");
	            options.setAcceptInsecureCerts(true);
	            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT); 
	            options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
	            capabilities.setCapability("chrome.binary", FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());
	            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	         driver = new ChromeDriver();
	         break;
	         
	        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
	        break;
	        }
	 
	        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) 
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getDefaultImplicitWait(), TimeUnit.SECONDS);
	        return driver;
	 } 
	 
	 public void closeDriver() {
	 driver.quit();
	 }
	 public void waitforXpath(int timeoutinsec, String xpathExpr) {
		 WebDriverWait wait = new WebDriverWait(driver, timeoutinsec);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpr)));
	 }
}
