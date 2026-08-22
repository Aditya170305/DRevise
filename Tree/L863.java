import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
    
};

public class L863 {
    
    public Node _target;
    
    public L863(){
        this._target = null;
    }
    
    public void markParent(Node root , Map<Node , Node> parent){
        
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        
        while(!q.isEmpty()){
            
            Node current = q.poll();
            
            if(current.left != null){
                parent.put(current.left , current);
                q.offer(current.left);
            }
            
            if(current.right != null){
                parent.put(current.right , current);
                q.offer(current.right);
            }
            
        }
        
    }
    
    public Node find(Node root , int target){
        
       if(root == null){
           return null;
       }
       
       if(root.data == target){
           return root;
       }
       
       Node left = find(root.left , target);
       
       if(left != null){
           return left;
       }
       
       return find(root.right , target);
       
    }
    
    public ArrayList<Integer> kDistanceNodes(Node root, int target, int k) {
        
        Map<Node , Node> parent = new HashMap<Node , Node>();
        _target = find(root , target);
        markParent(root , parent);
        
        Map<Node , Boolean> vis = new HashMap<Node , Boolean>();
        Queue<Node> q = new LinkedList<Node>();
        
        q.offer(_target);
        
        vis.put(_target , true);
        
        int curr_level = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            if(curr_level == k) break;
            curr_level++;
            
            for(int i=0;i<size;i++){
                
                Node node = q.poll();
                
                if(node.left != null && vis.get(node.left) == null){
                    q.offer(node.left);
                    vis.put(node.left , true);
                }
                
                if(node.right != null && vis.get(node.right) == null){
                    q.offer(node.right);
                    vis.put(node.right , true);
                }
                
                if(parent.get(node) != null && vis.get(parent.get(node)) == null){
                    q.offer(parent.get(node));
                    vis.put(parent.get(node) , true);
                }
                
            }
            
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        while(!q.isEmpty()){
            
            ans.add(q.poll().data);
            
        }
        
        Collections.sort(ans);
        
        return ans;
        
    }
}
