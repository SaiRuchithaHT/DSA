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
    public TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q){
        if((p.val<root.val && root.val<q.val ) || (p.val==root.val) || (q.val==root.val))
            return root;
        else if(q.val<root.val)
            return findAncestor(root.left, p, q);
        return findAncestor(root.right, p, q);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<q.val)
            return findAncestor(root, p, q);
        return findAncestor(root, q, p);
    }
}