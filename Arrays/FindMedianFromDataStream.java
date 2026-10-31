import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    
    PriorityQueue<Integer> left_heap;
    PriorityQueue<Integer> right_heap;

    public FindMedianFromDataStream() {
        
        left_heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        right_heap = new PriorityQueue<Integer>();

    }
    
    public void addNum(int num) {
        
        if(left_heap.isEmpty() || num < left_heap.peek()){
            left_heap.offer(num);
        }

        else{
            right_heap.offer(num);
        }

        if(left_heap.size() - right_heap.size() > 1){
            right_heap.offer(left_heap.poll());
        }

        else if(left_heap.size() < right_heap.size()){
            left_heap.offer(right_heap.poll());
        }

    }
    
    public double findMedian() {
        
        return (left_heap.size() == right_heap.size()) ? (double)(left_heap.peek() + right_heap.peek()) / 2 : left_heap.peek();

    }

}
