import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
    
}

public class RightViewOfBinaryTree {
    
    public void rightView(Node root , ArrayList<Integer> ans , int level){
        
        if(root == null) return;
        
        if(level == ans.size()) ans.add(root.data);
        
        rightView(root.right , ans , level + 1);
        rightView(root.left , ans , level + 1);
        
    }
    
    public ArrayList<Integer> rightView(Node root) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        rightView(root , ans , 0);
        return ans;
        
    }
}
