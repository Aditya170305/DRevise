import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
    
}

public class ClosestInBST {
    
    public int minDiff(Node root, int k) {
        
        // int value = 0;
        
        // while(root != null){
            
        //     if(root.data <= k){
                
        //         value = root.data;
        //         root = root.right;
                
        //     }
            
        //     else{
                
        //         root = root.left;
                
        //     }
            
        // }
        
        // return k - value;
        
        int ans = Integer.MAX_VALUE;
        
        Queue<Node> q = new LinkedList<Node>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0;i<size;i++){
                
                if(q.peek().left != null){
                    
                    q.offer(q.peek().left);
                    
                }
                
                if(q.peek().right != null){
                    
                    q.offer(q.peek().right);
                    
                }
                
                Node node = q.poll();
                
                ans = Math.min(ans , Math.abs(node.data - k));
                
            }
            
        }
        
        return ans;
        
    }

}
