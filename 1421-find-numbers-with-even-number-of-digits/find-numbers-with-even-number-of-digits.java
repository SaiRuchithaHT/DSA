class Solution {
    public int findNumbers(int[] nums) {
        // 10-99, 1000-9999, 100000
        int evenCount = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>=10 && nums[i]<=99)
                evenCount++;
            else if(nums[i]>=1000 && nums[i]<=9999)
                evenCount++;
            else if(nums[i]==100000)
                evenCount++;
        }
        return evenCount;
    }
}