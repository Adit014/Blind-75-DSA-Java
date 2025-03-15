//https://leetcode.com/problems/house-robber/description/
public class HouseRobber {
    public int rob(int[] nums) {
        int maxRob = 0, prevRob = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max(maxRob, prevRob + nums[i]);
            prevRob = maxRob;
            maxRob = temp;
        }

        return maxRob;
    }
}
