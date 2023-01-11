/* Leetcode Link : https://leetcode.com/problems/maximum-points-in-an-archery-competition/description/ */

public class Solution {
    private final int[] ans = new int[12];
    private final int[] ans1 = new int[12];
    private int max = 0;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        solve(numArrows, aliceArrows, 11, 0);
        return ans1;
    }

    private void solve(int numArrows, int[] aliceArrows, int index, int sum) {
        if (numArrows <= 0 || index < 0) {
            if (max < sum) {
                max = sum;
                ans1[0] = Math.max(ans[0], ans[0] + numArrows);
                System.arraycopy(ans, 1, ans1, 1, 11);
            }
            return;
        }
        if (aliceArrows[index] + 1 <= numArrows) {
            ans[index] = aliceArrows[index] + 1;
            solve(numArrows - (aliceArrows[index] + 1), aliceArrows, index - 1, sum + index);
            ans[index] = 0;
        }
        solve(numArrows, aliceArrows, index - 1, sum);
    }
}

/* Submission Link : https://leetcode.com/problems/maximum-points-in-an-archery-competition/submissions/875860738/ */
