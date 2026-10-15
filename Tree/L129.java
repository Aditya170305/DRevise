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

public class L129 {
    
    public void find(TreeNode root , int sum , int [] ans){

        if(root == null) return;

        sum = (sum*10) + root.val;

        if(root.left == null && root.right == null) ans[0] = ans[0] + sum;

        find(root.left , sum , ans);
        find(root.right , sum , ans);

    }

    public int sumNumbers(TreeNode root) {
        
        int ans [] = new int [1];
        find(root , 0 , ans);

        return ans[0];

    }
    
}
