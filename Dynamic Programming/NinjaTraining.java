public class NinjaTraining {
    
    public static int f(int day , int last , int points [][] , int dp [][]){

        if(day == 0){

            int maxi = 0;

            for(int i=0;i<3;i++){
                if(i != last) maxi = Math.max(maxi , points[day][i]);
            }

            return maxi;

        }

        if(dp[day][last] != -1) return dp[day][last];

        int maxi = 0;

        for(int i=0;i<3;i++){

            if(i != last){
                int point = points[day][i] + f(day - 1 , i , points , dp);
                maxi = Math.max(maxi , point);
            }
        }

        dp[day][last] = maxi;

        return dp[day][last];

    }
    
    public static int ninjaTraining(int n, int points[][]) {

        // int dp [][] = new int [n][4];

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<4;j++){
        //         dp[i][j] = -1;
        //     }
        // }

        // return f(n - 1 , 3 , points , dp);

        int dp [] = new int [4];

        dp[0] = Math.max(points[0][1] , points[0][2]);
        dp[1] = Math.max(points[0][0] , points[0][2]);
        dp[2] = Math.max(points[0][0] , points[0][1]);
        dp[3] = Math.max(points[0][0] , Math.max(points[0][1] , points[0][2]));

        for(int day=1;day<n;day++){

            int temp [] = new int [4];

            for(int last=0;last<4;last++){

                temp[last] = 0;

                for(int task=0;task<3;task++){

                    if(last != task){
                        temp[last] = Math.max(temp[last] , points[day][task] + dp[task]);
                    }
                }

            }

            dp = temp.clone();
            
        }

        return dp[3];

    }
    
}
