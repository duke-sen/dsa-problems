package dsa;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int low = 0, high = height.length - 1, maxArea = 0;

        while (low < high) {
            int distancebetweenLines = high - low;
            int lengthOfBoundingLine = Math.min(height[low], height[high]);
            int currentWaterHeight = distancebetweenLines * lengthOfBoundingLine;
            maxArea = Math.max(maxArea, currentWaterHeight);

            if (height[low] < height[high])
                low++;
            else high--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,10,6,2,5,4,12,3,7}));
    }
}
