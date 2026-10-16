import java.util.List;

public class L2897 {
    
    public int maxSum(List<Integer> nums, int k) {
        
        int count [] = new int [32];

        for(int i=0;i<=31;i++){

            for(int j=0;j<nums.size();j++){

                if((nums.get(j) & (1 << i)) != 0) count[i]++;

            }

        }

        int result = 0;

        while(k != 0){

            int curr = 0;

            for(int i=0;i<=31;i++){

                if(count[i] > 0){
                    count[i]--;
                    curr = (curr | (1 << i));
                }

            }

            result = (int)((result + (long) curr * curr) % 1000000007);

            k--;

        }

        return result;

    }
    
}
