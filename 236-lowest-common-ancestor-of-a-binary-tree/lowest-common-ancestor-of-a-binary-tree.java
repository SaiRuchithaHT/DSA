/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        TreeNode left = findAncestor(root.left, p, q);
        TreeNode right = findAncestor(root.right, p, q);
        if(root.val==p.val || root.val==q.val )
            return root;

        if(left!=null && right!=null)
            return root;
        else if(left!=null)
            return left;
        else if(right!=null)
            return right;
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findAncestor(root, p, q);
    }
}