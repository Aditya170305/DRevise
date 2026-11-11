public class RowWithMax1sInRowwiseSorted {
    
    public int lower_bound(int [] arr , int target){
        
        int n = arr.length;
        
        int low = 0;
        int high = n - 1;
        
        int ans = n;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(arr[mid] >= target){
                
                ans = mid;
                high = mid - 1;
                
            }
            
            else{
                
                low = mid + 1;
                
            }
            
        }
        
        return ans;
        
    }
    
    public int rowWithMax1s(int[][] arr) {
        
        int ans = 0;
        int index = -1;
        
        for(int i=0;i<arr.length;i++){
                
            int count = arr[0].length - lower_bound(arr[i] , 1);
            
            if(count > ans){
                
                ans = count;
                index = i;
                
            }
            
        }
        
        return index;
        
    }
    
}
