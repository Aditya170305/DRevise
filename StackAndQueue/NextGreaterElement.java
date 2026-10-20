import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {
    
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        
        Stack<Integer> st = new Stack<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i=arr.length-1;i>=0;i--){
            
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            
            ans.add(0 , st.isEmpty() ? -1 : st.peek());
            st.add(arr[i]);
            
        }
        
        return ans;
        
    }
    
}
