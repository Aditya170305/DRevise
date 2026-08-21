import java.util.ArrayList;
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
    
}

public class BoundaryTraversal {
    
    public void addLeftBoundary(Node root , ArrayList<Integer> ans){
        
        Node curr = root.left;
        while(curr != null){
            
            if(!isLeaf(curr)) ans.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
            
        }
        
    }
    
    public void addRightBoundary(Node root , ArrayList<Integer> ans){
        
        Node curr = root.right;
        Stack<Integer> st = new Stack<Integer>();
        while(curr != null){
            
            if(!isLeaf(curr)) st.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
            
        }
        
        while(!st.isEmpty()){
            
            ans.add(st.pop());
            
        }
        
    }
    
    public void addLeaves(Node root , ArrayList<Integer> ans){
        
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        
        if(root.left != null) addLeaves(root.left , ans);
        if(root.right != null) addLeaves(root.right , ans);
        
    }
    
    public boolean isLeaf(Node root){
        
        if(root.left == null && root.right == null) return true;
        return false;
        
    }
    
    public ArrayList<Integer> boundaryTraversal(Node root) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(!isLeaf(root)) ans.add(root.data);
        addLeftBoundary(root , ans);
        addLeaves(root , ans);
        addRightBoundary(root , ans);
        
        return ans;
        
    }
}
