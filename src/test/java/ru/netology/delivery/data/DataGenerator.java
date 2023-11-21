package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        String[] cities = new String[]{"Москва", "Великий Новгород", "Нижний Новгород", "Орёл",
                "Ростов-на-Дону", "Пенза", "Саранск", "Ульяновск", "Челябинск", "Екатеринбург"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String local) {
        String firstName = new Faker(new Locale(local)).name().firstName();
        String lastName = new Faker(new Locale(local)).name().lastName();
        return firstName + " " + lastName;
    }

    public static String generatePhone(String local) {
        return new Faker(new Locale(local)).phoneNumber().phoneNumber().replace("+", "")
                .replace("(", "").replace(")", "")
                .replaceAll("-", "");
    }

    public static class Registration {
        private Registration() {

        }

        public static UserInfo generateUser(String local) {
            return new UserInfo(generateCity(), generateName(local), generatePhone(local));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
