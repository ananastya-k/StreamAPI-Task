package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

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

        System.out.println("\nAnimals at the third zoo:");
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

        System.out.println("\nBreeds of Japanese animals:");
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

        System.out.println("\nCountries of origin starting with 'A':");
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

        System.out.println("\nTotal number of Female animals: " + countFemaleAnimals);
        return countFemaleAnimals;
    }

    /**
     * Взять всех животных возрастом 20 - 30 лет.
     * Есть ли среди нах хоть один из страны Венгрия (Hungarian)?
     * Ответ вывести в консоль
     */
    public static boolean task5() {
        List<Animal> animals = Util.getAnimals();

        boolean hasHungarian = animals.stream()
                .filter(animal -> animal.getAge() > 20 && animal.getAge() < 30)
                .anyMatch(origin -> origin.getOrigin().equals("Hungarian"));

        System.out.printf("\nIs there a Hungarian animal among those aged 20-30? %b%n", hasHungarian);
        return hasHungarian;
    }

    /**
     * Взять всех животных.
     * Все ли они пола Male и Female ?
     * Ответ вывести в консоль
     */
    public static long task6() {
        List<Animal> animals = Util.getAnimals();

        long countOtherGender = animals.stream()
                .filter(animal -> !animal.getGender().equals("Male") && !animal.getGender().equals("Female"))
                .count();

        System.out.printf("\nNumber of animals with gender other than Male or Female: %d%n", countOtherGender);
        return countOtherGender;
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

        System.out.printf("\nIs there an animal from Oceania? %b%n", isFromOceania);
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

        System.out.printf("\nAge of the oldest animal among the first 100 sorted by breed: %d%n", maxAge);
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

        System.out.printf("\nLength of the shortest character array representing breed: %d%n", minCharArrayLength);
        return minCharArrayLength;
    }

    /**
     * Взять всех животных.
     * Подсчитать суммарный возраст всех животных.
     * Вывести результат в консоль
     */
    public static int task10() {
        List<Animal> animals = Util.getAnimals();

        int totalAge = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();

        System.out.printf("\nTotal age of all animals: %d%n", totalAge);
        return totalAge;
    }

    /**
     * Взять всех животных.
     * Подсчитать средний возраст всех животных из индонезии (Indonesian).
     * Вывести результат в консоль
     */
    public static double task11() {
        List<Animal> animals = Util.getAnimals();

        double avgAgeIndonesian = animals.stream()
                    .filter(animal -> animal.getOrigin().equals("Indonesian"))
                    .mapToInt(Animal::getAge)
                    .average()
                    .orElse(0);

        System.out.printf("\nAverage age of Indonesian animals: %.2f%n", avgAgeIndonesian);
        return avgAgeIndonesian;
    }

    /**
     * Во Французский легион принимают людей со всего света,
     * но есть отбор по полу (только мужчины) возраст от 18 до 27 лет.
     * Преимущество отдаётся людям военной категории 1,
     * на втором месте - военная категория 2, и на третьем месте военная категория 3.
     *
     * Отсортировать всех подходящих кандидатов в порядке их приоритета по военной категории.
     * Однако взять на обучение академия может только 200 человек. Вывести их в консоль.
     */
    public static void task12() {
        List<Person> persons = Util.getPersons();

        persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> (getYears(person) >= 18) && (getYears(person) <= 27))
                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(person -> System.out.printf("Gender: %s | Group: %d | DOB: %s\n",
                        person.getGender(),person.getRecruitmentGroup(),person.getDateOfBirth()));
    }

    private static double getYears(Person person) {
        return Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
    }

    /**
     * Надвигается цунами и в районе эвакуации требуется
     * в первую очередь обойти дома и эвакуировать больных и раненых (из Hospital),
     * во вторую очередь детей и стариков (до 18 и пенсионного возраста) а после всех остальных.
     * В первый этап эвакуации мест в эвакуационном транспорте только 500.
     * Вывести всех людей попадающих в первый этап эвакуации в порядке приоритета (в консоль).
     */
    public static void task13() {
        List<House> houses = Util.getHouses();
        int countForEvacuation = 500;
        System.out.println("\nEvacuated people: ");
        houses.stream()
                .flatMap(house -> house.getPersonList().stream()
                        .map(person -> new AbstractMap.SimpleEntry<>(
                                settingPriority(house.getBuildingType(), person), person)))
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .limit(countForEvacuation)
                .forEach(System.out::println);

    }

    public static int settingPriority(String buildingType, Person person) {
        if (buildingType.equals("Hospital")) {
            return 1;
        }
        if ( getYears(person) < 18 ||  getYears(person) > 64) {
            return 2;
        }
        return 3;
    }

    /**
     * Из перечня автомобилей приходящих на рынок Азии логистическому агентству предстоит
     * отсортировать их в порядке следования
     * 1.Туркменистан - 2.Узбекистан - 3.Казахстан - 4.Кыргызстан - 5.Россия - 6.Монголия.
     * Все автомобили марки "Jaguar" а так же все авто цвета White идут в первую страну.
     * Из оставшихся все автомобили с массой до 1500 кг и марок BMW, Lexus, Chrysler и Toyota идут во второй эшелон.
     * Из оставшихся все автомобили Черного цвета с массой более 4000 кг и все GMC и Dodge идут в третий эшелон.
     * Из оставшихся все автомобили года выпуска до 1982 или все модели "Civic" и "Cherokee" идут в четвёртый эшелон.
     * Из оставшихся все автомобили цветов НЕ Yellow, Red, Green и Blue или же по стоимости дороже 40000 в пятый эшелон
     * Из оставшиеся все автомобили в vin номере которых есть цифра "59" идут в последний шестой эшелон.
     * Оставшиеся автомобили отбрасываем, они никуда не идут.
     * Измерить суммарные массы автомобилей всех эшелонов для каждой из стран
     * и подсчитать сколько для каждой страны будет стоить транспортные расходы
     * если учесть что на 1 тонну транспорта будет потрачено 7.14 $.
     * Вывести суммарные стоимости в консоль. Вывести общую выручку логистической кампании.
     */
    public static void task14() {
        List<Car> cars = Util.getCars();

        double totalRevenue = cars.stream()
                .collect(Collectors.groupingBy(Main::determineCarCategory))
                .entrySet()
                .stream()
                .filter(esh -> esh.getKey() != 0)
                .mapToDouble(esh -> {
                    double totalWeight = (double) esh.getValue().stream().mapToInt(Car::getMass).sum() /1000;
                    double transportCosts = totalWeight * 7.14;

                    System.out.printf("Echelon %d: Transport cost = %.2f%n",esh.getKey(), transportCosts);
                    return esh.getValue().stream().mapToInt(Car::getPrice).sum() - transportCosts;
                })
                .sum();

        System.out.printf("\nTotal revenue: %.2f%n", totalRevenue);

    }
    public static int determineCarCategory(Car car) {
        List<String> secondEchelon = new ArrayList<>(Arrays.asList("BMW", "Chrysler", "Lexus", "Toyota"));
        List<String> thirdEchelon = new ArrayList<>(Arrays.asList("GMC", "Dodge"));
        List<String> forthEchelon = new ArrayList<>(Arrays.asList("Civic", "Cherokee"));

        if (car.getCarMake().equals("Jaguar") || car.getColor().equals("White")) {
            return 1;
        }
        if (secondEchelon.contains(car.getCarMake()) || car.getMass() < 1500) {
            return 2;
        }
        if ((car.getColor().equals("Black") && car.getMass()>4000) || thirdEchelon.contains(car.getCarMake())) {
            return 3;
        }
        if (car.getReleaseYear() < 1982 || forthEchelon.contains(car.getCarModel())) {
            return 4;
        }
        if (!Arrays.asList("Yellow", "Red", "Green", "Blue").contains(car.getColor()) || car.getPrice() > 40000) {
            return 5;
        }
        if (car.getVin().endsWith("59")) {
            return 6;
        }else return 0;
    }

    /**
     * Для оранжереи нужно подобрать растения соответствующие требованиям.
     * Во-первых, нужно произвести сложную сортировку каталога растений.
     * Отсортировать их по странам происхождения в обратном порядке
     * После по стоимости и еще по водопотреблению в обратном порядке.
     * Из этого списка взять растения название которых от буквы "S" до буквы "C".
     * Если растения тенелюбивые и им подходит горшок из стекла, алюминия или стали - то выбираем их.
     * Далее на каждое растение надо рассчитать стоимость растения
     * + стоимость потребления воды за 5 лет c учётом того что кубометр воды стоит 1.39 $.
     * Суммировать общую стоимость обслуживания всех растений. Во сколько это обойдётся бюджету?
     */
    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
        
        double totalCostService  = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin)
                        .reversed()
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Flower::getWaterConsumptionPerDay)
                        .reversed())
                .filter(Flower::isShadePreferred)
                .filter(Main::checkFlower)
                .mapToDouble(flower -> flower.getPrice() + flower.getWaterConsumptionPerDay() * 1.39 * (365 * 4 + 366))
                .sum();


        System.out.printf("\nTotal cost of service = %.2f\n", totalCostService);
    }

    private static boolean checkFlower(Flower flower) {
        return checkVase(flower) && checkName(flower);
    }

    private static boolean checkVase(Flower flower) {
        return flower.getFlowerVaseMaterial().contains("Glass")
                || flower.getFlowerVaseMaterial().contains("Aluminum")
                || flower.getFlowerVaseMaterial().contains("Steel");
    }

    private static boolean checkName(Flower flower) {
        String name = flower.getCommonName().toUpperCase();
        return name.charAt(0) >= 'C' && name.charAt(0) <= 'S';
    }


    /**
     * Вывод списка студентов младше 18 лет в алфавитном порядке с указанием возраста
     */
    public static void task16() {
        List<Student> students = Util.getStudents();

        students.stream()
                .filter(student -> student.getAge() < 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .forEach(student -> System.out.println(student.getSurname() + " - " + student.getAge()));
    }

    /**
     * Вывод списка групп (без повторений).
     */
    public static void task17() {
        List<Student> students = Util.getStudents();

        students.stream()
                .map(Student::getGroup)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * Определение среднего возраста студентов для каждого факультета.
     * Выводить название факультета и средний возраст в порядке убывания возраста.
     */
    public static void task18() {
        List<Student> students = Util.getStudents();

        students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty,
                Collectors.averagingDouble(Student::getAge)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

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