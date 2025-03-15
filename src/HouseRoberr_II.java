//https://leetcode.com/problems/house-robber-ii/description/

public class HouseRoberr_II {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(getMax(nums, 0, nums.length - 2),
                getMax(nums, 1, nums.length - 1));
    }

    private int getMax(int[] nums, int start, int end) {
        int maxRob = 0, prevRob = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(maxRob, prevRob + nums[i]);
            prevRob = maxRob;
            maxRob = temp;
        }

        return maxRob;
    }
}
