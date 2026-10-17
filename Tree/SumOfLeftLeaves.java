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

public class SumOfLeftLeaves {
    
    public int sumOfLeftLeaves(TreeNode root) {

        if(root == null) return 0;

        if(root.left == null && root.right == null) return 0;
        
        int sum = 0;

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.offer(root);

        while(!q.isEmpty()){

            boolean isLeftLeaf = false;

            int size = q.size();

            for(int i=0;i<size;i++){

                TreeNode node = q.poll();

                if(node.left != null){

                    if(node.left.left == null && node.left.right == null){

                        sum = sum + node.left.val;

                    }

                    else{

                        q.offer(node.left);

                    }

                }

                if(node.right != null){

                    q.offer(node.right);
                    
                }

            }

        }

        return sum;

    }

}
