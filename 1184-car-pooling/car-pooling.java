class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] loc = new int[1001];
        for(int[] trip : trips){
            loc[trip[1]] += trip[0];
            loc[trip[2]] -= trip[0];
        }
        int count = 0;
        for(int pas : loc){
            count = count + pas;
            if(count>capacity)
                return false;
        }
        return true;
    }
}