class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });
        int count = 0;
        int prevEnd = Integer.MIN_VALUE;
        for(int[] interval :  intervals){
            int start = interval[0];
            int end = interval[1];
            if(prevEnd <= start){
                prevEnd = end;
                continue;
            } 
            count++;
        }
        return count;
    }
}