package utiles;

import com.github.javafaker.Faker;

public class MobileDataGenerator {
    public static Faker faker = new Faker();

    public static String getPhoneNo() {
        int randomNumber = faker.number().numberBetween(10000000, 99999999);
        return String.valueOf(randomNumber);
    }

    public static String getRandomNumber() {
        int randomNumber = faker.number().numberBetween(000000, 999999);
        return String.valueOf(randomNumber);
    }
}