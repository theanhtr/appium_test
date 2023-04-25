package demo_java;

import io.appium.java_client.MobileElement;
import java.util.HashMap;
import java.util.Map;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.sql.Timestamp;
import java.io.FileWriter;

public class MainScreen extends BaseScreen {
     // Tạo một Map lưu trữ tài khoản
     Map<String, String> accountTest;

    public void test_login() throws InterruptedException {
        accountTest = new HashMap<>();
        // Thêm tài khoản vào Map
        accountTest.put("error1@gmail.com", "errorpassword");
        accountTest.put("theanh090602@gmail.com", "anhtran96");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String fileName = "login_test_" + timestamp.getTime() / 1000L + ".txt";

        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

        Thread.sleep(2000);


        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Next");
        el1.click();
        Thread.sleep(1000);
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Next");
        el2.click();
        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Get start");
        el3.click();
        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("OK");
        el4.click();
        Thread.sleep(1000);

        for (Map.Entry<String, String> entry : accountTest.entrySet()) {
            //email fill
            MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]");
            el5.click();
            Thread.sleep(1000);
            el5.sendKeys(entry != null ? entry.getKey() : "");

            //password fill
            MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]");
            el6.click();
            Thread.sleep(1000);
            el6.sendKeys(entry != null ? entry.getValue() : "");
            Thread.sleep(1000);
            
            //press BACK button
            driver.pressKeyCode(4, 1);
            Thread.sleep(1000);
            
            //press Login button
            MobileElement el7 = (MobileElement) driver.findElementByXPath("(//android.view.View[@content-desc=\"Đăng Nhập\"])[2]");
            el7.click();
            Thread.sleep(3000);

            MobileElement check_login = null;

            try {
                check_login = (MobileElement) driver.findElementByAccessibilityId("OK");
              } catch(Exception e) {
                System.out.println("An error occurred.");
              }

            if(check_login != null) {
                try {
                    Thread.sleep(1000);

                    FileWriter myWriter = new FileWriter(fileName);

                    myWriter.append("Account with email " + entry.getKey() + " and password " + entry.getValue() + " is error account");
                    myWriter.close();

                    MobileElement login_false_ok_button = (MobileElement) driver.findElementByAccessibilityId("OK");
                    login_false_ok_button.click();

                    el5.click();
                    Thread.sleep(1000);
                    el5.clear();

                    el6.click();
                    Thread.sleep(1000);
                    el6.clear();

                    //press BACK button
                    driver.pressKeyCode(4, 1);
                    Thread.sleep(1000);
                  } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                  }
            } else {
                try {
                    FileWriter myWriter = new FileWriter(fileName);

                    myWriter.append("Account with email " + entry.getKey() + " and password " + entry.getValue() + " is true account");
                    myWriter.close();

                    el5.click();
                    Thread.sleep(1000);
                    el5.clear();

                    el6.click();
                    Thread.sleep(1000);
                    el6.clear();

                    //press BACK button
                    driver.pressKeyCode(4, 1);
                    Thread.sleep(1000);
                  } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                  }
            }
        }

        Thread.sleep(5000);
        MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("OK");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("Hotels");
        el9.click();
        Thread.sleep(1000);
        MobileElement el10 = (MobileElement) driver.findElementByAccessibilityId("Search");
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementByAccessibilityId("Ok");
        el11.click();
        Thread.sleep(1000);
        MobileElement el12 = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"Select Date\nPlease select date\"]/android.view.View[2]");
        el12.click();
        Thread.sleep(1000);
        MobileElement el13 = (MobileElement) driver.findElementByAccessibilityId("Th 5, 27 tháng 4 2023");
        el13.click();
        MobileElement el14 = (MobileElement) driver.findElementByAccessibilityId("Select");
        el14.click();
        Thread.sleep(1000);
        MobileElement el15 = (MobileElement) driver.findElementByAccessibilityId("Search");
        el15.click();
        Thread.sleep(1000);

        driver.launchApp();
    }
}