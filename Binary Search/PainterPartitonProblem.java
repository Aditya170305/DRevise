public class PainterPartitonProblem {
    
    public int countWalls(int [] arr , int walls){
        
        int count = 1;
        int sum = 0;
        
        for(int i=0;i<arr.length;i++){
            
            if(sum + arr[i] <= walls){
                
                sum = sum + arr[i];
                
            }
            
            else{
                
                sum = arr[i];
                count++;
                
            }
            
        }
        
        return count;
        
    }
    
    public int minTime(int[] arr, int k) {
        
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0;i<arr.length;i++){
            
            maxi = Math.max(maxi , arr[i]);
            sum = sum + arr[i];
            
        }
        
        int low = maxi;
        int high = sum;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            if(countWalls(arr , mid) > k){
                
                low = mid + 1;
                
            }
            
            else{
                
                high = mid - 1;
                
            }
            
        }
        
        return low;
        
    }
    
}
