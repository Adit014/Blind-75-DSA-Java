//https://leetcode.com/problems/jump-game-ii/description/

public class JumpGame_II {
    public int jump(int[] nums) {
        int jumps = 0;
        int coverage = 0, lastJumpIndex = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            coverage = Math.max(coverage, i + nums[i]);

            if (i == lastJumpIndex) {
                lastJumpIndex = coverage;
                jumps++;
            }
        }
        return jumps;
    }
}
