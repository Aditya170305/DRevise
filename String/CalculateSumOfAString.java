public class CalculateSumOfAString {
    
     public int calculateSum(String str){

        int sum = 0;

        for(int i=0;i<str.length();i++){

            sum = sum + (str.charAt(i) - '0');

        }

        return sum;

    }

    public String digitSum(String s, int k) {

        StringBuilder ans = new StringBuilder(s);

        while(ans.length() > k){

            int n = ans.length();

            StringBuilder temp = new StringBuilder();

            for(int i=0;i<n;i+=k){

                int end = Math.min(i + k , n);

                int sum = calculateSum(ans.substring(i , end));

                temp.append(sum);

            }

            ans = temp;

        }

        return ans.toString();

    }
    
}
