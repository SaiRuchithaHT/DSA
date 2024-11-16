class Solution {
    public void permutations(int len, int[] nums, List<Integer> ds, List<List<Integer>> res){
        if(len==1){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=len; i>0; i--){
            permutations(len-1, nums, ds, res);
            int remElem = ds.remove(nums.length-len);
            ds.add(remElem);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        for (int num : nums) {
            ds.add(num);
        }
        permutations(nums.length, nums, ds, res);
        return res;
    }
}