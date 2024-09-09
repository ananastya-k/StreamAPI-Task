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
        assertEquals(TestData.getExpectedData(), result);
    }
    @Test
    public void testTask1WithEmptyList() {
        List<Animal> testAnimals = TestData.getEmptyListAnimals();

        mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

        List<Animal> result = Main.task1();
        assertEquals(TestData.getEmptyListAnimals(), result);
    }

}

