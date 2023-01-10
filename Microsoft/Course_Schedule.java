/* Leetcode Link : https://leetcode.com/problems/course-schedule/description/ */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //building courses adjancency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++)
            adj.add(new ArrayList<Integer>());
        for(int[] prereq: prerequisites) {
            adj.get(prereq[0]).add(prereq[1]);
        }
        //0 is unvisited, 1 is visiting, 2 is visited
        int[] visited = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            if(cycleExists(i, adj, visited))    return false;
        }
        return true;
    }
    private boolean cycleExists(int course, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        if(visited[course]==1)  return true;
        visited[course] = 1;
        for(int subCourse: adj.get(course)) {
            if(visited[subCourse]!=2) {
                if(cycleExists(subCourse, adj, visited))    return true;
                visited[subCourse] = 2;
            }
        }
        visited[course] = 2;
        return false;
    }
}

/* Submission Link : https://leetcode.com/problems/course-schedule/submissions/869490386/ */
