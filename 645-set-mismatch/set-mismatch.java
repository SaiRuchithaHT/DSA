class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] itr = new int[nums.length];
        int[] res = new int[2];
        int sum = nums.length*(nums.length+1)/2;
        int arSum = 0;
        for(int num : nums){
            if(itr[num-1]==1){
                res[0] = num;
                continue;
            }
            itr[num-1] = 1;
            arSum += num;
        }
        res[1] = sum-arSum;
        return res;
    }
}