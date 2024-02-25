package geeksforgeeks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountPairsWithGivenSumTest {

    @Test
    void countPairsWithExactSum1() {
        int[] input = new int[]{1, 5, 7, -1};
        int K = 6;
        int output = 2;

        CountPairsWithGivenSum countPairsWithGivenSum = new CountPairsWithGivenSum();
        Assertions.assertEquals(output, countPairsWithGivenSum.countPairsWithExactSum(input, K));
    }

    @Test
    void countPairsWithExactSum2() {
        int[] input = new int[]{1, 5, 7, -1, 5};
        int K = 6;
        int output = 3;

        CountPairsWithGivenSum countPairsWithGivenSum = new CountPairsWithGivenSum();
        Assertions.assertEquals(output, countPairsWithGivenSum.countPairsWithExactSum(input, K));
    }
}