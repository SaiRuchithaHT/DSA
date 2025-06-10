class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> result = new LinkedList<>();
        for(int i=0; i<nums.length; i++){
            if(i>=k){
                if(!deque.isEmpty() && deque.peekFirst()==nums[i-k])
                    deque.pollFirst();
            }

            while(!deque.isEmpty() && deque.peekLast()<nums[i])
                deque.pollLast();
            deque.offerLast(nums[i]);

            if(i < k-1){
                continue;
            }

            result.add(deque.peekFirst());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}