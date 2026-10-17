import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L3551 {
    
    public int getDigitSum(int num){

        int sum = 0;
        while(num != 0){

            sum = sum + (num % 10);
            num = num / 10;

        }

        return sum;

    }

    public int minSwaps(int[] nums) {

        Integer arr [] = new Integer [nums.length];

        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();

        for(int i=0;i<nums.length;i++){
            arr[i] = nums[i];
            mpp.put(arr[i] , i);
        }
        
        Arrays.sort(arr , (a , b) -> {

            int ds1 = getDigitSum(a);
            int ds2 = getDigitSum(b);

            if(ds1 != ds2){
                return Integer.compare(ds1 , ds2);
            }

            return Integer.compare(a , b);

        });

        int swaps = 0;

        for(int i=0;i<nums.length;i++){

            int exp_val = arr[i];
            int org_val = nums[i];

            if(exp_val == org_val) continue;

            int index = mpp.get(exp_val);

            nums[i] = exp_val;
            nums[index] = org_val;

            mpp.put(exp_val , i);
            mpp.put(org_val , index);

            swaps++;

        }

        return swaps;

    }
    
}
