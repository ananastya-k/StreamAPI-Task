package by.clevertec;

import by.clevertec.model.Animal;

import java.util.Arrays;
import java.util.List;

public class TestData {

    public static List<Animal> getTestAnimals() {
        return Arrays.asList(
                new Animal(1, "Javan gold-spotted mongoose", 17, "Maltese" ,"Genderqueer"),
                new Animal(2, "Asian lion", 9, "Telugu" ,"Female"),
                new Animal(3, "Red meerkat", 15, "Japanese" ,"Female"),
                new Animal(4, "Kookaburra", 4, "Maltese" ,"Male"),
                new Animal(5, "Dabchick", 45, "Japanese" ,"Male"),
                new Animal(6, "Bontebok", 12, "Japanese" ,"Female"),
                new Animal(7, "Nilgai", 54, "Telugu" ,"Female"),
                new Animal(8, "Blue fox", 15, "Japanese" ,"Genderqueer"),
                new Animal(9, "Rabbit", 14, "Azeri" ,"Male"),
                new Animal(10, "Kangaroo", 16, "Maltese" ,"Female"),
                new Animal(11, "Bear", 18, "Belarusian" ,"Male"),
                new Animal(12, "Lion", 19, "Belarusian" ,"Female"),
                new Animal(13, "Koala", 12, "Japanese" ,"Female"),
                new Animal(14, "Tiger", 11, "Maltese" ,"Genderqueer"),
                new Animal(15, "Gorilla", 14, "Maltese" ,"Female"),
                new Animal(16, "Rhinoceros", 16, "Telugu" ,"Male"),
                new Animal(17, "Hippopotamus", 17, "Japanese" ,"Female"),
                new Animal(18, "Leopard", 15, "Japanese" ,"Male"),
                new Animal(19, "Penguin", 19, "Azeri" ,"Male"),
                new Animal(20, "Dolphin", 12, "Belarusian" ,"Female"),
                new Animal(21, "Cheetah", 14, "Japanese" ,"Female"),
                new Animal(22, "Monkey", 6, "Azeri" ,"Female"),
                new Animal(23, "Panda", 15, "Maltese" ,"Male"),
                new Animal(24, "Giraffe", 71, "Azeri" ,"Male"),
                new Animal(25, "Fox", 21, "Japanese" ,"Female")
                );
    }

    public static List<Animal> getEmptyListAnimals() {
        return Arrays.asList();
    }

    public static List<Animal> getExpectedData() {
        return Arrays.asList(
                new Animal(17, "Hippopotamus", 17, "Japanese" ,"Female"),
                new Animal(11, "Bear", 18, "Belarusian" ,"Male"),
                new Animal(12, "Lion", 19, "Belarusian" ,"Female"),
                new Animal(19, "Penguin", 19, "Azeri" ,"Male")
                );
    }
}
