package demo_java;

import io.appium.java_client.MobileElement;
import java.util.Map;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.sql.Timestamp;
import java.io.FileWriter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.remote.DesiredCapabilities;

public class XiaoMiAppTest extends BaseScreen {
     // Tạo một Map lưu trữ tài khoản
     Map<String, String> accountTest;

    public void test_login() throws InterruptedException, IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String fileName = "login_test_" + timestamp.getTime() / 1000L + ".txt";
        FileWriter myWriter = new FileWriter(fileName, true);

        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred1.");
            e.printStackTrace();
          }

        Thread.sleep(2000);

        MobileElement emailInput = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/et_username");

        MobileElement passwordInput = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/et_password");

        for (Map.Entry<String, String> entry : accountTest.entrySet()) {
            //email fill
            emailInput.click();
            emailInput.sendKeys(entry != null ? entry.getKey() : "");

            //password fill
            passwordInput.click();
            passwordInput.sendKeys(entry != null ? entry.getValue() : "");
            
            //press Login button
            MobileElement loginButton = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/tv_login");
            loginButton.click();
            Thread.sleep(1500);
            
            MobileElement check_login = null;

            try {
                check_login = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/tv_login_prompt");
              } catch(Exception e) {
                System.out.println("Get element check login fail.");
              }

            if(check_login != null) {
                try {             
                  myWriter.write("Account with email " + entry.getKey() + " and password " + entry.getValue() + " is error account" + "\n");
                  } catch (IOException e) {
                    System.out.println("An error occurred2.");
                    e.printStackTrace();
                  }
            } else {
                try {
                    myWriter.write("Account with email " + entry.getKey() + " and password " + entry.getValue() + " is true account" + "\n");
                    Thread.sleep(8000);
                  } catch (IOException e) {
                    System.out.println("An error occurred3.");
                    e.printStackTrace();
                  }
            }
        }

        myWriter.close();
        driver.launchApp();
    }

    public void a_feature_test() throws InterruptedException, IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String fileName = "a_feature_test_" + timestamp.getTime() / 1000L + ".txt";
        FileWriter myWriter = new FileWriter(fileName, true);

        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred1.");
            e.printStackTrace();
          }

        Thread.sleep(2000);

        MobileElement emailInput = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/et_username");

        MobileElement passwordInput = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/et_password");

        for (Map.Entry<String, String> entry : accountTest.entrySet()) {
            //email fill
            emailInput.click();
            emailInput.sendKeys(entry != null ? entry.getKey() : "");

            //password fill
            passwordInput.click();
            passwordInput.sendKeys(entry != null ? entry.getValue() : "");
            
            //press Login button
            MobileElement loginButton = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/tv_login");
            loginButton.click();

            Thread.sleep(6000);
        }

        //test feature here
        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.Button[2]");
        el1.click();        
        Thread.sleep(500);
        MobileElement el2 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
        el2.click();
        Thread.sleep(500);
        MobileElement el3 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
        el3.click();
        Thread.sleep(500);
        MobileElement el4 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
        el4.click();
        Thread.sleep(500);
        MobileElement el5 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
        el5.click();
        Thread.sleep(500);
        MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.Button[1]");
        el6.click();
        Thread.sleep(500);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]");
        el7.click();
        Thread.sleep(500);
        MobileElement el8 = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/sport_map_start");
        el8.click();
        Thread.sleep(500);
        MobileElement el9 = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/know_btn");
        el9.click();
        Thread.sleep(40000);
        MobileElement el10 = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/btn_pause");
        el10.click();
        Thread.sleep(500);
        MobileElement el11 = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/btn_done");
        
        // Thực hiện long press
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(el11))).perform();

        Thread.sleep(500);

        MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.Button[2]");
        el12.click();
        Thread.sleep(500);

        myWriter.close();
        driver.launchApp();
    }
}