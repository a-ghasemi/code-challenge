package leetcode;

import leetcode.ContainerWithMostWater.ContainerWithMostWater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainerWithMostWaterTest {

    @Test
    void maxArea1() {
        int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        int expectedOutput = 49;

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        Assertions.assertEquals(expectedOutput, containerWithMostWater.maxArea(input));
    }

    @Test
    void maxArea2() {
        int[] input = new int[]{1,1};
        int expectedOutput = 1;

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        Assertions.assertEquals(expectedOutput, containerWithMostWater.maxArea(input));
    }
}