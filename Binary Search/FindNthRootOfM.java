public class FindNthRootOfM {
    
    public int find(int n , int mid , int m){
        
        long ans = 1;
        
        for(int i=1;i<=n;i++){
            
            ans = ans * mid;
            
            if(ans > m){
                
                return 2;
                
            }
            
        }
        
        if(ans == m){
            
            return 1;
            
        }
        
        return 0;
        
    }
    
    public int nthRoot(int n, int m) {
        
        if(m == 1){
            
            return 1;
            
        }
        
        if(m == 0){
            
            return 0;
            
        }
        
        int low = 1;
        int high = m;
        
        while(low <= high){
            
            int mid = (low + high) >> 1;
            
            int midN = find(n , mid , m);
            
            if(midN == 1){
                
                return mid;
                
            }
            
            else if(midN == 0){
                
                low = mid + 1;
                
            }
            
            else{
                
                high = mid - 1;
                
            }
            
        }
        
        return -1;
        
    }
    
}
