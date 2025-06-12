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
    public void traverse(TreeNode root, TreeNode newNode){
        newNode.val = root.val;
        if(root.left!=null){
            TreeNode rightNode = new TreeNode();
            newNode.right = rightNode;
            traverse(root.left, rightNode);
        }
        if(root.right!=null){
            TreeNode leftNode = new TreeNode();
            newNode.left = leftNode;
            traverse(root.right, leftNode);
        }
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        TreeNode newNode = new TreeNode();
        traverse(root, newNode);
        return newNode;
    }
}