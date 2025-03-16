class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(3);
        for(int i=0; i<nums.length; i++){
            if(!queue.contains(nums[i])){
                queue.add(nums[i]);
                if(queue.size()>3)
                    queue.poll();
            }
        }
        System.out.println(queue);
        if(queue.size()==3)
            return queue.poll();
        else{
            while(queue.size()>1)
                queue.poll();
            return queue.poll();
        }
    }
}