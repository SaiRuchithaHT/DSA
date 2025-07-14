class Solution {
    public boolean dfs(int course, List<Integer>[] list, int[] state){
        state[course] = 1;
        for(Integer neigh : list[course]){
            if(state[neigh]==1)
                return false;
            if(state[neigh]==0 && !dfs(neigh, list, state))
                return false;
        }
        state[course] = 2;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] state = new int[numCourses];
        List<Integer>[] list = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++)
            list[i] = new ArrayList<>();
        for(int[] req : prerequisites){
            list[req[0]].add(req[1]);
        }
        for(int i=0; i<numCourses; i++){
            if(state[i]==0 && !dfs(i, list, state))
                return false;
        }
        return true;
    }
}