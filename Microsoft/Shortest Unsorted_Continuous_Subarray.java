/* Leetcode Link : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/ */

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = new int[nums.length];
        for(int i=0 ;i <nums.length;i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int count = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != temp[i]){
                count = i;
                break;
            }
        }
        for(int i = count; i < nums.length;i++){
            if(nums[i] != temp[i]){
                count2 = i;
            }
        }
        int res = 0;
        if(count == 0 && count2 == 0){
            res=0;
        }
        else{
            for(int i = count; i <= count2; i++ ){
            res++;
            }
        }
        return res;
    }
}

/* Submission Link : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/submissions/874812654/ */
