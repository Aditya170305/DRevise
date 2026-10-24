import java.util.PriorityQueue;

public class MinCostToConnectRopes {
    
    public int minCost(int[] arr) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int num : arr){
            pq.add(num);
        }
        
        int totalCost = 0;
        
        while(pq.size() > 1){
            
            int ele1 = pq.poll();
            int ele2 = pq.poll();
            
            int sum = ele1 + ele2;
            totalCost = totalCost + sum;
            
            pq.add(sum);
            
        }
        
        return totalCost;
        
    }

}
