public class KokoEatingBananas {
    
    public int find(int arr [] , int hourly){
        
        int time = 0;
        
        for(int i=0;i<arr.length;i++){
            
            time = time + (int)Math.ceil((double)arr[i] / hourly);
            
        }
        
        return time;
        
    }
    
    public int kokoEat(int[] arr, int k) {
        
        int maxi = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            
            maxi = Math.max(maxi , arr[i]);
            
        }
        
        int low = 1;
        int high = maxi;
        
        int ans = 0;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            int time = find(arr , mid);
            
            if(time <= k){
                
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
