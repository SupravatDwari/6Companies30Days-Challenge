/* Leetcode Link : https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/ */

class Solution {
    public int numberOfSubstrings(String s) {
    int arr[]=new int[3];
        int i=0;
        int j=0;
        int count=0;
        int n=s.length();
        while(j<n){
         arr[s.charAt(j)-'a']++;
        if(arr[0]>0 &&arr[1]>0 &&arr[2]>0)
            count+=n-j;
        while(arr[0]>0 &&arr[1]>0 &&arr[2]>0){
          arr[s.charAt(i)-'a']--;
            i++;
         if(arr[0]>0 &&arr[1]>0 &&arr[2]>0)
            count+=n-j;
        }            
            j++;
        }
       return count; 
    }
}
/* Submission Link : https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/submissions/874824646/ */
