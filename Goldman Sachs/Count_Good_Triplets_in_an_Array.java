/* Leetcode Link : https://leetcode.com/problems/count-good-triplets-in-an-array/description/ */

class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int s[] = new int[10];
        int g[] = new int[10];
        int bulls = 0, cows = 0;
        for(int i=0; i<n; i++){
            if(guess.charAt(i)==secret.charAt(i))
                bulls++;
            else{
                s[(int)secret.charAt(i)-48]++;
                g[(int)guess.charAt(i)-48]++;   
            }
        }
        for(int i=0; i<10; i++)
            cows += Math.min(s[i],g[i]);
        
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append("A").append(cows).append("B");
        return sb.toString();
    }
}

/* Submission Link : https://leetcode.com/problems/count-good-triplets-in-an-array/submissions/875859774/ */
