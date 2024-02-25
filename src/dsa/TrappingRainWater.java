package dsa;

public class TrappingRainWater {
    public int trap(int[] height) {
        int maxLeft = height[0], maxRight = height[height.length - 1], totalWater = 0;
        int[] leftMaxBoundaries = new int[height.length];

        for (int i = 1 ; i < height.length ; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            leftMaxBoundaries[i] = maxLeft;
        }

        for (int i = height.length - 2 ; i > 0 ; i--) {
            maxRight = Math.max(maxRight, height[i]);
            int waterContainedByThisIdx = Math.min(leftMaxBoundaries[i], maxRight) - height[i];
            if (waterContainedByThisIdx > 0) {
                totalWater += waterContainedByThisIdx;
            }
        }

        return totalWater;
    }

    public int trap_WithOneLoop(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                int trappedWater = leftMax - height[left];
                totalWater += Math.max(0, trappedWater);
                System.out.println("Trapped water at idx : " + left + " is : " + trappedWater);
                left++;
            }else {
                int trappedWater = rightMax - height[right];
                totalWater += Math.max(0, trappedWater);
                System.out.println("Trapped water at idx : " + right + " is : " + trappedWater);
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] height = {0,5,0,3,1,0,1,3,8,1,10,1};
        System.out.println(new TrappingRainWater().trap_WithOneLoop(height));

    }
}
