public class CeilInSortedArray {
    
    public int findCeil(int[] arr, int x) {
        
        int n = arr.length;
        
        int ans = -1;
        
        int low = 0;
        int high = n - 1;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(arr[mid] >= x){
                
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
