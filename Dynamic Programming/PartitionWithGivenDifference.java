public class PartitionWithGivenDifference {
    
    public static int find(int index , int sum , int dp [][] , int arr []){

		if(index == 0){

			if(sum == 0 && arr[0] == 0) return 2;
			if(sum == 0 || arr[0] == sum) return 1;
			return 0;

		}

		if(dp[index][sum] != -1) return dp[index][sum];

		int not_take = find(index - 1 , sum , dp , arr);
		int take = 0;

		if(sum >= arr[index]) take = find(index - 1 , sum - arr[index] , dp , arr);

		dp[index][sum] = (take + not_take) % (1000000000 + 7);

		return dp[index][sum];

	}
	
	public static int countPartitions(int n, int d, int[] arr) {

		int totalSum = 0;

		for(int i=0;i<n;i++){
			totalSum = totalSum + arr[i];
		}

		if(totalSum - d < 0 || (totalSum - d) % 2 == 1) return 0;

		int sum = (totalSum - d) / 2;
		
		int dp [][] = new int [n][sum + 1];

		// for(int i=0;i<n;i++){
		// 	Arrays.fill(dp[i] , -1);
		// }

		// return find(n - 1 , sum , dp , arr);

		if(arr[0] == 0) dp[0][0] = 2;
		else dp[0][0] = 1;

		if(arr[0] != 0 && sum >= arr[0]) dp[0][arr[0]] = 1;

		for(int i=1;i<n;i++){

			for(int tar=0;tar<=sum;tar++){

				int not_take = dp[i - 1][tar];
				int take = 0;

				if(tar >= arr[i]) take = dp[i - 1][tar - arr[i]];

				dp[i][tar] = (take + not_take) % (1000000000 + 7);

			}
		}

		return dp[n - 1][sum];

	}
}
