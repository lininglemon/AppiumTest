import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.SelectSharePage;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class SelectShareTest {
    static MainPage mainPage;
    static SelectSharePage selectSharePage;

    @BeforeAll
    static void beforeAll(){
        mainPage=mainPage.start();
        selectSharePage = mainPage.gotoSelectShare();
    }

   @Test
    void 添加自选(String shareName){
        selectSharePage.addShare(shareName);
        assertThat("", equalTo(""));
    }

    @Test
    void 删除自选(){
        selectSharePage.deleteShare();
        assertThat("", equalTo(""));
    }
}
