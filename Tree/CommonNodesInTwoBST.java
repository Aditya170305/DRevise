import java.util.ArrayList;

class Node {
  public int data;
  public Node left;
  public Node right;

  public Node(int val) {
      data = val;
      left = right = null;
  }
  
}

public class CommonNodesInTwoBST {
    
    public void find(Node r1 , Node r2 , ArrayList<Integer> ans){
        
        if(r1 == null) return;
        
        int target = r1.data;
        
        while(r2 != null){
            
            if(r2.data == target){
                
                ans.add(r2.data);
                break;
                
            }
            
            else if(r2.data < target){
                
                r2 = r2.right;
                
            }
            
            else{
                
                r2 = r2.left;
                
            }
            
        }
        
    }
    
    public void inorder(Node r1 , Node r2 , ArrayList<Integer> ans){
        
        if(r1 == null) return;
        
        inorder(r1.left , r2 , ans);
        find(r1 , r2 , ans);
        inorder(r1.right , r2 , ans);
        
    }
    
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        inorder(r1 , r2 , ans);
        
        return ans;
        
        
    }

}
