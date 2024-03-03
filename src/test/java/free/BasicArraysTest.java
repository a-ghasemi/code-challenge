package free;

import free.BasicArrays.*;
import free.BasicArrays.abstractions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BasicArraysTest {

    static Strategy strategy = new BruteforceStrategy();

    static Stream<Object[]> dataProvider(){
        return Stream.of(
                new Object[]{
                        new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7},
                        0
                },
                new Object[]{
                        new int[]{1, 1},
                        0
                }
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void TestCase(int[] input, int expectedOutput) {
        SolutionExecutor solutionExecutor = new SolutionExecutor(strategy);
        Assertions.assertEquals(expectedOutput, solutionExecutor.execute(input));
    }
}