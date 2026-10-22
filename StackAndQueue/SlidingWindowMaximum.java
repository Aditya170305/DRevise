import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int ans [] = new int [nums.length - k + 1];
        int index = 0;

        Deque<Integer> dq = new ArrayDeque<Integer>();

        for(int i=0;i<nums.length;i++){

            if(!dq.isEmpty() && dq.getFirst() <= i - k){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]){
                dq.removeLast();
            }

            dq.addLast(i);
            if(i >= k - 1){
                ans[index] = nums[dq.getFirst()];
                index++;
            }

        } 

        return ans;

    }
    
}
