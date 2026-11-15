public class NumberOfSubarraysWithOddSum {
    
    public int numOfSubarrays(int[] arr) {
        
        int n = arr.length;

        int MOD = ((int)1e9) + 7;

        int sum = 0;

        int ans = 0 , odd = 0 , even = 1;

        for(int i=0;i<arr.length;i++){

            sum = sum + arr[i];

            if(sum % 2 == 0){

                ans = (ans + odd) % MOD;
                even++;

            }

            else{

                ans = (ans + even) % MOD;
                odd++;

            }

        }

        return ans;

    }
    
}
