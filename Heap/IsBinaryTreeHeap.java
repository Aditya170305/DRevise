class Node {
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
    
}

public class IsBinaryTreeHeap {
    
    public boolean isCBT(Node root , int index , int count []){
        
        if(root == null) return true;
        if(index > count[0]) return false;
        
        boolean left = isCBT(root.left , 2 * index , count);
        boolean right = isCBT(root.right , 2 * index + 1 , count);
        
        return (left && right);
    }
    
    public boolean isMaxOrder(Node root){
        
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.right == null) return (root.data > root.left.data);
        
        boolean left = isMaxOrder(root.left);
        boolean right = isMaxOrder(root.right);
        
        return ((root.data > root.left.data) && (root.data > root.right.data) && left && right);
    }
    
    public void countNodes(Node root , int count []){
        
        if(root == null) return;
        
        count[0]++;
        countNodes(root.left , count);
        countNodes(root.right , count);
        
    }
    
    public boolean isHeap(Node root) {
        
        int count [] = new int [1];
        countNodes(root , count);
        
        return (isCBT(root , 1 , count) && isMaxOrder(root));
        
    }

}
