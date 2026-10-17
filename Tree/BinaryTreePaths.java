import java.util.ArrayList;
import java.util.List;

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

public class BinaryTreePaths {
    
    public void find(TreeNode root , StringBuilder str , List<String> ans){

        if(root == null) return;

        int len = str.length();

        if(root.left == null && root.right == null){
            str.append(root.val);
            ans.add(str.toString());
        }

        else{
            str.append(root.val + "->");
        }

        find(root.left , str , ans);
        find(root.right , str , ans);

        str.setLength(len);

    }

    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> ans = new ArrayList<String>();

        find(root , new StringBuilder() , ans);

        return ans;

    }
    
}
