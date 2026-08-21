class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class MaximumDepth {
    
    public static int maxDepth(Node root) {
        
        if(root == null) return 0;
        
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        
        return 1 + Math.max(lh , rh);
        
    }
}
