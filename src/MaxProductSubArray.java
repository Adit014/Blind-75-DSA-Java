//https://leetcode.com/problems/maximum-product-subarray/description/

public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MAX_VALUE;

        int prefix =  1;
        int suffix = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix = prefix == 0 ? 1 :prefix;
            suffix = suffix == 0 ? 1 : suffix;

            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }
}
