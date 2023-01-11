/* Leetcode Link : https://leetcode.com/problems/max-points-on-a-line/ */

class Solution {
    public int maxPoints(int[][] points) {
        int maximum = 1;
        for(int i = 0; i < points.length ; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i+1 ; j < points.length ; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                maximum = Math.max(maximum, solve(points,x1,y1,x2,y2));
            }
        }
        return maximum;
    }

    public int solve(int [][] points, int x1, int y1, int x2, int y2){
        int num = 0;
        for(int i = 0 ; i < points.length ; i++){
            int x = points[i][0];
            int y = points[i][1];
            if((x2 - x1)*(y-y1) == (y2-y1)*(x-x1)){
                num++;
            }
        }
        return num;
    }
}

/* Submission Link : https://leetcode.com/problems/max-points-on-a-line/submissions/875499891/ */
