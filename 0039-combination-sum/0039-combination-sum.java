class Solution {
    public static void findSubsets(int ind, int[] nums, int target, List<Integer> ds, List<List<Integer>> ansList) {
        if(target==0){
            ansList.add(new ArrayList<>(ds)); 
            return;
        }
        if(target<0)
            return;
        for(int i = ind;i<nums.length;i++) {
            // if(i>ind && nums[i] == nums[i-1]) continue; 
            ds.add(nums[i]); 
            findSubsets(i, nums, target-nums[i], ds, ansList); 
            ds.remove(ds.size() - 1);
        }
        
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); 
        List<List<Integer>> ansList = new ArrayList<>(); 
        findSubsets(0, candidates, target, new ArrayList<>(), ansList); 
        return ansList; 
    }
}