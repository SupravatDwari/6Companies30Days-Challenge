/* Leetcode Link : https://leetcode.com/problems/split-array-into-consecutive-subsequences/ */

public class Solution {
    public boolean isPossible(int[] nums) {
        int[] element = new int[2001];
        for (int num : nums) {
            element[num + 1000] += 1;
        }
        for (int i = 0; i < element.length; i++) {
            while (element[i] > 0) {
                int length = 1;
                while (i + length < element.length
                        && element[i + length] >= element[i + length - 1]) {
                    length += 1;
                }
                if (length < 3) {
                    return false;
                } else {
                    for (int j = i; j < i + length; j++) {
                        element[j] -= 1;
                    }
                }
            }
        }
        return true;
    }
}

/* Submission Link : https://leetcode.com/problems/split-array-into-consecutive-subsequences/submissions/875518957/ */
