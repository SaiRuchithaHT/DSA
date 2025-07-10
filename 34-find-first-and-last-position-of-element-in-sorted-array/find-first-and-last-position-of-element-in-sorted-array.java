class Solution {
    int[] res = {-1, -1};
    public void search_left(int[] nums, int target, int left, int right){
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                res[0] = mid;
                search_left(nums, target, left, mid-1);
                return;
            } else{
                left = mid + 1;
            }
        }
    }
    public void search_right(int[] nums, int target, int left, int right){
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                res[1] = mid;
                search_right(nums, target, mid+1, right);
                return;
            } else{
                right = mid - 1;
            }
        }
    }
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                res[0] = mid;
                res[1] = mid;
                search_left(nums, target, left, mid-1);
                search_right(nums, target, mid+1, right);
                return res;
            } else if(nums[mid]<target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}