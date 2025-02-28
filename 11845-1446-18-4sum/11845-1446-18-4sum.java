class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int num1=0; num1<nums.length-3; num1++){
            if(num1!=0 && nums[num1]==nums[num1-1]){

            } else {
                for(int num2=num1+1; num2<nums.length-2; num2++){
                    if(num2!=(num1+1) && nums[num2]==nums[num2-1]){

                    } else {
                        int num3 = num2+1;
                        int num4 = nums.length-1;
                        while(num3<num4){
                            long sum = (long)nums[num1] + nums[num2] + nums[num3] + nums[num4];
                            if(sum == target){
                                List<Integer> innerRes = new ArrayList<>();
                                innerRes.add(nums[num1]);
                                innerRes.add(nums[num2]);
                                innerRes.add(nums[num3]);
                                innerRes.add(nums[num4]);
                                result.add(innerRes);
                                num3++;
                                num4--;
                                while(num3<num4 && nums[num3]==nums[num3-1]){
                                    num3++;
                                }
                                while(num3<num4 && nums[num4]==nums[num4+1]){
                                    num4--;
                                }
                            } else if (nums[num1] + nums[num2] + nums[num3] + nums[num4] < target){
                                num3++;
                            } else {
                                num4--;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}