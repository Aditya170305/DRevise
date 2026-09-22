
public class WildcardMatching {
    
    public boolean find(int i , int j , int dp [][] , String s , String p){

        if(i < 0 && j < 0) return true;
        if(i < 0 && j >= 0) return false;
        if(i >= 0 && j < 0){

            for(int index=0;index<=i;index++){
                if(p.charAt(index) != '*'){
                    return false;
                }
            }

            return true;

        }

        if(dp[i][j] != -1){

            return dp[i][j] == 1 ? true : false;

        }

        if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?'){
            
            boolean val = find(i - 1 , j - 1 , dp , s , p);
            if(val) dp[i][j] = 1;
            else dp[i][j] = 0;

        }

        if(p.charAt(i) == '*'){
            boolean val = find(i - 1 , j , dp , s , p) || find(i , j - 1 , dp , s , p);
            if(val) dp[i][j] = 1;
            else dp[i][j] = 0;
        }

        return dp[i][j] == 1 ? true : false;

    }
    
    public boolean isMatch(String s, String p) {
        
        int n1 = s.length();
        int n2 = p.length();

        // int dp [][] = new int [n2][n1];

        // for(int i=0;i<n2;i++){
        //     Arrays.fill(dp[i] , -1);
        // }

        // return find(n2 - 1 , n1 - 1 , dp , s , p);

        boolean dp [][] = new boolean [n2 + 1][n1 + 1];

		dp[0][0] = true;

		for(int j=1;j<=n2;j++){
			dp[0][j] = false;
		}

		for(int i=1;i<=n1;i++){

			boolean flag = true;

			for(int index=1;index<=i;index++){

				if(p.charAt(index - 1) != '*'){
					flag = false;
					break;
				}
			}

			dp[i][0] = flag;

		}

		for(int i=1;i<=n1;i++){
			for(int j=1;j<=n2;j++){

				if(p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?'){
					dp[i][j] = dp[i - 1][j - 1];
				}

				else if(p.charAt(i - 1) == '*'){
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}

				else{
					dp[i][j] = false;
				}

			}

		}

		return dp[n1][n2];

    }

}
