public class SearchInRotatedSortedArrayII {
    
    public boolean search(int[] arr, int key) {
        
        int n = arr.length;
        
        int low = 0;
        int high = n - 1;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(arr[mid] == key) return true;
            
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                
                low = low + 1;
                high = high - 1;
                continue;
                
            }
            
            if(arr[low] <= arr[mid]){
                
                if(arr[low] <= key && key <= arr[mid]){
                    
                    high = mid - 1;
                    
                }
                
                else{
                    
                    low = mid + 1;
                    
                }
                
            }
            
            else{
                
                if(arr[mid] <= key && key <= arr[high]){
                    
                    low = mid + 1;
                    
                }
                
                else{
                    
                    high = mid - 1;
                    
                }
                
            }
            
        }
        
        return false;
        
    }
    
}
