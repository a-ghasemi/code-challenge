package leetcode.EvenOddTree;

public class SolutionExecutor {
    private final Strategy strategy;

    public SolutionExecutor(Strategy strategy){
        this.strategy = strategy;
    }

    public boolean execute(Integer[] input){
        return strategy.run(input);
    }
}
