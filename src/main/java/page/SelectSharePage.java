package page;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class SelectSharePage extends BasePage {
    public void addShare(String shareName){
        find(By.id("home_search")).click();
        find(By.className("android.widget.EditText")).sendKeys(shareName);
        AndroidElement select=(AndroidElement) find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        select.click();
    }
    public void deleteShare(){
        Actions actions=new Actions(Driver.getCurrentDriver());
        //长按
        actions.clickAndHold(find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]")));
    }
}
