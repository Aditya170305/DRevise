class Node{
    int data;
    Node left, right;

    Node(int val){
        data = val;
        left = right = null;
    }
    
}

public class MaximumPathSum {
    
    int maxPathDown(Node root , int maxValue [] ){
        
        if(root == null) return 0;
        
        int left = Math.max(0 , maxPathDown(root.left , maxValue));
        int right = Math.max(0 , maxPathDown(root.right , maxValue));
        
        maxValue[0] = Math.max(maxValue[0] , root.data + left + right);
        
        return root.data + Math.max(left , right);
        
    }
    
    int findMaxSum(Node root) {
        
        int maxValue [] = new int [1];
        
        maxValue[0] = Integer.MIN_VALUE;
        
        maxPathDown(root , maxValue);
        
        return maxValue[0];
        
    }
}
