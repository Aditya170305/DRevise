public class FindHowManyTimesArrayIsRotated {
    
    public int findKRotation(int arr[]) {
        
        int n = arr.length;
        
        int mini = Integer.MAX_VALUE;
        int ans = -1;
        
        int low = 0;
        int high = n - 1;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(arr[low] <= arr[mid]){
                
                if(arr[low] < mini){
                    
                    mini = arr[low];
                    ans = low;
                    
                }
                
                low = mid + 1;
                
            }
            
            else{
                
                if(arr[mid] < mini){
                    
                    mini = arr[mid];
                    ans = mid;
                    
                }
                
                high = mid - 1;
                
            }
            
        }
        
        return ans;
        
    }
    
}
