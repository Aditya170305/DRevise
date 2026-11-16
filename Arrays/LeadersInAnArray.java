import java.util.ArrayList;
import java.util.Collections;

public class LeadersInAnArray {
    
    static ArrayList<Integer> leaders(int arr[]) {

        int n = arr.length;
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int maxi = Integer.MIN_VALUE;
        
        for(int i=n-1;i>=0;i--){
            
            if(arr[i] >= maxi){
                
                ans.add(arr[i]);
                
            }
            
            maxi = Math.max(maxi , arr[i]);
            
        }
        
        Collections.reverse(ans);
        return ans;
        
    }
    
}
