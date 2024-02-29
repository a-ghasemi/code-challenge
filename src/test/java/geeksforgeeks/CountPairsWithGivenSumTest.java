package geeksforgeeks;

import geeksforgeeks.CountPairsWithGivenSum.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {
    static Stream<Object[]> dataProvider() {
        return Stream.of(
                new Object[]{new int[]{1, 5, 7, -1}, 6, 2},
                new Object[]{new int[]{1, 5, 7, -1, 5}, 6, 3}
        );
    }
    static Strategy strategy = new BruteForceStrategy();

    static Solution strategyExecute;

    @BeforeAll
    static void getStrategy(){
        strategyExecute = new Solution(strategy);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void countPairsWithExactSum(int[] input, int K, int expectedOutput) {
        Assertions.assertEquals(expectedOutput, strategyExecute.run(input, K));
    }
}