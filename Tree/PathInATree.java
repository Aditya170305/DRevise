import java.util.ArrayList;

class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
        
    }

public class PathInATree {
    
    public static boolean getPath(TreeNode root , int x , ArrayList<Integer> ans){

        if(root == null) return false;
        ans.add(root.data);
        if(root.data == x) return true;
        if(getPath(root.left , x , ans) || getPath(root.right , x , ans)) return true;
        ans.remove(ans.size() - 1);
        return false;

    }
    
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        getPath(root , x , ans);
        return ans;

    }

}
