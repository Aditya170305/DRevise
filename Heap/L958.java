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

public class L958 {
    
    public boolean find(TreeNode root , int index , int count){

        if(root == null) return true;
        if(index > count) return false;
        
        boolean left = find(root.left , 2 * index , count);
        boolean right = find(root.right , 2 * index + 1 , count);

        return left && right;

    }

    public boolean isCompleteTree(TreeNode root) {
        
        int count = 0;

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.offer(root);

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){

                TreeNode node = q.poll();
                count++;

                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }

            }

        }

        return find(root , 1 , count);

    }

}
