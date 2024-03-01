package geeksforgeeks;

import geeksforgeeks.CountPairsWithGivenSum.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CountPairsWithGivenSumTest {

    static Strategy strategy = new BruteForceStrategy();

    static Stream<Object[]> dataProvider() {
        return Stream.of(
                new Object[]{
                        new int[]{1, 5, 7, -1},
                        6,
                        2
                },
                new Object[]{
                        new int[]{1, 5, 7, -1, 5},
                        6,
                        3
                }
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void TestCase(int[] input, int K, int expectedOutput) {
        SolutionExecutor solutionExecutor = new SolutionExecutor(strategy);
        Assertions.assertEquals(expectedOutput, solutionExecutor.execute(input, K));
    }
}