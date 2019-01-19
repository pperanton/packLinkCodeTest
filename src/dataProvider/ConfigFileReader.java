package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	 
	 private Properties properties;
	 private final String propertyFilePath= "configs//configuration.properties";
	 
	 
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
	 throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
	 } 
	 }
	
	 
	 
/*webDriver reader*/
	 
	 /*CHROME*/
	 public String getChromeDriverPath(){
	 String ChromeDriverPath = properties.getProperty("ChromeDriverPath");
	 if(ChromeDriverPath!= null) return ChromeDriverPath;
	 else throw new RuntimeException("ChromeDriverPath not specified in the configuration.properties file."); 
	 }
	 
	 /*FF*/
	 public String getFirefoxDriverPath(){
		 String FirefoxDriverPath = properties.getProperty("FirefoxDriverPath");
		 if(FirefoxDriverPath!= null) return FirefoxDriverPath;
		 else throw new RuntimeException("FirefoxDriverPath not specified in the configuration.properties file."); 
		 }
	 
	 /*SAFARI*/
	 public String getSafariDriverPath(){
		 String SafariDriverPath = properties.getProperty("SafariDriverPath");
		 if(SafariDriverPath!= null) return SafariDriverPath;
		 else throw new RuntimeException("SafariDriverPath not specified in the configuration.properties file."); 
		 }
	 
	 /*EDGE*/
	 public String getEdgeDriverPath(){
		 String EdgeDriverPath = properties.getProperty("EdgeDriverPath");
		 if(EdgeDriverPath!= null) return EdgeDriverPath;
		 else throw new RuntimeException("EdgeDriverPath not specified in the configuration.properties file."); 
		 }
	 
/*URL reader*/
	 
	 /*URL home page*/
	 public String getApplicationUrlHome() {
	 String UrlHome = properties.getProperty("urlHome");
	 if(UrlHome != null) return UrlHome;
	 else throw new RuntimeException("urlHome not specified in the configuration.properties file.");
	 }
	 
	 /*URL registration form*/
	 public String getApplicationUrlregister() {
		 String urlRegister = properties.getProperty("urlRegister");
		 if(urlRegister != null) return urlRegister;
		 else throw new RuntimeException("urlRegister not specified in the configuration.properties file.");
		 }

/*Default Packlink Pro User*/
	 
	 /*User name*/
	 public String getplProUser() {
		 String plProUser = properties.getProperty("plProUser");
		 if(plProUser != null) return plProUser;
		 else throw new RuntimeException ("plProUser not specified in the configuration.properties file.");
	 }
	 
	 /*User password*/
	 public String plProPassword() {
		 String plProPassword = properties.getProperty("plProPassword");
		 if(plProPassword != null) return plProPassword;
		 else throw new RuntimeException ("plProPassword not specified in the configuration.properties file.");
	 }
	}