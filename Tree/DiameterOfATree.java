class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
    
}

public class DiameterOfATree {
    
    public int height(Node root , int [] diameter){
        
        if(root == null) return 0;
        
        int lh = height(root.left , diameter);
        int rh = height(root.right , diameter);
        
        diameter[0] = Math.max(diameter[0] , lh + rh);
        
        return 1 + Math.max(lh , rh);
        
    }
    
    public int diameter(Node root) {
        
        int [] diameter = new int [1];
        
        height(root , diameter);
        
        return diameter[0];
        
    }
}
