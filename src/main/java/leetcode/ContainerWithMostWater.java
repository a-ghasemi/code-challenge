package leetcode;

// https://leetcode.com/problems/container-with-most-water
public class ContainerWithMostWater {
    public int maxArea(int[] height){
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

    // checks every possibility to calculate the expected answer for test cases
    public int bruteforceMaxArea(int[] height){
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

