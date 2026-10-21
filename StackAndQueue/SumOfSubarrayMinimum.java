import java.util.Stack;

public class SumOfSubarrayMinimum {
    
    public int [] findNse(int arr []){
        
        int n = arr.length;
        Stack<Integer> st = new Stack<Integer>();
        int ans [] = new int [n];
        
        for(int i=n-1;i>=0;i--){
            
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
            
        }
        
        return ans;
        
    }
    
    public int [] findPsee(int arr []){
        
        int n = arr.length;
        Stack<Integer> st = new Stack<Integer>();
        int ans [] = new int [n];
        
        for(int i=0;i<n;i++){
            
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
            
        }
        
        return ans;
        
    }
    
    public int sumSubMins(int[] arr) {
        
        int nse [] = findNse(arr);
        int pse [] = findPsee(arr);
        
        int sum = 0;
        
        for(int i=0;i<arr.length;i++){
            
            int left = i - pse[i];
            int right = nse[i] - i;
            
            sum = sum + (left * right) * arr[i];
            
        }
        
        return sum;
        
    }
    
}
