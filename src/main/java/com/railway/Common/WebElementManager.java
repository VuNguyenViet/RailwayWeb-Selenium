package com.railway.Common;
import com.railway.Constant.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class WebElementManager {
    //    Quản lí các thao tác liên quan tơi WebElement
    public static void clickToElement(WebElement element){
        scrollToElement(element);
        element.click();
    }
    //    Thực hiện việc click vào 1 element
    public static void scrollToElement( WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor)(Constant.WEBDRIVER);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    //    Thực hiện việc cuộn trình duyệt đến vị trí của 1 Element
    public static Alert getAlert(){
        return Constant.WEBDRIVER.switchTo().alert();
    }
    //    Thao tác liên quan đến cảnh báo (Alert)
    public static boolean checkElementExist(WebElement element) {
        if (element != null) return true;
        return false;
    }
    //    Kiểm tra Element đó có tồn tại hay không
    public static void gotoPreviousPage(){
        Constant.WEBDRIVER.navigate().back();
    }
    //    Điều hướng đến trang trước đó
    public static void waitElement(long timeout)  {
        try {
            Thread.sleep(timeout);
        }
        catch (Exception e)
        {
        }
    }
//    Tạm ngừng thực thi chương trình trong khoảng thời gian mà ta Set
}

