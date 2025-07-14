class Solution {
    List<Integer> result; 
    public boolean dfs(int course, List<Integer>[] list, int[] state){
        state[course] = 1;
        for(Integer neigh : list[course]){
            if(state[neigh]==1)
                return false;
            if(state[neigh]==0 && !dfs(neigh, list, state))
                return false;
            else{
                if(!result.contains(neigh))
                    result.add(neigh);
                }
        }
        if(!result.contains(course))
            result.add(course);
        state[course] = 2;
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new ArrayList<>();
        int[] state = new int[numCourses];
        List<Integer>[] list = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++)
            list[i] = new ArrayList<>();
        for(int[] req : prerequisites){
            list[req[0]].add(req[1]);
        }
        for(int i=0; i<numCourses; i++){
            if(state[i]==0 && !dfs(i, list, state))
                return new int[0];
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}