class Solution {
    public boolean dfs(int[] state, int course, List<Integer>[] adj){
        state[course] = 1;
        for(int neighbour : adj[course]){
            if(state[neighbour]==1)
                return false;
            else if(state[neighbour]==0){
                if(!dfs(state, neighbour, adj))
                    return false;
            }
        }
        state[course] = 2;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] state = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] i : prerequisites){
            adj[i[0]].add(i[1]);
        }
        for(int i=0; i<numCourses; i++){
            if(state[i]==0 && !dfs(state, i, adj))
                return false;
        }
        return true;
    }
}