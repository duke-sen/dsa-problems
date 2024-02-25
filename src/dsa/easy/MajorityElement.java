package dsa.easy;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int currentMajority = nums[0], currentMajorityFrequency = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currentMajority)
                currentMajorityFrequency++;
            else currentMajorityFrequency--;

            if (currentMajorityFrequency == 0) {
                currentMajority = nums[i];
                currentMajorityFrequency = 1;
            }
        }
        return currentMajority;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
