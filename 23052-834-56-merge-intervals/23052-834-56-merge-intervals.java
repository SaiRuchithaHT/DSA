class Solution {
    public int[][] merge(int[][] intervals) {
        Queue<int[]> queue = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            else
                return a[1]-b[1];
        });
        for(int i=0; i<intervals.length; i++){
            queue.add(new int[]{intervals[i][0],intervals[i][1]});
        }
        List<int[]> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int[] int1 = queue.poll();
            if(queue.size()>0){
                if(int1[1]<queue.peek()[0]){
                    list.add(int1);
                } else if(int1[1]>=queue.peek()[1]){
                    queue.poll();
                    queue.add(int1);
                }
                else{
                    int[] int2 = queue.poll();
                    queue.add(new int[]{int1[0],int2[1]});
                }
            } else{
                list.add(int1);
            }
        }
        return list.toArray(new int[0][]);
    }
}