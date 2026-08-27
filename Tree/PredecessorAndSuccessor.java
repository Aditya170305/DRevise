import java.util.ArrayList;

class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
    
} 

public class PredecessorAndSuccessor {
    
    public ArrayList<Node> findPreSuc(Node root, int key) {
        
        Node predecessor = null;
        
        ArrayList<Node> ans = new ArrayList<Node>();
        
        Node dup_root = root;
        
        while(root != null){
            
            if(key > root.data){
                predecessor = root;
                root = root.right;
            }
            
            else{
                root = root.left;
            }
            
        }
        
        ans.add(predecessor);
        
        Node successor = null;
        
        root = dup_root;
        
        while(root != null){
            
            if(key >= root.data){
                root = root.right;
            }
            
            else{
                successor = root;
                root = root.left;
            }
            
        }
        
        ans.add(successor);
        
        return ans;
        
    }

}
