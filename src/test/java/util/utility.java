package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class utility {
    static public WebDriver getBrowser(String BrowserName) {
    	if(BrowserName.equals("chrome")) {
    		//System.setProperty("webdriver.chrome.driver", " C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
    		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
    		return new ChromeDriver();
    	}
    	if(BrowserName.equals("ie")) {
    		System.setProperty("webdriver.ie.driver", "src/test/resources/driver/IEDriverServer.exe");
    		return new InternetExplorerDriver();
    	}
    	
    	else{
    		return null;
    		}
    	}

	

}
