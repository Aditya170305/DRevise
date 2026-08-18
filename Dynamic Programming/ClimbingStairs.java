
import java.util.Arrays;

public class ClimbingStairs {
    
    public int find(int index , int [] dp ){

        if(index == 0) return 1;
        if(index == 1) return 1;

        if(dp[index] != -1) return dp[index];
        int left = find(index - 1 , dp);
        int right = find(index - 2 , dp);

        dp[index] = left + right;

        return dp[index];

    }

    public int climbStairs(int n) {
        
        int dp [] = new int [n + 1];

        Arrays.fill(dp , -1);

        return find(n , dp);
    }
}
