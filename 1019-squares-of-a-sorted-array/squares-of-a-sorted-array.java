class Solution {
    public int findMid(int[] nums){
        for(int i=1; i<=nums.length; i++){
            if(i==nums.length || nums[i-1]<nums[i])
                return i-1;
        }
        return 0;
    }
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            nums[i] = nums[i]*nums[i];
        int mid = findMid(nums);
        for(int i=mid, j=mid+1, k=0; i>=0 || j<nums.length; ){
            System.out.println(i+" "+j);
            if(i==-1){
                res[k++] = nums[j++];
                continue;
            }
            if(j==nums.length){
                res[k++] = nums[i--];
                continue;
            }
            if(nums[i]<nums[j])
                res[k++] = nums[i--];
            else
                res[k++] = nums[j++];
        }
        return res;
    }
}