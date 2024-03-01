package _templatepackage.Template.abstractions;

public class SolutionExecutor {
    private final Strategy strategy;

    public SolutionExecutor(Strategy strategy){
        this.strategy = strategy;
    }

    public int execute(int[] input){
        return strategy.run(input);
    }
}
