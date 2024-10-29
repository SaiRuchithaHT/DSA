/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> iterate(TreeNode root, List<List<Integer>> outerList, int height){
        if(root==null)
            return outerList;

        if(height > outerList.size()){
            List<Integer> innerList = new ArrayList<>();
            outerList.add(innerList);
        }
        outerList.get(height-1).add(root.val);
        outerList = iterate(root.left, outerList, height+1);
        outerList = iterate(root.right, outerList, height+1);
        return outerList;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();

        List<List<Integer>> outerList = new ArrayList<>();
        outerList = iterate(root, outerList, 1);
        return outerList;
    }
}