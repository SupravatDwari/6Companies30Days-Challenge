/* Leetcode Link : https://leetcode.com/problems/ipo/description/ */

public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCapital =
                new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[1]));
        PriorityQueue<int[]> maxProfit = new PriorityQueue<>((int[] a, int[] b) -> b[0] - a[0]);
        for (int i = 0; i < profits.length; i++) {
            if (w >= capital[i]) {
                maxProfit.offer(new int[] {profits[i], capital[i]});
            } else {
                minCapital.offer(new int[] {profits[i], capital[i]});
            }
        }
        int count = 0;
        while (count < k && !maxProfit.isEmpty()) {
            int[] temp = maxProfit.poll();
            w += temp[0];
            count += 1;
            while (!minCapital.isEmpty() && minCapital.peek()[1] <= w) {
                maxProfit.offer(minCapital.poll());
            }
        }
        return w;
    }
}

/* Submission Link : https://leetcode.com/problems/ipo/submissions/875861137/ */
