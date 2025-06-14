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
    int small = 0;
    int result;
    public void find(TreeNode root, int k){
        if(root==null)
            return;
        find(root.left, k);
        small++;
        if(small==k){
            result = root.val;
            return;
        }
        find(root.right, k);
        return;
    }
    public int kthSmallest(TreeNode root, int k) {
        find(root, k);
        return result;
    }
}