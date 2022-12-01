package locators;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class locators {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://magento.softwaretestingboard.com/";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void happyTest() throws InterruptedException {

        String question = "Are you sure you would like to remove this item from the shopping cart?";
        String message = "You have no items in your shopping cart.";


        open("/men/tops-men.html");


        $(By.cssSelector("#layered-filter-block")).$(byText("Style")).click();
        $(By.cssSelector("div#narrow-by-list li.item>a[href$='general=122']")).click();
        $(byXpath("//a[@id='mode-list']")).click();
        $(byXpath("//*[@id='sorter']/option[attribute::value ='price']")).click();
       $(byXpath("//div[@class = 'swatch-opt-270']/child::div/div[attribute::aria-label = 'Size']/div[@id='option-label-size-143-item-167']")).click();
       $(byXpath("//div[@class = 'swatch-opt-270']/child::div/div[attribute::aria-label = 'Color']/div[@id='option-label-color-93-item-58']")).click();
        $(byXpath("//form[attribute::data-product-sku='MJ01']/button[attribute::type = 'submit']")).click();
        Thread.sleep(3000);
        $(byCssSelector("div.minicart-wrapper")).click();
        Thread.sleep(3000);
        $("div.block-content div.product-item-details").shouldHave(text("Beaumont Summit Kit"));
        $(By.cssSelector("a.action.delete")).click();
        Thread.sleep(3000);
        $("div#modal-content-103").shouldHave(text(question));
        $(By.cssSelector("footer.modal-footer button.action-primary.action-accept")).click();
        $("#ui-id-1").shouldHave(text(message));
        Thread.sleep(3000);

        System.out.println("Happy Pass");
    }


}

