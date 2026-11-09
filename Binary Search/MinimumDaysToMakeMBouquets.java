public class MinimumDaysToMakeMBouquets {
    
    public boolean find(int day , int arr [] , int k , int m){
        
        int bouquets = 0;
        
        int ans = 0;
        
        for(int i=0;i<arr.length;i++){
            
            if(day >= arr[i]){
                
                bouquets++;
                
            }
            
            else{
                
                ans = ans + (bouquets / k);
                bouquets = 0;
                
            }
            
        }
        
        ans = ans + (bouquets / k);
        
        return (ans >= m);
        
    }
    
    public int minDaysBloom(int[] arr, int k, int m) {
        
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            
            maxi = Math.max(maxi , arr[i]);
            mini = Math.min(mini , arr[i]);
            
        }
        
        int low = mini;
        int high = maxi;
        
        int ans = -1;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(find(mid , arr , k , m)){
                
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
