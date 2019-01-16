package page;
import driver.Driver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
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
        find(text("自选")).click();
        return new SelectSharePage();

    }

}
