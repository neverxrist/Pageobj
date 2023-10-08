package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class VerifyTextResultComponent {


    SelenideElement resultWindowTitle = $("#example-modal-sizes-title-lg"),
            tableField = $(".table-responsive");


    public VerifyTextResultComponent checkResultWindowHaveText(String text) {
        resultWindowTitle.shouldHave(text(text));
        return this;
    }

    public VerifyTextResultComponent verifyTableResult(String text) {
        tableField.shouldHave(
                text(text));
        return this;
    }

}
