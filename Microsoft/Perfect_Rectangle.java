/* Leetcode Link : https://leetcode.com/problems/perfect-rectangle/description/ */

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int X = Integer.MAX_VALUE, Y = Integer.MAX_VALUE;
        int A = Integer.MIN_VALUE, B = Integer.MIN_VALUE;
        HashSet<String> set = new HashSet<>();
        int area_sum = 0;
        for(int[] rectangle : rectangles){
            int x = rectangle[0], y = rectangle[1];
            int a = rectangle[2], b = rectangle[3];
            X = Math.min(X, x);
            Y = Math.min(Y, y);
            A = Math.max(A, a);
            B = Math.max(B, b);
            area_sum += (a - x) * (b - y);
            String[] points = new String[4];
            points[0] = x + " " + b;
            points[1] = a + " " + b;
            points[2] = a + " " + y;
            points[3] = x + " " + y;
            for(String point : points){
                if(set.contains(point)){
                    set.remove(point);
                }else{
                    set.add(point);
                }
            }
        }
        if(area_sum != (A - X) * (B - Y)){
            return false;
        }
        if(set.size() != 4 || !(set.contains(X + " " + B) && set.contains(A + " " + B) && set.contains(A + " " + Y) && set.contains(X + " " + Y))){
            return false;
        }
        return true;
    }
}

/* https://leetcode.com/problems/perfect-rectangle/submissions/869488486/ */
