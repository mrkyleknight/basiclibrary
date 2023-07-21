package basiclibrary;

import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    @DisplayName("Rolling five dice")
    public void testRollWithPositiveN() {
        Library sut = new Library();
        int[] diceResults = sut.roll(5);
                assertNotNull(diceResults);
        assertEquals(5, diceResults.length);
        for (int roll : diceResults) {
            assertTrue(roll >= 1 && roll <= 6);
        }
        System.out.println(Arrays.toString(diceResults));
    }

    @Test
    @DisplayName("Contains Duplicates")
        public void testDuplicates() {
        Library sut = new Library();
        int[] testArr = {1, 2, 3, 4, 5, 1};
        boolean results = sut.containsDuplicates(testArr);
        assertTrue(results);

        }
    @Test
    @DisplayName("Does Not Contain Duplicates")
    public void testNoDuplicates() {
        Library sut = new Library();
        int[] testArr = {1, 2, 3, 4, 5};
        boolean results = sut.containsDuplicates(testArr);
        assertFalse(results);

    }


    @Test
    @DisplayName("Calculate Average")
    public void testCalculateAverage() {
        Library sut = new Library();
        int[] testArr = {1, 2, 3, 4, 5};
        double average = sut.calculateAverage(testArr);
        assertEquals(3.0, average);
    }

    @Test
    @DisplayName("Find Array With Lowest Average")
    public void testFindArrayWithLowestAverage() {
        Library sut = new Library();
        int[][] testArrays = {
                {66, 64, 58, 65, 71, 57, 60},
                {57, 65, 65, 70, 72, 65, 51},
                {55, 54, 60, 53, 59, 57, 61},
                {65, 56, 55, 52, 55, 62, 57}
        };
        int[] result = sut.findArrayWithLowestAverage(testArrays);
        assertArrayEquals(testArrays[2], result);
    }

    @Test
    public void testAnalyzeWeatherData() {
        Library library = new Library();
        int[][] weeklyMonthTemperatures = {
                {66, 64, 58, 65, 71, 57, 60},
                {57, 65, 65, 70, 72, 65, 51},
                {55, 54, 60, 53, 59, 57, 61},
                {65, 56, 55, 52, 55, 62, 57}
        };

        String expectedOutput = """
                High: 72
                Low: 51
                Never saw temperature: 63
                Never saw temperature: 67
                Never saw temperature: 68
                Never saw temperature: 69
                """;
        String actualOutput = library.analyzeWeatherData(weeklyMonthTemperatures);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testTally() {
        Library library = new Library();
        List<String> votes = new ArrayList<>();
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Shrub");
        votes.add("Hedge");
        votes.add("Shrub");
        votes.add("Bush");
        votes.add("Hedge");
        votes.add("Bush");

        String winner = library.tally(votes);
        Assertions.assertEquals("Bush", winner);
    }
}


//@Test
//    @DisplayName("Contains Duplicates")
//        public void testDuplicates() {
//        Library sut = new Library();
//        int[] testArr = {1, 2, 3, 4, 5, 1};
//        boolean results = sut.containsDuplicates(testArr);
//        assertTrue(results);
//    @Test
//    public void testRollWithZeroN() {
//        int[] rolls = DiceRoller.roll(0);
//        assertNotNull(rolls);
//        assertEquals(0, rolls.length);
//    }
//
//    @Test
//    public void testRollWithNegativeN() {
//        int[] rolls = DiceRoller.roll(-5);
//        assertNotNull(rolls);
//        assertEquals(0, rolls.length);
//    }
//}
