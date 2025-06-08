class KthLargest {

    PriorityQueue<Integer> queue;
    int max;

    public KthLargest(int k, int[] nums) {
        max = k;
        queue = new PriorityQueue<>(k);
        for(int num : nums){
            if(queue.size()==k){
                if(num>queue.peek())
                    queue.poll();
                else
                    continue;
            }
            queue.add(num);
        }
    }
    
    public int add(int val) {
        if(queue.size()==max){
            if(val>queue.peek())
                queue.poll();
            else
                return queue.peek();
        }
        queue.add(val);
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */