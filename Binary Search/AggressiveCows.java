import java.util.Arrays;

public class AggressiveCows {
    
    public boolean canWePlace(int [] arr , int dist , int k){
        
        int countCows = 1;
        int last = arr[0];
        
        for(int i=1;i<arr.length;i++){
            
            if(arr[i] - last >= dist){
                
                countCows++;
                last = arr[i];
                
            }
            
            if(countCows >= k){
                
                return true;
                
            }
            
        }
        
        return false;
        
    }
    
    public int aggressiveCows(int[] arr, int k) {
        
        Arrays.sort(arr);
        
        int low = 0;
        int high = arr[arr.length - 1] - arr[0];
        
        int ans = 0;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(canWePlace(arr , mid , k)){
                
                ans = mid;
                low = mid + 1;
                
            }
            
            else{
                
                high = mid - 1;
                
            }
            
        }
        
        return ans;
        
    }
    
}
