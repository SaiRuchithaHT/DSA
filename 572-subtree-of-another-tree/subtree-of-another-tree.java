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
    public boolean isThisTheTree(TreeNode root, TreeNode subRoot){
        if((root==null && subRoot!=null) || (root!=null && subRoot==null))
            return false;
        if(root==null && subRoot==null)
            return true;
        // System.out.println(root.val+" "+subRoot.val);
        if(root.val==subRoot.val)
            return isThisTheTree(root.left, subRoot.left) && isThisTheTree(root.right, subRoot.right);
        return false;
    }
    public boolean findRoot(TreeNode root, TreeNode subroot){
        if(root==null)
            return false;
        if(root.val==subroot.val){
            if(isThisTheTree(root, subroot)){
                // System.out.println(isThisTheTree(root, subroot));
                return true;
            }
        }
        return findRoot(root.left, subroot) || findRoot(root.right, subroot);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return findRoot(root, subRoot);
    }
}