package by.clevertec.utils;

import by.clevertec.model.Animal;
import by.clevertec.model.Student;
import by.clevertec.utils.AnimalBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestData {

    private static final List<String> COUNTRIES = Arrays.asList(
            "Japanese", "Hungarian", "Brazilian", "Indonesian", "Russian"
    );

    public static int getRandomAge(int minAge, int maxAge) {
        return minAge + (new Random()).nextInt(maxAge-minAge);
    }

    public static String getRandomCountry() {
        int index = new Random().nextInt(COUNTRIES.size());
        return COUNTRIES.get(index);
    }

    public static List<Animal> getEmptyAnimalsList() {
        return List.of();
    }

    public static List<Animal> generateNonValidateAnimals() {

        return (new Random()).ints(50)
                .mapToObj(i -> (new AnimalBuilder()).build())
                .collect(Collectors.toList());
    }

    public static List<Animal> generateValidateAnimalsForTask3() {
        return List.of(
                (new AnimalBuilder()).setAge(getRandomAge(30,100)).setOrigin("Angora").build(),
                (new AnimalBuilder()).setAge(getRandomAge(30,100)).setOrigin("Australia").build(),
                (new AnimalBuilder()).setAge(getRandomAge(30,100)).setOrigin("America").build(),
                (new AnimalBuilder()).setAge(getRandomAge(0,100)).setOrigin(getRandomCountry()).build(),
                (new AnimalBuilder()).setAge(getRandomAge(0,100)).setOrigin(getRandomCountry()).build()

        );
    }

    public static List<String> getExpectedDataForTask3() {
        return List.of("Angora", "Australia", "America" );
    }

    public static List<Animal> generateValidateAnimalsForTask4() {
        return List.of(
                (new AnimalBuilder()).setGender("Female").build(),
                (new AnimalBuilder()).setGender("Female").build(),
                (new AnimalBuilder()).setGender("Male").build()

        );
    }
    public static long getExpectedDataForTask4() {
        return 2L;
    }

    public static List<Animal> generateValidateAnimalsForTask5() {
        return List.of(
                (new AnimalBuilder()).setAge(21).setOrigin("Hungarian").build(),
                (new AnimalBuilder()).build(),
                (new AnimalBuilder()).build()

        );
    }

    public static List<Animal> generateValidateAnimalsForTask6() {
        return List.of(
                (new AnimalBuilder()).setGender("Male").build(),
                (new AnimalBuilder()).setGender("Female").build()
        );
    }
    public static List<Animal> generateValidateAnimalsForTask7() {
        return List.of(
                (new AnimalBuilder()).setOrigin("Oceania").build(),
                (new AnimalBuilder()).build()
        );
    }

    public static List<Animal> generateValidateAnimalsForTask9() {
        return List.of(
                (new AnimalBuilder()).setBreed("Lion").build(),
                (new AnimalBuilder()).setBreed("Cat").build(),
                (new AnimalBuilder()).setBreed("Elephant").build()
        );
    }

    public static int getExpectedDataForTask9() {
        return 3;
    }

    public static List<Animal> generateValidateAnimalsForTask10() {
        return List.of(
                new AnimalBuilder().setAge(5).build(),
                new AnimalBuilder().setAge(10).build(),
                new AnimalBuilder().setAge(7).build()
        );
    }

    public static int getExpectedTotalAgeForTask10() {
        return 22;
    }
    public static List<Animal> generateValidateAnimalsForTask11() {
        return List.of(
                new AnimalBuilder().setAge(3).setOrigin("Indonesian").build(),
                new AnimalBuilder().setAge(7).setOrigin("Indonesian").build(),
                new AnimalBuilder().build()
        );
    }

    public static double getExpectedAverageAgeForTask11() {
        return 5.0;
    }

    public static List<Student> getEmptyStudentList() {
        return List.of();
    }
    public static List<Student> generateStudentsForTask16() {
        return List.of(
                (new StudentBuilder()).setSurname("Ivanov").setAge(17).build(),
                (new StudentBuilder()).setSurname("Petrov").setAge(25).build(),
                (new StudentBuilder()).setSurname("Sidorov").setAge(13).build(),
                (new StudentBuilder()).setSurname("Kuznetsov").setAge(18).build()
        );
    }

    public static List<String> getExpectedStudentListForTask16() {
        return List.of("Ivanov - 17", "Sidorov - 13");
    }


    public static List<Student> generateStudentsForTask17() {
        return List.of(
                (new StudentBuilder()).setGroup("17-c").build(),
                (new StudentBuilder()).setGroup("18-c").build(),
                (new StudentBuilder()).setGroup("17-c").build()
        );
    }

    public static List<String> getExpectedStudentListForTask17() {
        return List.of("17-c", "18-c");
    }
}
