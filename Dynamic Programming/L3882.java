public class L3882 {
    
    public int minCost(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int dp [][][] = new int [n][m][1024];

        dp[0][0][grid[0][0]] = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(i == 0 && j == 0) continue;

                int up [] = new int [1024];
                int left [] = new int [1024];

                if(i > 0){

                    for(int val=0;val<1024;val++){

                        up[val] = dp[i - 1][j][val];

                    }

                }

                if(j > 0){

                    for(int val=0;val<1024;val++){

                        left[val] = dp[i][j - 1][val];

                    }

                }

                int combined [] = new int [1024];

                for(int val=0;val<1024;val++){

                    if(up[val] == 1 && left[val] == 1) combined[val] = 1;
                    else if(up[val] == 1) combined[val] = 1;
                    else if(left[val] == 1) combined[val] = 1;

                }

                for(int xorVal=0;xorVal<1024;xorVal++){

                    if(combined[xorVal] == 1){

                        int resultXorVal = xorVal ^ grid[i][j];
                        dp[i][j][resultXorVal] = 1;

                    }

                }

            }

        }

        for(int xorVal=0;xorVal<1024;xorVal++){

            if(dp[n - 1][m - 1][xorVal] == 1){

                return xorVal;

            }

        }

        return -1;

    }
    
}
