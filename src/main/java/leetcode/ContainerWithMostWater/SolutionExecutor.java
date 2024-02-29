package leetcode.ContainerWithMostWater;

// https://leetcode.com/problems/container-with-most-water

public class SolutionExecutor {
    private final Strategy strategy;

    public SolutionExecutor(Strategy strategy){
        this.strategy = strategy;
    }

    public int execute(int[] height){
        return strategy.run(height);
    }
}
