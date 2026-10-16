public class AutomorphicNumber {
    
    public String isAutomorphic(int n) {
        
        int square = n * n;
        
        while(n != 0){
            
            if(square % 10 != n % 10) return "Not Automorphic";
            n = n / 10;
            square = square / 10;
            
        }
        
        return "Automorphic";
        
    }
    
}
