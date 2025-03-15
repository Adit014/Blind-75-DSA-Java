// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProft = Integer.MIN_VALUE;
        int profit = 0;
        int cost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - cost;
            cost = Math.min(cost, prices[i]);
            maxProft = Math.max(profit, maxProft);
        }
        return Math.max(maxProft, 0);
    }
}
