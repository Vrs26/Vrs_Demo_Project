package Demo_Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.time.Duration;

import javax.print.DocFlavor.URL;

import org.openqa.selenium.remote.HttpCommandExecutor;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.options.SupportsAppOption;
import io.appium.java_client.remote.options.SupportsDeviceNameOption;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

	public class Base_Class {
	    
	    private AppiumDriverLocalService service;
	    
	    @BeforeMethod
	    
	    public void setup() throws MalformedURLException, InterruptedException {
	    		service = new AppiumServiceBuilder()
	    		    .withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
	    		    .withIPAddress("127.0.0.1") .usingPort(4723).build();
	     
	    		
	    		service.start();
	       
	        UiAutomator2Options option = new UiAutomator2Options();
	        option.setDeviceName("Myappiumemulator");
	        option.setApp (System.getProperty("user.dir") + "src\\main\\java\\goibibo.apk");
	       AndroidDriver driver = new AndroidDriver(option);
	        
	      
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        driver.quit();
	        service.stop();
	     


	    }
	    
	}
	
