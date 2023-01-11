/* Leetcode Link : https://leetcode.com/problems/number-of-people-aware-of-a-secret/description/ */

public class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[][] dp = new long[n + forget][3];
        // 0: people who currently know the secret (includes [1] below)
        // 1: people who start sharing the secret on this day
        // 2: people who forget on this day
        long mod = (long) 1e9 + 7;
        dp[0][0] = dp[delay][1] = dp[forget][2] = 1;
        for (int i = 1; i < n; i++) {
            // dp[i][1] was originally just the i - delay newcomers
            dp[i][1] = (dp[i][1] + dp[i - 1][1] - dp[i][2] + mod) % mod;
            // these people forget on i + forget day
            dp[i + forget][2] = dp[i][1];
            // these people start sharing on i + delay day
            dp[i + delay][1] = dp[i][1];
            // today's total people who know the secret
            dp[i][0] = (dp[i - 1][0] + dp[i][1] - dp[i][2] + mod) % mod;
        }
        return (int) dp[n - 1][0];
    }
}

/* Submission Link : https://leetcode.com/problems/number-of-people-aware-of-a-secret/submissions/875862063/ */
