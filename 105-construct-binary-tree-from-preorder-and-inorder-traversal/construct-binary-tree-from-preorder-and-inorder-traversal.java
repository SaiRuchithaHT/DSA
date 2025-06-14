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
    Map<Integer, Integer> map;
    int index = 0;
    public TreeNode dfs(int[] preorder, int l, int r){
        if(l>r)
            return null;
        TreeNode node = new TreeNode(preorder[index++]);
        int nodeInd = map.get(node.val);
        node.left = dfs(preorder, l, nodeInd-1);
        node.right = dfs(preorder, nodeInd+1, r);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);
        return dfs(preorder, 0, inorder.length-1);
    }
}