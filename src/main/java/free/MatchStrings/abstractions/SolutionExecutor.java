package free.MatchStrings.abstractions;

public class SolutionExecutor {
    private final Strategy strategy;

    public SolutionExecutor(Strategy strategy){
        this.strategy = strategy;
    }

    public String execute(int m, int n, String s, String t){
        return strategy.run(m, n, s, t);
    }
}
