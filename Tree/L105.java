import java.util.HashMap;
import java.util.Map;

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

public class L105 {
    
    public TreeNode buildTree(int [] preorder , int preStart , int preEnd , int [] inorder , int inStart , int inEnd , Map<Integer , Integer> mpp){

        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = mpp.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder , preStart + 1 , preStart + numsLeft , inorder , inStart , inRoot - 1 , mpp);

        root.right = buildTree(preorder , preStart + numsLeft + 1 , preEnd , inorder , inRoot + 1 , inEnd , mpp);

        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();

        for(int i=0;i<preorder.length;i++){
            mpp.put(inorder[i] , i);
        }

        TreeNode root = buildTree(preorder , 0 , preorder.length - 1 , inorder , 0 , inorder.length - 1 , mpp);

        return root;

    }

}
