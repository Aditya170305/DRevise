
public class FrogJumpsWithKDistance {
    
    public static int find(int index , int height [] , int dp [] , int k ){

        if(index == 0) return 0;

        if(dp[index] != -1) return dp[index];

        int min_steps = Integer.MAX_VALUE;

        for(int j=1;j<=k;j++){

            if(index - j >= 0){
                int steps = find(index - j , height , dp , k) + Math.abs( height[index] - height[index - j] );
                min_steps = Math.min(min_steps , steps);
            }

            else{
                break;
            }

        }

        dp[index] = min_steps;

        return dp[index];

    }
    public static int minimizeCost(int n, int k, int []height){
        
        // int dp [] = new int [n + 1];

        // Arrays.fill(dp , -1);

        // return find(n - 1 , height , dp , k);

        int dp [] = new int [n];

        dp[0] = 0;

        for(int i=1;i<n;i++){

            int min_steps = Integer.MAX_VALUE;

            for(int j=1;j<=k;j++){

                if(i - j >= 0){

                    int steps = dp[i - j] + Math.abs( height[i] - height[i - j] );
                    min_steps = Math.min(min_steps , steps);

                }

            }

            dp[i] = min_steps;

        }

        return dp[n - 1];
        
    }
}
