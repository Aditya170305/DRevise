public class StrongNumbers {
    
    public int fact(int n){
        
        int fact = 1;
        
        while(n != 0){
            fact = fact * n;
            n--;
        }
        
        return fact;
        
    }
    
    public boolean isStrong(int n) {
        
        int sum = 0;
        
        int n1 = n;
        
        while(n != 0){
            
            sum = sum + fact(n % 10);
            n = n / 10;
            
        }
        
        return (sum == n1);
        
    }
    
}
