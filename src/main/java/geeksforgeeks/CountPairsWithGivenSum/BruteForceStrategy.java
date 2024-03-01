package geeksforgeeks.CountPairsWithGivenSum;

import geeksforgeeks.CountPairsWithGivenSum.abstractions.Strategy;

public class BruteForceStrategy implements Strategy {
    @Override
    public int run(int[] numbers, int k) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == k) count++;
            }
        }
        return count;
    }
}
