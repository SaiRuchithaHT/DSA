class Solution {
    class Pair{
        int x;
        int y;
        int sum;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
            this.sum = x*x+y*y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(k, (a,b) -> (a.sum-b.sum));
        for(int[] point : points)
            queue.add(new Pair(point[0], point[1]));
        int[][] res = new int[k][2];
        for(int i=0; i<k; i++){
            Pair p = queue.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
        }
        return res;
    }
}