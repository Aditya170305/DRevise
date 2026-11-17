import java.util.ArrayList;

public class FindMissingAndRepeatingNumber {
    
    ArrayList<Integer> findTwoElement(int arr[]) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        long n = arr.length;
        
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;
        
        long S = 0 , S2 = 0;
        
        for(int i=0;i<arr.length;i++){
            
            S = S + arr[i];
            S2 = S2 + (long)arr[i] * (long)arr[i];
            
        }
        
        long val1 = S - SN;
        long val2 = S2 - S2N;
        
        val2 = val2 / val1;
        
        long x = (val1 + val2) / 2;
        long y = x - val1;
        
        ans.add((int)x);
        ans.add((int)y);
        
        return ans;
        
    }
    
}
