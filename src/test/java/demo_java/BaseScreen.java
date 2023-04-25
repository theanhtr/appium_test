package demo_java;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseScreen {
    protected AndroidDriver<MobileElement> driver;
    protected WebDriverWait                wait;
    protected MobileActions                mobileActions;

    public BaseScreen() {
        DesiredCapabilities cap = new DesiredCapabilities();
        
        cap.setCapability("deviceName", "Active 3");
        cap.setCapability("udid", "ARB00030016");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "10");
        cap.setCapability("appPackage", "com.xiaomi.hm.health");
        cap.setCapability("appActivity", "com.xiaomi.hm.health.activity.StartUpActivity");

        // cap.setCapability("appPackage", "com.example.travel_app_ytb");
        // cap.setCapability("appActivity", "com.example.travel_app_ytb.MainActivity");

        URL url;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
            this.driver = new AndroidDriver<MobileElement>(url, cap);
            System.out.println("Appium running ...");

            // MobileElement one = driver.findElement(null);
            // one.click();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
        wait = new WebDriverWait(driver, 15);
        mobileActions = new MobileActions(driver);
    }
}