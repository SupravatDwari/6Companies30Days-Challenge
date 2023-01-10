/* Leetcode Link : https://leetcode.com/problems/rotate-function/description/ */

class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0, ans=0, n= nums.length;
        for(int i=0; i<n; i++){
        ans+=i*nums[i];
        sum+=nums[i];
       }
        int prev = ans;
        for(int i = 1; i<n; i++){
           int curr = prev+sum-n*(nums[n-i]);
           ans = Math.max(curr, ans);
           prev = curr;
       }
       return ans;
    }
}

/* Submission Link : https://leetcode.com/problems/rotate-function/submissions/869468170/ */
