package free;

import free.MatchStrings.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MatchStringsTest {

    static Strategy strategy = new BruteforceStrategy();

    static Stream<Object[]> dataProvider(){
        return Stream.of(
                new Object[]{
                        8,
                        7,
                        "code*cup",
                        "codecup",
                        "YES"
                },
                new Object[]{
                        7,
                        5,
                        "aba*aba",
                        "ababa",
                        "NO"
                },
                new Object[]{
                        7,
                        11,
                        "vik*nes",
                        "vikinglines",
                        "YES"
                }

        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void TestCase(int m, int n, String s, String t, String expectedOutput) {
        SolutionExecutor solutionExecutor = new SolutionExecutor(strategy);
        Assertions.assertEquals(expectedOutput, solutionExecutor.execute(m, n, s, t));
    }
}