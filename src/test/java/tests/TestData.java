package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.RandomUtils.*;


public class TestData {
    Faker facker = new Faker(new Locale("en"));
    public String userEmail = facker.internet().emailAddress();
    Faker faker = new Faker(new Locale("uk"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String gender = getRandomGender();
    public String userNumber = getRandomNumbers(10);
    public String day = getRandomDay(10, 28);
    public String month = getRandomMonth();
    public String year = String.valueOf(getRandomInt(1920, 2023));
    public String subject = getRandomSubject();
    public String hobbies = getRandomHobbies();
    public String image = "with_day_of_day.jpg";
    public String address = faker.address().fullAddress();
    public String state = getRandomState() ;
    public String city = getRandomCity() ;


}