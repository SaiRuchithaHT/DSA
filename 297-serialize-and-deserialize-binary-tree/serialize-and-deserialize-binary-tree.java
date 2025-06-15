/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder sb = new StringBuilder();
    int index = 0;
    // Encodes a tree to a single string.
    public void traverse(TreeNode root){
        if(root==null){
            sb.append("?");
            sb.append("!");
            return;
        }
        sb.append(root.val);
        sb.append("!");
        traverse(root.left);
        traverse(root.right);
    }
    public String serialize(TreeNode root) {
        traverse(root);
        System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode construct(String[] ar){
        String str = ar[index++];
        if(index==ar.length || str.equals("?"))
            return null;
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = construct(ar);
        node.right = construct(ar);
        return node;
    }
    public TreeNode deserialize(String data) {
        String[] ar = data.split("!");
        return construct(ar);
        // return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));