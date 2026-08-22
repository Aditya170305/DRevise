package Maths;

public class L3622 {
    
    public boolean checkDivisibility(int n) {
        
        int sum = 0;
        int product = 1;

        int dup_n = n;

        while(n != 0){

            int digit = n % 10;
            sum = sum + digit;
            product = product * digit;

            n = n / 10;

        }

        return dup_n % (sum + product) == 0;
    }
    
}
