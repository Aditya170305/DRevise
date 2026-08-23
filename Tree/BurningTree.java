import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
    
}

public class BurningTree {
    
    public Node _target;
    
    public BurningTree(){
        this._target = null;
    }
    
    public void markParent(Node root , Map<Node , Node> parent){
        
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        
        while(!q.isEmpty()){
            
            Node node = q.poll();
            
            if(node.left != null){
                parent.put(node.left , node);
                q.offer(node.left);
            }
            
            if(node.right != null){
                parent.put(node.right , node);
                q.offer(node.right);
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
    
    public int minTime(Node root, int target) {
        
        Map<Node , Node> parent = new HashMap<Node , Node>();
        
        _target = find(root , target);
        
        markParent(root , parent);
        
        Queue<Node> q = new LinkedList<Node>();
        
        Map<Node , Integer> vis = new HashMap<Node , Integer>();
        
        int maxi = 0;
        
        q.offer(_target);
        
        vis.put(_target , 1);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            int fl = 0;
            
            for(int i=0;i<size;i++){
                
                Node node = q.poll();
                
                if(node.left != null && vis.get(node.left) == null){
                    fl = 1;
                    vis.put(node.left , 1);
                    q.offer(node.left);
                }
                
                if(node.right != null && vis.get(node.right) == null){
                    fl = 1;
                    vis.put(node.right , 1);
                    q.offer(node.right);
                }
                
                if(parent.get(node) != null && vis.get(parent.get(node)) == null){
                    fl = 1;
                    vis.put(parent.get(node) , 1);
                    q.offer(parent.get(node));
                }
                
            }
            
            if(fl == 1) maxi++;
            
        }
        
        return maxi;
        
    }
}
