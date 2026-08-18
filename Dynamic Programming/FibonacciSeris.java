
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

        // System.out.println(fibonacci(n , dp));

        //By Tabulation
        //Tc -> O(N);
        //Sc -> O(N);

        // dp[0] = 0;
        // dp[1] = 1;

        // for(int i=2;i<=n;i++){

        //     dp[i] = dp[i - 1] + dp[i - 2];

        // }

        int prev2 = 0;
        int prev = 1;

        for(int i=2;i<=n;i++){

            int curri = prev + prev2;
            
            prev2 = prev;
            prev = curri;

        }

        System.out.println(prev);

    }
}
