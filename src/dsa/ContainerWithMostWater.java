package dsa;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int low = 0, high = height.length - 1, water = 0;

        while (low < high) {
            int distanceBetweenLines = high - low;
            int lengthOfBoundingLine = Math.min(height[low], height[high]);
            water = Math.max(water, distanceBetweenLines * lengthOfBoundingLine);
            if (height[low] < height[high])
                low++;
            else high--;
        }
        return water;
    }
}
