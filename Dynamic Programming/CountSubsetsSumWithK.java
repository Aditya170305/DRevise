import java.util.Arrays;

public class CountSubsetsSumWithK {
    
    public static int find(int index , int sum , int num [] , int dp [][]){
        
        if(index == 0){

            if(sum == 0 && num[0] == 0) return 2;
            if(sum == 0 || num[0] == sum) return 1;
            return 0;

        }

        if(dp[index][sum] != -1) return dp[index][sum];

        int not_take = find(index - 1 , sum , num , dp);
        int take = 0;

        if(sum >= num[index]) take = find(index - 1 , sum - num[index] , num , dp);

        dp[index][sum] = (take + not_take) % (1000000000 + 7);

        return dp[index][sum];

    }
    
    public static int findWays(int num[], int tar) {
        
        int n = num.length;

        int dp [][] = new int [n][tar + 1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i] , -1);
        }

        return find(n - 1 , tar , num , dp);

    }
}
