/* Leetcode Link : https://leetcode.com/problems/count-nice-pairs-in-an-array/description/ */

public class Solution {
    private int rev(int n) {
        int r = 0;
        while (n > 0) {
            r = r * 10 + n % 10;
            n = n / 10;
        }
        return r;
    }

    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> revMap = new HashMap<>();
        int cnt = 0;
        for (int num : nums) {
            int lhs = num - rev(num);
            int prevCnt = revMap.getOrDefault(lhs, 0);
            cnt += prevCnt;
            int mod = 1000000007;
            cnt = cnt % mod;
            revMap.put(lhs, prevCnt + 1);
        }
        return cnt;
    }
}
/* Submission Link : https://leetcode.com/problems/count-nice-pairs-in-an-array/submissions/875863805/ */
