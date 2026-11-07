public class FloorInSortedArray {
    
    static int findFloor(int[] arr, int x) {
        
        int n = arr.length;
        
        int ans = -1;
        
        int low = 0;
        int high = n - 1;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(arr[mid] <= x){
                
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
