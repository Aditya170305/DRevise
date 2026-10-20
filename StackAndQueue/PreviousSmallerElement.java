import java.util.ArrayList;
import java.util.Stack;

public class PreviousSmallerElement {
    
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        
        Stack<Integer> st = new Stack<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0;i<arr.length;i++){
            
            while(!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }
            
            ans.add(st.isEmpty() ? -1 : st.peek());
            st.add(arr[i]);
            
        }
        
        return ans;
        
    }
    
}
