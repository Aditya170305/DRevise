public class SmallestDivisor {
    
    boolean find(int divisor , int arr [] , int k){
        
        int ans = 0;
        
        for(int i=0;i<arr.length;i++){
            
            ans = ans + (int)Math.ceil((double)arr[i] / divisor);
            
        }
        
        return (ans <= k);
        
    }
    
    int smallestDivisor(int[] arr, int k) {
        
        int maxi = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            
            maxi = Math.max(maxi , arr[i]);
            
        }
        
        int low = 1;
        int high = maxi;
        
        int ans = 0;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(find(mid , arr , k)){
                
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
