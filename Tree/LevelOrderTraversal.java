import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int data;
    public Node left;
    public Node right;

    // Constructor
    public Node(int val) {
        data = val;
        left = right = null;
    }

}

public class LevelOrderTraversal {
    
     public ArrayList<Integer> levelOrder(Node root) {
        
        Queue<Node> q = new LinkedList<Node>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        if(root == null) return ans;
        q.offer(root);
        
        while(!q.isEmpty()){
            
            int levelNum = q.size();
            
            for(int i=0;i<levelNum;i++){
                
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                ans.add(q.poll().data);
                
            }
            
        }
        
        return ans;
        
    }
}
