import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
}

public class L297 {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null) return "";

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        StringBuilder res = new StringBuilder();

        while(!q.isEmpty()){

            TreeNode node = q.poll();

            if(node == null){
                res.append("n ");
                continue;
            }

            res.append(node.val + " ");
            q.offer(node.left);
            q.offer(node.right);

        }

        return res.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data == "") return null;

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        String values [] = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        q.offer(root);

        for(int i=1;i<values.length;i++){

            TreeNode parent = q.poll();

            if(!values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            }

            if(!values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.offer(right);
            }
        }

        return root;

    }

}
