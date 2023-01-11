/* Leetcode Link : https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/ */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumCardPickup(int[] cards) {
        int mindiff = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int n = cards.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(cards[i])) {
                int j = map.get(cards[i]);
                mindiff = Math.min(mindiff, i - j + 1);
            }
            map.put(cards[i], i);
        }
        if (mindiff == Integer.MAX_VALUE) {
            return -1;
        }
        return mindiff;
    }
}

/* Submission Link : https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/submissions/875525095/ */
