public class SearchInsertPosition {
    
    public int searchInsertK(int arr[], int k) {
        
        int n = arr.length;
        
        int ans = n;
        
        int low = 0;
        int high = n - 1;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(arr[mid] == k){
                
                return mid;
                
            }
            
            else if(arr[mid] > k){
                
                high = mid - 1;
                ans = mid;
                
            }
            
            else{
                
                low = mid + 1;
                
            }
            
        }
        
        return ans;
        
    }
    
}
