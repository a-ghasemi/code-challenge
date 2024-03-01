package leetcode.ContainerWithMostWater;

import leetcode.ContainerWithMostWater.abstractions.Strategy;

// https://leetcode.com/problems/container-with-most-water
public class BruteforceStrategy implements Strategy {
    @Override
    public int run(int[] height){
        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;

        do {
            maxArea = Math.max(maxArea, calculateArea(height, left, right));
            if(height[left] < height[right]){
                left += 1;
            }
            else{
                right -= 1;
            }

        } while(left < right);

        return maxArea;
    }

    private static int calculateArea(int[] height, int i, int j) {
        return Math.min(height[i], height[j]) * (j - i);
    }
}

