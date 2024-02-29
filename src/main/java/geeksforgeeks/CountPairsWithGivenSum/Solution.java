package geeksforgeeks.CountPairsWithGivenSum;

// https://www.geeksforgeeks.org/count-pairs-with-given-sum

public class Solution {
    private final Strategy strategy;

    public Solution(Strategy strategy) {
        this.strategy = strategy;
    }

    public int run(int[] numbers, int k) {
        return this.strategy.run(numbers, k);
    }
}

