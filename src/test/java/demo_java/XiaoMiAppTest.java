package demo_java;

import io.appium.java_client.MobileElement;
import java.util.Map;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.sql.Timestamp;
import java.io.FileWriter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import org.junit.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class XiaoMiAppTest extends BaseScreen {
     // Tạo một Map lưu trữ tài khoản
     Map<String, String> accountTest;

    @Test
    public void test_login() throws InterruptedException, IOException {
      ExtentTest extentTest = extent.createTest("LoginTest", "Test Login with 2 account error and 1 account true");
      extentTest.log(Status.INFO, "Login Test started");

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
          Thread.sleep(1800);
          
          MobileElement check_login = null;

          try {
              check_login = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/tv_login_prompt");
            } catch(Exception e) {
              System.out.println("Get element check login fail.");
            }

          if(check_login != null) {
              try {             
                myWriter.write("Account with email " + entry.getKey() + " and password " + entry.getValue() + " is error account" + "\n");
                extentTest.log(Status.INFO, "Account with email " + entry.getKey() + " and password " + entry.getValue() + " is error account");
                } catch (IOException e) {
                  System.out.println("An error occurred2.");
                  e.printStackTrace();
                }
          } else {
              try {
                  myWriter.write("Account with email " + entry.getKey() + " and password " + entry.getValue() + " is true account" + "\n");
                  extentTest.log(Status.INFO, "Account with email " + entry.getKey() + " and password " + entry.getValue() + " is true account");
                  Thread.sleep(8000);
                } catch (IOException e) {
                  System.out.println("An error occurred3.");
                  e.printStackTrace();
                }
          }
      }

      extentTest.log(Status.INFO, "Login Test ended");

      myWriter.close();
      driver.launchApp();
    }

    @Test
    public void practice_feature_test(int timeRunTest) throws InterruptedException, IOException {
      ExtentTest extentTest = extent.createTest("PracticeFeatureTest", "Test Practice Feature");
      extentTest.log(Status.INFO, "Test Practice Feature started");

      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      String fileName = "practice_feature_test_" + timestamp.getTime() / 1000L + ".txt";
      FileWriter myWriter = new FileWriter(fileName, true);

      try {             
        myWriter.write("Time setup: " + timeRunTest + " s \n");
        extentTest.log(Status.INFO, "Time setup: " + timeRunTest + " s \n");

        } catch (IOException e) {
          System.out.println("time data error.");
          e.printStackTrace();
        }

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
      Thread.sleep(800);
      MobileElement el2 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
      el2.click();
      Thread.sleep(800);
      MobileElement el3 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
      el3.click();
      Thread.sleep(800);
      MobileElement el4 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
      el4.click();
      Thread.sleep(800);
      MobileElement el5 = (MobileElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
      el5.click();
      Thread.sleep(800);
      MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.Button[1]");
      el6.click();
      Thread.sleep(800);
      MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]");
      el7.click();
      Thread.sleep(800);
      MobileElement el8 = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/sport_map_start");
      el8.click();
      Thread.sleep(800);
      MobileElement el9 = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/know_btn");
      el9.click();
      Thread.sleep(timeRunTest * 1000 + 3000); //time change screen
      MobileElement el10 = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/btn_pause");
      el10.click();
      Thread.sleep(800);

      MobileElement timeData = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat[1]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.TextView");

      try {             
        myWriter.write("Real time running: " + timeData.getText() + "\n");
        extentTest.log(Status.INFO, "Real time running: " + timeData.getText() + "\n");
        } catch (IOException e) {
          System.out.println("time data error.");
          e.printStackTrace();
        }

      Thread.sleep(800);

      
      // Thực hiện long press
      MobileElement el11 = (MobileElement) driver.findElementById("com.xiaomi.hm.health:id/btn_done");
      TouchAction touchAction = new TouchAction(driver);
      touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(el11))).perform();

      Thread.sleep(800);

      MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.Button[2]");
      el12.click();
      Thread.sleep(800);
      
      extentTest.log(Status.INFO, "Test Practice Feature ended");

      myWriter.close();
      extent.flush();
      driver.launchApp();
    }
}