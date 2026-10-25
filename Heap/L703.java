import java.util.PriorityQueue;

public class L703 {
    
    int k;
    PriorityQueue<Integer> pq;

    public L703(int k, int[] nums) {

        this.k = k;
        pq = new PriorityQueue<Integer>();

        for(int num : nums){

            pq.add(num);

            if(pq.size() > k){
                pq.poll();
            }

        }    
        
    }
    
    public int add(int val) {
        
        pq.add(val);

        if(pq.size() > k){
            pq.poll();
        }

        return pq.peek();

    }

}
