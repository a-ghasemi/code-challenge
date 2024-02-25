package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @Test
    void maxArea() {
        int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        int expectedOutput = 49;

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        Assertions.assertEquals(expectedOutput, containerWithMostWater.maxArea(input));
    }
}