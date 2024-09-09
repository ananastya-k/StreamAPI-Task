package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    /**
     * Из представленных животных отобрать все молодые особи от 10 до 20 лет
     * и отсортировать по возрасту (по возрастанию)
     * далее - распределить по 7 на каждый зоопарк.
     * Зоопарков неограниченное кол-во, а вы - директор 3-го по счёту зоопарка.
     * Полученных животных вывести в консоль.
     */
    public static List<Animal> task1() {
        List<Animal> animals = Util.getAnimals();
        int animalsInZoo = 7;

        List<Animal> animalsAtThirdZoo = animals.stream()
                .filter(animal -> animal.getAge() > 10 && animal.getAge() < 20)
                .sorted(Comparator.comparing(Animal::getAge))
                .skip(2 * animalsInZoo)
                .limit(animalsInZoo)
                .toList();

        animalsAtThirdZoo.forEach(System.out::println);
        return animalsAtThirdZoo;

    }

    /**
     * Отобрать всех животных из Японии (Japanese)
     * и записать породу UPPER_CASE в если пол Female
     * преобразовать к строкам породы животных и вывести в консоль
     */
    public static List<String> task2() {
        List<Animal> animals = Util.getAnimals();

        List<String> breeds = animals.stream()
                .filter(animal -> animal.getOrigin().equalsIgnoreCase("Japanese"))
                .peek(animal -> {
                    if (animal.getGender().equalsIgnoreCase("Female")) {
                        animal.setBread(animal.getBread().toUpperCase());
                    }
                })
                .map(Animal::getBread)
                .toList();

        breeds.forEach(System.out::println);
        return breeds;
    }

    /**
     * Отобрать всех животных старше 30 лет
     * и вывести все страны происхождения без дубликатов начинающиеся на "A"
     */
    public static List<String> task3() {
        List<Animal> animals = Util.getAnimals();

        List<String> countriesStartWithA = animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .toList();

        countriesStartWithA.forEach(System.out::println);
        return countriesStartWithA;

    }

    /**
     * Подсчитать количество всех животных пола = Female.
     * Вывести в консоль
     */
    public static long task4() {
        List<Animal> animals = Util.getAnimals();

        long countFemaleAnimals = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();

        System.out.println("countFemaleAnimals = " + countFemaleAnimals);
        return countFemaleAnimals;
    }

    /**
     * Взять всех животных возрастом 20 - 30 лет.
     * Есть ли среди нах хоть один из страны Венгрия (Hungarian)?
     * Ответ вывести в консоль
     */
    public static boolean task5() {
        List<Animal> animals = Util.getAnimals();

        boolean isThereOldHungarian = animals.stream()
                .filter(animal -> animal.getAge() > 20 && animal.getAge() < 30)
                .anyMatch(origin -> origin.getOrigin().equals("Hungarian"));

        System.out.println("isThereOldHungarian = " + isThereOldHungarian);
        return isThereOldHungarian;
    }

    /**
     * Взять всех животных.
     * Все ли они пола Male и Female ?
     * Ответ вывести в консоль
     */
    public static long task6() {
        List<Animal> animals = Util.getAnimals();

        long countAnimalsOtherGender = animals.stream()
                .filter(animal -> !animal.getGender().equals("Male") && !animal.getGender().equals("Female"))
                .count();

        System.out.println("countAnimalsOtherGender = " + countAnimalsOtherGender);
        return countAnimalsOtherGender;
    }

    /**
     * Взять всех животных.
     * Узнать что ни одно из них не имеет страну происхождения Oceania.
     * Ответ вывести в консоль
     */
    public static boolean task7() {
        List<Animal> animals = Util.getAnimals();

        boolean isFromOceania = animals.stream()
                .anyMatch(animal -> animal.getOrigin().equals("Oceania"));

        System.out.println("isFromOceania = " + isFromOceania);
        return isFromOceania;
    }

    /**
     * Взять всех животных.
     * Отсортировать их породу в стандартном порядке и взять первые 100.
     * Вывести в консоль возраст самого старого животного
     */
    public static int task8() {
        List<Animal> animals = Util.getAnimals();

        int maxAge = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .mapToInt(Animal::getAge)
                .max()
                .orElse(0);

        System.out.println("maxAge = " + maxAge);
        return maxAge;
    }

    /**
     * Взять всех животных.
     * Преобразовать их в породы, а породы в []char
     * Вывести в консоль длину самого короткого массива
     */
    public static int task9() {
        List<Animal> animals = Util.getAnimals();

        int minCharArrayLength = animals.stream()
                .map(animal -> animal.getBread().toCharArray())
                .map(charA -> charA.length)
                .min(Comparator.naturalOrder())
                .orElse(0);

        System.out.println("minCharArrayLength = " + minCharArrayLength);
        return minCharArrayLength;
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
//        animals.stream() Продолжить ...
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();
//        persons.stream() Продолжить ...
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
//        houses.stream() Продолжить ...
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
//        students.stream() Продолжить ...
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}