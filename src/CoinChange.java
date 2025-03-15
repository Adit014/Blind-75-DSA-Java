import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
    int minNum = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(new CoinChange().coinChange(coins, 11));
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
