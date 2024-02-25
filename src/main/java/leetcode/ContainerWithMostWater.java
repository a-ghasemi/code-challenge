package leetcode;

// https://leetcode.com/problems/container-with-most-water
public class ContainerWithMostWater {
    public int maxArea(int[] height){
        int maxArea = 0;

        for(int i=0; i < height.length - 1; i++){
            for(int j=i+1; j < height.length; j++){
                maxArea = Math.max(maxArea, calculateArea(height, i, j));
            }
        }

        return maxArea;
    }

    private static int calculateArea(int[] height, int i, int j) {
        return Math.min(height[i], height[j]) * (j - i);
    }

}

