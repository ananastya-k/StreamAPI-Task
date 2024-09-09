package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    private MockedStatic<Util> mockedUtil;

    @BeforeEach
    public void setUp() {
        mockedUtil = Mockito.mockStatic(Util.class);
    }

    @AfterEach
    public void tearDown() {
        mockedUtil.close();
    }

    @Test
    public void testTask1() {
        List<Animal> testAnimals = TestData.getTestAnimals();

        mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

        List<Animal> result = Main.task1();
        assertEquals(TestData.getExpectedDataTask1(), result);
    }
    @Test
    public void testTask1WithEmptyList() {
        List<Animal> testAnimals = TestData.getEmptyListAnimals();

        mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

        List<Animal> result = Main.task1();
        assertEquals(TestData.getEmptyListAnimals(), result);
    }

    @Test
    public void testTask2() {
        List<Animal> testAnimals = TestData.getTestAnimals();

        mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

        List<String> result = Main.task2();
        assertEquals(TestData.getExpectedDataTask2(), result);
    }
    @Test
    public void testTask3() {
        List<Animal> testAnimals = TestData.getTestAnimals();

        mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

        List<String> result = Main.task3();
        assertEquals(TestData.getExpectedDataTask3(), result);
    }
    @Test
    public void testTask4() {
        List<Animal> testAnimals = TestData.getTestAnimals();

        mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

        long result = Main.task4();
        assertEquals(TestData.getExpectedDataTask4(), result);
    }
    @Test
    public void testTask5() {
        List<Animal> testAnimals = TestData.getTestAnimals();

        mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

        boolean result = Main.task5();
        assertEquals(TestData.getExpectedDataTask5(), result);
    }
    @Test
    public void testTask6() {
        List<Animal> testAnimals = TestData.getTestAnimals();

        mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

        long result = Main.task6();
        assertEquals(TestData.getExpectedDataTask6(), result);
    }

    @Test
    public void testTask7() {
        List<Animal> testAnimals = TestData.getTestAnimals();

        mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

        boolean result = Main.task7();
        assertEquals(TestData.getExpectedDataTask7(), result);
    }
}

