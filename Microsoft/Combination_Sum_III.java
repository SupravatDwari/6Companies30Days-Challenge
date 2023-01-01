/* Leetcode Link:  */

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> sum = new ArrayList<List<Integer>>();
        combo(1,k,n,sum, new ArrayList<>());
        return sum;
    }
    void combo(int ind, int k, int n,List<List<Integer>> sum, List<Integer> ds){
        if(n==0 && ds.size()==k){
            sum.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind; i<=9;i++){
            if(ds.size()==k) break;
            ds.add(i);
            combo(i+1, k,n-i,sum,ds);
            ds.remove(ds.size()-1);
        }
    }
}

/* Submission Link: https://leetcode.com/problems/combination-sum-iii/submissions/869061867/ */
