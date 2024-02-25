package geeksforgeeks.CountPairsWithGivenSum;

// https://www.geeksforgeeks.org/count-pairs-with-given-sum

public class CountPairsWithGivenSum {
    private final Strategy strategy;

    public CountPairsWithGivenSum(Strategy strategy) {
        this.strategy = strategy;
    }

    public int run(int[] numbers, int k) {
        return this.strategy.countPairsWithExactSum(numbers, k);
    }
}

