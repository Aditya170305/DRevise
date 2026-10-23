import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestsElement {
    
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int num : arr){
            
            pq.add(num);
            
            if(pq.size() > k) pq.poll();
            
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        while(k != 0){
            
            ans.add(0 , pq.poll());
            k--;
            
        }
        
        return ans;

    }
    
}
