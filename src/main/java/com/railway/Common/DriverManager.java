package com.railway.Common;

import com.railway.Constant.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DriverManager {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/macos/Desktop/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.railwayb2.somee.com/Page/HomePage.cshtml");
    }
    public static void maximizePage(){
        Constant.WEBDRIVER.manage().window().maximize();
    }
    //Dùng để phóng to cửa sổ trình duyệt lên tối đa
    public static void openPageByUrl(String baseUrl)
    {
        Constant.WEBDRIVER.navigate().to(baseUrl);
    }
//Dùng để mở trang web bằng cách điều hươngs đến địa chỉ cung cấp
}
