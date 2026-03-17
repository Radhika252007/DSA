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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        preorder(root,res);
        return res.toString();
    }
    public void preorder(TreeNode root, StringBuilder res){
        if(root == null){
            return;
        }
        res.append(String.valueOf(root.val));
        res.append(',');
        preorder(root.left,res);
        preorder(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        TreeNode root = null;
        for(int i = 0;i < dataArray.length; i++){
            if(data.isEmpty()) continue;
            root = buildTree(root,Integer.parseInt(dataArray[i]));
        }
        return root;
    }
    public TreeNode buildTree(TreeNode root, int val){
        if(root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        if(val < root.val){
            root.left = buildTree(root.left,val);
        }
        if(val > root.val){
            root.right = buildTree(root.right,val);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;