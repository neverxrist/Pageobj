package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.VerifyTextResultComponent;


public class RegFormTestsFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    VerifyTextResultComponent verifyTextResultComponent = new VerifyTextResultComponent();
    TestData testData = new TestData();
    public static final String AUTOMATION_PRACTICE_URL = "/automation-practice-form";
    public static final String TEXT_IN_RESULT_WINDOW = "Thanks for submitting the form";
    public static final String LABEL_TEXT= "Student Registration Form";


    @Test
    void fillAllFormsAndVerifyResultTest() {
        registrationPage.openPage(AUTOMATION_PRACTICE_URL)
                .removeBanner()
                .checkLabel(LABEL_TEXT)
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubject(testData.subject)
                .selectHobby(testData.hobbies)
                .uploadImage(testData.image)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .clickSubmitButton();
        verifyTextResultComponent.checkResultWindowHaveText(TEXT_IN_RESULT_WINDOW)
                .verifyTableResult(testData.firstName + " " + testData.lastName)
                .verifyTableResult(testData.userEmail)
                .verifyTableResult(testData.gender)
                .verifyTableResult(testData.userNumber)
                .verifyTableResult(testData.day + " " + testData.month + "," + testData.year)
                .verifyTableResult(testData.subject)
                .verifyTableResult(testData.hobbies)
                .verifyTableResult(testData.image)
                .verifyTableResult(testData.address)
                .verifyTableResult(testData.state + " " + testData.city);
    }

}