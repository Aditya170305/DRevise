public class DecimalToBinary {
    
    static String decToBinary(int n) {
        
        String res = "";
        
        while(n != 0){
            
            res = (n % 2) + res;
            n = n / 2;
            
        }
        
        return res;
        
    }

}
