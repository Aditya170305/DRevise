import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

public class ZigZagTraversal {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        q.offer(root);

        boolean lTR = true;

        while(!q.isEmpty()){

            int level = q.size();
            List<Integer> subList = new ArrayList<Integer>();

            for(int i=0;i<level;i++){

                TreeNode node = q.poll();

                int index = lTR ? i : 0;

                subList.add(index , node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

            }

            lTR = !lTR;
            ans.add(subList);

        }

        return ans;

    }
}
