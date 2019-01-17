package page;
import driver.Driver;


import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
public class MainPage extends BasePage {
    By profile=By.id("user_profile_icon");

    public static MainPage start(){
        Driver.start();
        return new MainPage();
    }

    public ProfilePage gotoProfile(){
        Driver.getCurrentDriver().findElement(profile).click();


        return new ProfilePage();

    }

    public SearchPage gotoSearch(){
        find(By.id("home_search")).click();
        return new SearchPage();
    }
    public SelectSharePage gotoSelectShare(){
        //find(text("自选")).click();
        //waitAndFindElement( By.xpath("//*[@text='自选']"));
        try {
            sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<AndroidElement> els = new ArrayList<AndroidElement>();
        els = Driver.getCurrentDriver().findElementsByAndroidUIAutomator("resourceId(\"com.xueqiu.android:id/tab_icon\")");
        els.get(1).click();
       return new SelectSharePage();

    }
    //首页上自选这类的按钮，坐标会随着页面加载发生变化，等位置固定后再点击
    void waitAndFindElement(By element){
        WebElement e;
        Point p0;
        try {
            Driver.getCurrentDriver().findElement(element);
        }finally {
            e= Driver.getCurrentDriver().findElement(element);
            p0 = e.getLocation();
        }
        for (int i = 0; i < 5; i++) {
            e=Driver.getCurrentDriver().findElement(element);
            Point p1 = e.getLocation();
            System.out.println("****************************************************************************");
            System.out.println(p0.toString());
            System.out.println(p1.toString());
            if (p0.equals(p1)) {
                e.click();
                break;
            } else {
                p0 = p1;
                try {
                    sleep(1000);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }

    }
}
