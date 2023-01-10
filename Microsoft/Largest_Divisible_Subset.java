/* Leetcode Link : https://leetcode.com/problems/largest-divisible-subset/description/ */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int temp[] = new int[n];
        int prev[] = new int[n];
        for(int i=0;i<n;i++){
            temp[i]=1;
            prev[i]=-1;
        }
        int max_val =Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i=1;i<n;i++){
            max_val =0;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(temp[j]>=max_val){
                        max_val = Math.max(max_val, temp[j]);
                        prev[i]=j;
                    }
                }
            }
            temp[i]=max_val+1;
        }
        int index =-1;
        for(int i=0;i<n;i++){
            if(max_val < temp[i]){
                index = i;
                max_val = temp[i];
            }
        }
        while(index!=-1){
            int num= nums[index];
            list.add(num);
            index = prev[index];
        }
        return list;
    }
}

/* Submission Link : https://leetcode.com/problems/largest-divisible-subset/submissions/869486357/ */
