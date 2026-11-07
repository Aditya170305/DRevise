public class UpperBound {
    
    int upperBound(int[] arr, int target) {
        
        int n = arr.length;
        
        int ans = n;
        
        int low = 0;
        int high = n - 1;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(arr[mid] > target){
                
                ans = mid;
                high = mid - 1;
                
            }
            
            else{
                
                low = mid + 1;
                
            }
            
        }
        
        return ans;
        
    }
    
}
