/* Leetcode Link : https://leetcode.com/problems/longest-happy-prefix/description/ */

class Solution {
    public String longestPrefix(String s) {
        if(s.length()<=1) return "";
        int[] lps = new int[s.length()];
        lps[0]=0;
        int x =0;
        for(int i=1;i<s.length();i++){
            x = lps[i-1];
            while(s.charAt(i)!=s.charAt(x)){
                if(x==0){
                    x=-1;
                    break;
                }
                x=lps[x-1];
            }
            lps[i]=x+1;
        }
        return s.substring(0,x+1);
        
    }
}

/* Submission Link : https://leetcode.com/problems/longest-happy-prefix/submissions/874816587/ */
