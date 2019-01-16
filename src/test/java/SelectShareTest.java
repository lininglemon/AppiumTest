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

    @ParameterizedTest
    @CsvSource({
            "pdd, ",
            "alibaba, ",
            "sogo, "
    })
    void 添加自选(String shareName, String name){
        selectSharePage.addShare(shareName,mainPage.gotoSearch());
        assertThat(null, equalTo(name));
    }

    @Test
    void 删除自选(){
        selectSharePage.deleteShare();
        assertThat(null, equalTo(""));
    }
}
