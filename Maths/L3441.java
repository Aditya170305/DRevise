public class L3441 {
    
    public int lcm(int a , int b){

        return a * b / gcd(a , b);

    }

    public int gcd(int a , int b){

        while(a != 0 && b != 0){

            if(a > b) a = a % b;

            else b = b % a;

        }

        return (a == 0) ? b : a;

    }

    public int maxLength(int[] nums) {
        
        int n = nums.length;

        int ans = 0;

        for(int i=0;i<n;i++){

            int lcm = 1;
            int gcd = 0;

            int product = 1;

            for(int j=i;j<n;j++){

                product = product * nums[j];

                gcd = gcd(gcd , nums[j]);
                lcm = lcm(lcm , nums[j]);

                int len = j - i + 1;

                if(product == (gcd * lcm)) ans = Math.max(ans , len);

            }

        }

        return ans;

    }
    
}
