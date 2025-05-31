class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> (b-a));
        for(int num : stones)
            queue.add(num);
        while(!queue.isEmpty() && queue.size()>1){
            int num1 = queue.poll();
            int num2 = queue.poll();
            if(num1==num2)
                continue;
            queue.add(num1-num2);
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}