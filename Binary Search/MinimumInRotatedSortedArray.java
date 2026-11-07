public class MinimumInRotatedSortedArray {
    
    public int findMin(int[] arr) {
        
        int n = arr.length;
        
        int mini = Integer.MAX_VALUE;
        
        int low = 0;
        int high = n - 1;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(arr[low] <= arr[mid]){
                
                mini = Math.min(mini , arr[low]);
                low = mid + 1;
                
            }
            
            else{
                
                mini = Math.min(mini , arr[mid]);
                high = mid - 1;
                
            }
            
        }
        
        return mini;
        
    }
    
}
