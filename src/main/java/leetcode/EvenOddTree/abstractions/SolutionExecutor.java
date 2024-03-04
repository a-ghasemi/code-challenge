package leetcode.EvenOddTree.abstractions;

public class SolutionExecutor {
    private final Strategy strategy;

    public SolutionExecutor(Strategy strategy){
        this.strategy = strategy;
    }

    public boolean execute(TreeNode root){
        return strategy.run(root);
    }
}
