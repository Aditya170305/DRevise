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

public class PathSum {
    
    public boolean find(TreeNode root , int sum , int targetSum){

        if(root == null) return false;

        sum = sum + root.val;

        if(sum == targetSum && root.left == null && root.right == null) return true;

        if(find(root.left , sum , targetSum)) return true;
        if(find(root.right , sum , targetSum)) return true;

        return false;
    
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return find(root , 0 , targetSum);

    }

}
