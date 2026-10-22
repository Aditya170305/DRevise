import java.util.ArrayList;
import java.util.Stack;

public class StoackSpanProblem {
    
    public ArrayList<Integer> calculateSpan(int[] arr) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i=0;i<arr.length;i++){
            
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            
            ans.add(i - (st.isEmpty() ? -1 : st.peek()));
            st.add(i);
            
        }
        
        return ans;
        
    }
    
}
