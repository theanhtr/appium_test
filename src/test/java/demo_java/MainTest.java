package demo_java;

import java.io.IOException;
import java.util.HashMap;

public class MainTest 
{
    /**
     * Rigorous Test :-)
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        XiaoMiAppTest test_obj = new XiaoMiAppTest();
        test_obj.accountTest = new HashMap<>();
        
        test_obj.accountTest.put("aerror1@gmail.com", "aerrorpassword");
        test_obj.accountTest.put("aerror2@gmail.com", "aerrorpassword");
        test_obj.accountTest.put("theanh090602@gmail.com", "anhtran96");

        //login test
        // test_obj.test_login();

        test_obj.accountTest.clear();
        
        test_obj.accountTest.put("theanh090602@gmail.com", "anhtran96");

        //a feature test
        test_obj.a_feature_test();
    }
}
