public class CheckSumOf2Primes {
    
    public boolean isSumOfTwo(int n) {
        
        int sieve [] = new int [n + 1];
        
        for(int i=2;i*i<=n;i++){
            
            if(sieve[i] == 0){
            
                for(int j=i*i;j<=n;j+=i){
                
                    sieve[j] = 1;
                
                }
                
            }
            
        }
        
        for(int l=2;l<=n/2;l++){
            int r = n - l;
            
            if(sieve[l] == 0 && sieve[r] == 0) return true;
        }
        
        return false;
        
    }
}
