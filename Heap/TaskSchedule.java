import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskSchedule {
    
    public int leastInterval(int[] tasks, int k) {
        
        int n = tasks.length;
        
        int maxi = Integer.MIN_VALUE;
        
        for(int task : tasks){
            
            maxi = Math.max(maxi , task);
            
        }
        
        int freq [] = new int [maxi + 1];
        
        for(int task : tasks){
            
            freq[task]++;
            
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i=0;i<maxi+1;i++){
            
            if(freq[i] > 0){
                pq.add(freq[i]);
            }
            
        }
        
        int time = 0;
        
        while(!pq.isEmpty()){
            
            List<Integer> temp = new ArrayList<Integer>();
            
            for(int i=1;i<=k+1;i++){
                
                if(!pq.isEmpty()){
                    int f = pq.poll();
                    f--;
                    temp.add(f);
                }
                
            }
            
            for(Integer f : temp){
                
                if(f > 0){
                    pq.add(f);
                }
                
            }
            
            if(pq.isEmpty()){
                time = time + temp.size();
            }
            
            else{
                time = time + k + 1;
            }
            
        }
        
        return time;
        
    }
    
}
