package com.myecom.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;


public class BaseClass {
	
		public static WebDriver driver;
		public static Properties prop;
		public static String projectPath = System.getProperty("user.dir");
		
		
		public void loadAppication() {
			
			String browser = (String)prop.get("browser");
			
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\lenovo\\\\Desktop\\\\selenium\\\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else{
				System.setProperty("webdriver.edge.driver", "C:\\\\Users\\\\lenovo\\\\Desktop\\\\selenium\\\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			
			driver.get(prop.getProperty("baseurl"));
		}
		
		@BeforeTest
		public void readProp() throws IOException {
			
			FileInputStream fis = new FileInputStream(projectPath+"//Config/config.properties");
			prop = new Properties();
			prop.load(fis);	
		}


}
