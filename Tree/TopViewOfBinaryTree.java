import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
    
}

class Pair {
    
    public Node node;
    public int line;
    
    public Pair(Node node , int line){
        
        this.node = node;
        this.line = line;
        
    }
    
}

public class TopViewOfBinaryTree {

    public ArrayList<Integer> topView(Node root) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        
        Map<Integer , Integer> mpp = new TreeMap<Integer , Integer>();
        Queue<Pair> q = new LinkedList<Pair>();
        
        q.offer(new Pair(root , 0));
        
        while(!q.isEmpty()){
            
            Pair it = q.poll();
            Node node = it.node;
            int line = it.line;
            
            if(mpp.get(line) == null) mpp.put(line , node.data);
            
            if(node.left != null){
                q.offer(new Pair(node.left , line - 1));
            }
            
            if(node.right != null){
                q.offer(new Pair(node.right , line + 1));
            }
            
        }
        
        for(Map.Entry<Integer , Integer> entry : mpp.entrySet()){
            
            ans.add(entry.getValue());
            
        }
        
        return ans;
        
    }
    
}
