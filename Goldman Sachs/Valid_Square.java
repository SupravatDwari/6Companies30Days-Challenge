/* Leetcode Link : https://leetcode.com/problems/valid-square/ */

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] arr = new int[6];
        arr[0] = distanceSquare(p1,p2);
        arr[1] = distanceSquare(p1,p3);
        arr[2] = distanceSquare(p1,p4);
        arr[3] = distanceSquare(p2,p3);
        arr[4] = distanceSquare(p2,p4);
        arr[5] = distanceSquare(p3,p4);
        
        int min =  arr[0];
        for(int i=1;i<6;i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        
        int count1 = 0, count2 = 0;
        for(int i=0;i<6;i++){
            if(arr[i] == min) count1++;
            else if(arr[i] == 2 * min) count2++;
        }
        
        return count1==4 && count2==2;
    }
    private int distanceSquare(int[] a, int[] b){
        // We use the Pythagorean theorem to calculate the distance between the points
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }
}

/* Submission Link : https://leetcode.com/problems/valid-square/submissions/875504771/ */
