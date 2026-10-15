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

public class PathSumII {

    public void find(TreeNode root , int sum , List<Integer> path , int targetSum , List<List<Integer>> ans){

        if(root == null) return;

        sum = sum + root.val;

        path.add(root.val);

        if(sum == targetSum && root.left == null && root.right == null) ans.add(new ArrayList<>(path));

        find(root.left , sum , path , targetSum , ans);
        find(root.right , sum , path , targetSum , ans);

        path.remove(path.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> ans = new ArrayList<>();
        find(root , 0 , new ArrayList<Integer>() , targetSum , ans);

        return ans;

    }

}
