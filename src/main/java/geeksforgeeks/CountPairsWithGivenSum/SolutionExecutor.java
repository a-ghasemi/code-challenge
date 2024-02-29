package geeksforgeeks.CountPairsWithGivenSum;

// https://www.geeksforgeeks.org/count-pairs-with-given-sum

public class SolutionExecutor {
    private final Strategy strategy;

    public SolutionExecutor(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int[] numbers, int k) {
        return this.strategy.run(numbers, k);
    }
}

