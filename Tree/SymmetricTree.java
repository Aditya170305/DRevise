public class SymmetricTree {
    
    public boolean isSymmetricHelp(Node r1 , Node r2){
        
        if(r1 == null || r2 == null) return (r1 == r2);
        
        if(r1.data != r2.data) return false;
        
        return isSymmetricHelp(r1.left , r2.right) && isSymmetricHelp(r1.right , r2.left);
        
    }
    
    public boolean isSymmetric(Node root) {
        
        return root == null || isSymmetricHelp(root.left , root.right);
        
    }
    
}
