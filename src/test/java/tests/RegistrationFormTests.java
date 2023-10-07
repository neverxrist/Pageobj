package tests;
import org.junit.jupiter.api.Test;
import components.RegistrationPage;
import components.VerifyTextResultComponent;

public class RegistrationFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    VerifyTextResultComponent verifyTextResultComponent = new VerifyTextResultComponent();

    public static final String AUTOMATION_PRACTICE_URL = "/automation-practice-form";
    public static final String FIRST_NAME = "Andrey";
    public static final String SECOND_NAME = "NEVERMIND";
    public static final String USER_EMAIL = "QATEST@QA.RU";
    public static final String GENDER = "Male";
    public static final String USER_NUMBER = "8005553535";
    public static final String YYYY = "2000";
    public static final String MM = "June";
    public static final String DD = "29";
    public static final String SUBJECT = "Physics";
    public static final String HOBBY = "Music";
    public static final String IMAGE = "with_day_of_day.jpg";
    public static final String STATE = "Uttar Pradesh";
    public static final String CITY = "Lucknow";
    public static final String CURRENT_ADDRESS = "NEVERMIND 541231";
    public static final String TEXT_IN_RESULT_WINDOW = "Thanks for submitting the form";
    public static final String LABEL_TEXT= "Student Registration Form";

    @Test
    void fillAllFormsAndVerifyResultTest() {
        registrationPage.openPage(AUTOMATION_PRACTICE_URL)
                .removeBanner()
                .checkLabel(LABEL_TEXT)
                .setFirstName(FIRST_NAME)
                .setLastName(SECOND_NAME)
                .setEmail(USER_EMAIL)
                .setGender(GENDER)
                .setUserNumber(USER_NUMBER)
                .setDateOfBirth(DD, MM, YYYY)
                .setSubject(SUBJECT)
                .selectHobby(HOBBY)
                .uploadImage(IMAGE)
                .setAddress(CURRENT_ADDRESS)
                .setState(STATE)
                .setCity(CITY)
                .clickSubmitButton();
        verifyTextResultComponent.checkResultWindowHaveText(TEXT_IN_RESULT_WINDOW)
                .verifyTableResult(FIRST_NAME + " " + SECOND_NAME)
                .verifyTableResult(USER_EMAIL)
                .verifyTableResult(GENDER)
                .verifyTableResult(USER_NUMBER)
                .verifyTableResult(DD + " " + MM + "," + YYYY)
                .verifyTableResult(SUBJECT)
                .verifyTableResult(HOBBY)
                .verifyTableResult(IMAGE)
                .verifyTableResult(CURRENT_ADDRESS)
                .verifyTableResult(STATE + " " + CITY);
    }

}