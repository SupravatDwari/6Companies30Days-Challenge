/* Leetcode Link : https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/description/ */

class Solution 
{
    public int minOperations(int[] nums, int[] numsDivide) 
    {
        Arrays.sort(nums);
        int ans=0;
        int i=0;
        while(i<nums.length)
        {
            int f=0;
            for(int j=0;j<numsDivide.length;j++)
            {
                if(numsDivide[j]%nums[i]!=0)
                {
                    f++;
                    break;
                }
            }
            
            if(f==0)
            return ans;
            
            int prev=nums[i];
            while(i<nums.length && nums[i]==prev)
            {
                i++;
                ans++;
            }
        }
        
        return -1;
    }
}

/* Submission Link : https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/submissions/874821027/ */
