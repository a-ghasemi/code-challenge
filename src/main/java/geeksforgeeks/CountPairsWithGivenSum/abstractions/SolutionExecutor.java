package geeksforgeeks.CountPairsWithGivenSum.abstractions;

public class SolutionExecutor {
    private final Strategy strategy;

    public SolutionExecutor(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int[] numbers, int k) {
        return this.strategy.run(numbers, k);
    }
}

