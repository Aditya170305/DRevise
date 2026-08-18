
import java.util.Arrays;
import java.util.Scanner;

public class FibonacciSeris {

    public static int fibonacci(int n , int dp [] ){

        if(n <= 1){
            return n;
        }

        if(dp[n] != -1) return dp[n];

        return fibonacci(n - 1 , dp) + fibonacci(n - 2 , dp);

    } 

    public static void main(String[] args) {

        //By Memoization
        // Tc -> O(N);
        // Sc -> O(N) + O(N) ---> For Array
        
        int n;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int dp [] = new int [n + 1];

        Arrays.fill(dp, -1);

        System.out.println(fibonacci(n , dp));

    }
}
