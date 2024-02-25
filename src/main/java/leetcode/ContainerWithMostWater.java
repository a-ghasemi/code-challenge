package leetcode;

// https://leetcode.com/problems/container-with-most-water
public class ContainerWithMostWater {
    public int maxArea(int[] height){
        int maxArea = 0;

        for(int i=0; i < height.length - 1; i++){
            for(int j=i+1; j < height.length; j++){
                int h = Math.min(height[i],height[j]);
                int a = h * (j - i);
                maxArea = Math.max(maxArea, a);
            }
        }

        return maxArea;
    }

}

