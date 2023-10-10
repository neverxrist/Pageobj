package utils;
import com.github.javafaker.Faker;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static org.apache.commons.lang3.StringUtils.length;

public class RandomUtils {
    static Faker faker = new Faker();
    public static String state;
    public static String getRandomNumbers(int len) {

        String AB = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomDay(int min, int max) {
        String day = String.valueOf(ThreadLocalRandom.current().nextInt(min, max + 1));
        if (length(day) < 2) {
            day = "0" + day;
        }
        return day;
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return faker.options().option(genders);
    }

    public static String getRandomSubject() {
        String[] subject = {"Maths", "Chemistry", "Hindi"};
        return faker.options().option(subject);
    }

    public static String getRandomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        return faker.options().option(month);
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        state = faker.options().option(states);
        return state;
    }


    public static String getRandomCity() {
        String city = null;
        if (Objects.equals(state, "NCR")) {
            String[] cities = {"Delhi", "Gurgaon", "Noida"};
            city = faker.options().option(cities);
        }
        if (Objects.equals(state, "Uttar Pradesh")) {
            String[] cities = {"Agra", "Lucknow", "Merrut"};
            city = faker.options().option(cities);
        }
        if (Objects.equals(state, "Haryana")) {
            String[] cities = {"Karnal", "Panipat"};
            city = faker.options().option(cities);
        }
        if (Objects.equals(state, "Rajasthan")) {
            String[] cities = {"Jaipur", "Jaiselmer"};
            city = faker.options().option(cities);
        }

        return city;
    }


}