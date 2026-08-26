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

public class KthSmallestElementInBST {
    
    public int kthSmallest(TreeNode root, int k) {
        
        TreeNode curr = root;

        while(curr != null){

            if(curr.left == null){

                k--;

                if(k == 0) return curr.val;

                curr = curr.right;

            }

            else{

                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){

                    prev = prev.right;
                    
                }

                if(prev.right == null){

                    prev.right = curr;
                    curr = curr.left;

                }

                else{

                    prev.right = null;

                    k--;

                    if(k == 0) return curr.val;

                    curr = curr.right;

                }

            }

        }

        return 0;

    }

}
