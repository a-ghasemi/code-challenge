package leetcode;

import leetcode.EvenOddTree.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class EvenOddTreeTest {

    static Strategy strategy = new BruteforceStrategy();

    static Stream<Object[]> dataProvider() {
        return Stream.of(
                new Object[]{
                        new Integer[]{1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2},
                        true
                },
                new Object[]{
                        new Integer[]{5, 4, 2, 3, 3, 7},
                        false
                }
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void TestCase(Integer[] input, boolean expectedOutput) {
        SolutionExecutor solutionExecutor = new SolutionExecutor(strategy);
        Assertions.assertEquals(expectedOutput, solutionExecutor.execute(input));
    }
}