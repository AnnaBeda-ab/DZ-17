package utils;

import net.datafaker.Faker;

public class MyRandomData {
    public static int getRandomNumber() {
        Faker faker = new Faker();
        int randomNumber = faker.number().numberBetween(1, 5000);
        return randomNumber;
    }
}
