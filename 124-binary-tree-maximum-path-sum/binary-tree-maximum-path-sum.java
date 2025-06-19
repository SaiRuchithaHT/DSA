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
    int maxSum = Integer.MIN_VALUE;
    public int max(TreeNode root){
        if(root==null)
            return 0;
        int maxLeft = max(root.left);
        int maxRight = max(root.right);
        int max = Math.max(root.val+maxLeft, root.val+maxRight);
        return Math.max(0, max);
    }
    public void sum(TreeNode root){
        if(root==null)
            return;
        
        maxSum = Math.max(maxSum, root.val + max(root.left) + max(root.right));
        sum(root.left);
        sum(root.right);
    }
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        sum(root);
        return maxSum;
    }
}