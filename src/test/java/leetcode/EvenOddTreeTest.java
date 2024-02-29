package leetcode;

import leetcode.EvenOddTree.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class EvenOddTreeTest {

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
        TreeNode root = fillTreeNode(input, 0, 0);
        Assertions.assertEquals(expectedOutput, solutionExecutor.execute(root));
    }

    static TreeNode fillTreeNode(Integer[] input, int row_index, int level) {
        int val = (int)Math.pow(2,level) + 2 * row_index - 1;
        int left = (int)Math.pow(2,level + 1) + 2 * row_index - 1;
        if(val >= input.length) return null;
        if(left >= input.length) return null;
        if(input[left] == null) return null;
        if(input[left+1] == null){
            return new TreeNode(input[left], fillTreeNode(input, left, level + 1), null);
        }
        return new TreeNode(input[left], fillTreeNode(input, left, level + 1), fillTreeNode(input, left + 1, level + 1));
    }
}