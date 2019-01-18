package page;

import driver.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class SelectSharePage extends BasePage {
    public void addShare(String shareName){
         //点击搜索按钮
        find(By.id("action_create_cube")).click();
        find(By.id("search_input_text")).sendKeys(shareName);
        find(By.id("follow_btn")).click();
    }
    public void deleteShare(){
        //长按
           WebElement longClick = Driver.getCurrentDriver().findElement(By.id("portfolio_whole_item"));
           new TouchAction(Driver.getCurrentDriver()).longPress(PointOption.point(longClick.getLocation().getX(),longClick.getLocation().getY())).waitAction().perform();
          find(text("删除")).click();
    }
}

