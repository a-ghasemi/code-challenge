package leetcode.ContainerWithMostWater;

public class SolutionExecutor {
    Strategy strategy;

    public SolutionExecutor(Strategy strategy){
        this.strategy = strategy;
    }

    public int execute(int[] height){
        return strategy.run(height);
    }
}
