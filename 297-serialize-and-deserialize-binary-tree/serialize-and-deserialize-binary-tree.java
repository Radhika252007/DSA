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
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
    public void preorder(TreeNode root, StringBuilder res){
        if(root==null) {
            res.append("null,");
            return;
        }
        res.append(root.val);
        res.append(",");
        preorder(root.left,res);
        preorder(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ser = data.split(",");
        TreeNode root = helper(ser);
        return root;
    }
    TreeNode helper(String[] ser){
        String val = ser[index++];
        if(val.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper(ser);
        node.right = helper(ser);
        return node;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));