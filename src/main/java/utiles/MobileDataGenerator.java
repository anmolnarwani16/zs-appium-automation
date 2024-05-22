package utiles;

import com.github.javafaker.Faker;

public class MobileDataGenerator {
    public static Faker faker = new Faker();

    public static String getPhoneNo() {
        int randomNumber = faker.number().numberBetween(10000000, 99999999);
        // Convert the number to a string and return it
        return String.valueOf(randomNumber);
    }
}