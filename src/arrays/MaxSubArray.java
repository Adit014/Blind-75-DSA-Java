//https://leetcode.com/problems/maximum-subarray/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            maxSum = Math.max(maxSum, sum);
            sum = Math.max(sum, 0);
        }
        return maxSum;
    }
}
