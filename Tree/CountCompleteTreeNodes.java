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

public class CountCompleteTreeNodes {
    
    public int findLeftHeight(TreeNode root){

        int count = 0;

        while(root != null){

            count++;
            root = root.left;

        }

        return count;

    }

    public int findRightHeight(TreeNode root){

        int count = 0;

        while(root != null){

            count++;
            root = root.right;

        }

        return count;
        
    }

    public int countNodes(TreeNode root) {

        if(root == null) return 0;

        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);

        if(lh == rh) return ((1 << lh) - 1);

        return 1 + countNodes(root.left) + countNodes(root.right);

    }

}
