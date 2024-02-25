package geeksforgeeks;

import geeksforgeeks.CountPairsWithGivenSum.BruteForceStrategy;
import geeksforgeeks.CountPairsWithGivenSum.Strategy;
import geeksforgeeks.CountPairsWithGivenSum.CountPairsWithGivenSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CountPairsWithGivenSumTest {

    static Strategy strategy;
    static CountPairsWithGivenSum strategyExecute;

    @BeforeAll
    static void getStrategy(){
        strategy = new BruteForceStrategy();
        strategyExecute = new CountPairsWithGivenSum(strategy);
    }

    @Test
    void countPairsWithExactSum1() {
        int[] input = new int[]{1, 5, 7, -1};
        int K = 6;
        int output = 2;

        Assertions.assertEquals(output, strategyExecute.countPairsWithExactSum(input, K));
    }

    @Test
    void countPairsWithExactSum2() {
        int[] input = new int[]{1, 5, 7, -1, 5};
        int K = 6;
        int output = 3;

        Assertions.assertEquals(output, strategyExecute.countPairsWithExactSum(input, K));
    }
}