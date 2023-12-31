package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    SelenideElement titleLabel = $(".practice-form-wrapper");
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement genderWrapper = $("#genterWrapper");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    SelenideElement uploadPictureInput = $("#uploadPicture");
    SelenideElement currentAddressTextArea = $("#currentAddress");
    SelenideElement selectStateDropdown = $("#state");
    SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    SelenideElement selectCityDropdown = $("#city");
    SelenideElement submitButton = $("#submit");


    public RegistrationPage openPage(String pageAddress) {
        open(pageAddress);
        return this;
    }

    public RegistrationPage checkLabel(String text){
        titleLabel.shouldHave(text(text));
        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage selectHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadImage(String fileName) {
        uploadPictureInput.uploadFromClasspath("image/" + fileName);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddressTextArea.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        selectStateDropdown.click();
        stateCityWrapper.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        selectCityDropdown.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

}