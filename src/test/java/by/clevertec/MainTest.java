package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Student;
import by.clevertec.util.Util;
import by.clevertec.utils.TestData;
import by.clevertec.utils.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Nested
    class Task3Test{
        @Test
        public void shouldReturnExpectedResults_withValidAnimals() {
            List<Animal> testAnimals = TestData.generateValidateAnimalsForTask3();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            List<String> result = Main.task3();
            assertEquals(TestData.getExpectedDataForTask3(), result);
        }
        @Test
        public void shouldReturnEmptyList_withNonValidAnimals() {
            List<Animal> testAnimals = TestData.generateNonValidateAnimals();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            List<String> result = Main.task3();
            assertEquals(List.of(), result);
        }
        @Test
        public void shouldReturnEmptyList_withEmptyList() {
            List<Animal> testAnimals = TestData.getEmptyAnimalsList();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            List<String> result = Main.task3();
            assertEquals(List.of(), result);
        }
    }


    @Nested
    class Task4Test {
        @Test
        public void shouldReturnExpectedResults_withValidAnimals() {
            List<Animal> testAnimals = TestData.generateValidateAnimalsForTask4();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            long result = Main.task4();
            assertEquals(TestData.getExpectedDataForTask4(), result);
        }

        @Test
        public void shouldReturnZero_withEmptyList() {
            List<Animal> testAnimals = TestData.getEmptyAnimalsList();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            long result = Main.task4();
            assertEquals(0, result);
        }
    }


    @Nested
    class Task5Test {
        @Test
        public void shouldReturnTrue_withValidAnimals() {
            List<Animal> testAnimals = TestData.generateValidateAnimalsForTask5();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            boolean result = Main.task5();
            assertTrue(result);
        }
        @Test
        public void shouldReturnFalse_withEmptyList() {
            List<Animal> testAnimals = TestData.getEmptyAnimalsList();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            boolean result = Main.task5();
            assertFalse(result);
        }
    }

    @Nested
    class Task6Test {
        @Test
        public void shouldReturnTrue_withValidAnimals() {
            List<Animal> testAnimals = TestData.generateValidateAnimalsForTask6();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            boolean result = Main.task6();
            assertTrue(result);
        }

        @Test
        public void shouldReturnFalse_withEmptyList() {
            List<Animal> testAnimals = TestData.getEmptyAnimalsList();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            boolean result = Main.task6();
            assertFalse(result);
        }

        @Test
        public void shouldReturnFalse_withNonValidDate() {
            List<Animal> testAnimals = TestData.generateNonValidateAnimals();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            boolean result = Main.task6();
            assertFalse(result);
        }
    }

    @Nested
    class Task7Test {
        @Test
        public void shouldReturnFalse_withValidAnimals() {
            List<Animal> testAnimals = TestData.generateValidateAnimalsForTask7();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            boolean result = Main.task6();
            assertFalse(result);
        }

        @Test
        public void shouldReturnTrue_withEmptyList() {
            List<Animal> testAnimals = TestData.getEmptyAnimalsList();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            boolean result = Main.task6();
            assertFalse(result);
        }

        @Test
        public void shouldReturnTrue_withNonValidData() {
            List<Animal> testAnimals = TestData.generateNonValidateAnimals();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            boolean result = Main.task6();
            assertFalse(result);
        }
    }

    @Nested
    class Task9Tests {

        @Test
        public void shouldReturnsShortestBreedLength_withValidAnimals() {
            List<Animal> testAnimals = TestData.generateValidateAnimalsForTask9();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            int result = Main.task9();
            assertEquals(TestData.getExpectedDataForTask9(), result);
        }

        @Test
        public void shouldReturnsZero_withEmptyList() {
            List<Animal> testAnimals = TestData.getEmptyAnimalsList();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            int result = Main.task9();
            assertEquals(0, result);
        }
    }
    @Nested
    class Task10Test {
        @Test
        public void shouldReturnsCorrectTotalAge_withValidAnimals() {
            List<Animal> testAnimals = TestData.generateValidateAnimalsForTask10();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            int result = Main.task10();
            assertEquals(TestData.getExpectedTotalAgeForTask10(), result);
        }

        @Test
        public void shouldReturnsZero_withEmptyList() {
            List<Animal> testAnimals = TestData.getEmptyAnimalsList();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            int result = Main.task10();
            assertEquals(0, result);
        }

    }

    @Nested
    class Task11Test {

        @Test
        public void shouldReturnsCorrectAverageAge_withValidAnimals() {
            List<Animal> testAnimals = TestData.generateValidateAnimalsForTask11();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            double result = Main.task11();
            assertEquals(TestData.getExpectedAverageAgeForTask11(), result, 0.01);
        }

        @Test
        public void shouldReturnsZero_withEmptyList() {
            List<Animal> testAnimals = TestData.getEmptyAnimalsList();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            double result = Main.task11();
            assertEquals(0.0, result, 0.01);
        }

        @Test
        public void shouldReturnsZero_withNoIndonesianAnimals() {
            List<Animal> testAnimals = TestData.generateNonValidateAnimals();

            mockedUtil.when(Util::getAnimals).thenReturn(testAnimals);

            double result = Main.task11();
            assertEquals(0.0, result, 0.01);
        }
    }

    @Nested
    class Task16Test {
        @Test
        public void shouldSoutSortedStudentsUnder18_withStudents() {
            List<Student> testStudents = TestData.generateStudentsForTask16();

            mockedUtil.when(Util::getStudents).thenReturn(testStudents);

            String output = TestUtils.catchSystemOut(Main::task16);

            List<String> expectedOutput = TestData.getExpectedStudentListForTask16();

            for (String e : expectedOutput) {
                assertTrue(output.contains(e));
            }
        }

        @Test
        public void shouldSoutEmptyList_withEmptyList() {
            List<Student> testStudents = TestData.getEmptyStudentList();

            mockedUtil.when(Util::getStudents).thenReturn(testStudents);

            String output = TestUtils.catchSystemOut(Main::task16);

            assertEquals("",output);
        }
    }

    @Nested
    class Task17Test {
        @Test
        public void shouldSoutSortedStudentsUnder18_withStudents() {
            List<Student> testStudents = TestData.generateStudentsForTask17();

            mockedUtil.when(Util::getStudents).thenReturn(testStudents);

            String output = TestUtils.catchSystemOut(Main::task17);

            List<String> expectedData = TestData.getExpectedStudentListForTask17();
            for(String e : expectedData) {
                assertTrue(output.contains(e));
            }
        }

        @Test
        public void shouldSoutEmptyList_withEmptyList() {
            List<Student> testStudents = TestData.getEmptyStudentList();

            mockedUtil.when(Util::getStudents).thenReturn(testStudents);

            String output = TestUtils.catchSystemOut(Main::task16);

            assertEquals("",output);
        }
    }

}




