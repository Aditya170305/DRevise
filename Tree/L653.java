import java.util.Stack;

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

public class BSTIterator {

    private Stack<TreeNode> st = new Stack<TreeNode>();
    boolean reverse = true;

    public BSTIterator(TreeNode root , boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }

    public boolean hasNext(){

        return !st.isEmpty();

    }

    public int next(){

        TreeNode tmpNode = st.pop();
        if(reverse == false) pushAll(tmpNode.right);
        else pushAll(tmpNode.left);
        return tmpNode.val;

    }

    public void pushAll(TreeNode root){

        while(root != null){

            st.push(root);

            if(reverse == true) root = root.right;
            else root = root.left;

        }

    }

}

public class L653 {
    
    public boolean findTarget(TreeNode root, int k) {
        
        if(root == null) return false;

        BSTIterator l = new BSTIterator(root , false);
        BSTIterator r = new BSTIterator(root , true);

        int i = l.next();
        int j = r.next();

        while(i < j){

            if(i + j == k) return true;
            else if(i + j < k) i = l.next();
            else j = r.next();

        }

        return false;

    }

}
