import java.util.ArrayList;
import java.util.PriorityQueue;

class Node {
    
    int data;
    int row;
    int col;
    
    public Node(int data , int row , int col){
        
        this.data = data;
        this.row = row;
        this.col = col;
        
    }
    
}

public class MergeKSortedArrays {
    
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>(( a , b ) -> Integer.compare(a.data , b.data));
        
        for(int i=0;i<n;i++){
            
            Node node = new Node(mat[i][0] , i , 0);
            pq.add(node);
            
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        while(!pq.isEmpty()){
            
            Node node = pq.poll();
            
            int data = node.data;
            int row = node.row;
            int col = node.col;
            
            ans.add(data);
            
            if(col + 1 < m){
                Node next = new Node(mat[row][col + 1] , row , col + 1);
                pq.add(next);
            }
            
        }
        
        return ans;
        
    }

}
