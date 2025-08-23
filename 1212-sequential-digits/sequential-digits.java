class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(12);
        queue.add(23);
        queue.add(34);
        queue.add(45);
        queue.add(56);
        queue.add(67);
        queue.add(78);
        queue.add(89);
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int num = queue.poll();
            if(num>=low && num<=high){
                result.add(num);
            } else if(num>high){
                continue;
            }
            if(num%10<9)
                queue.offer(num*10 + (1+num%10));
        }
        return result;
    }
}