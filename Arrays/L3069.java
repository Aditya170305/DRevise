import java.util.ArrayList;
import java.util.List;

public class L3069 {
    
    public int[] resultArray(int[] nums) {
        
        int n = nums.length;

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        list1.add(nums[0]);
        list2.add(nums[1]);

        for(int i=2;i<n;i++){

            if(list1.get(list1.size() - 1) > list2.get(list2.size() - 1)){

                list1.add(nums[i]);

            }

            else{

                list2.add(nums[i]);

            }

        }

        int result [] = new int [n];

        int j = 0 , k = 0;

        for(int i=0;i<n;i++){

            if(list1.size() > j){
                result[i] = list1.get(j);
                j++;
            }

            else{
                result[i] = list2.get(k);
                k++;
            }

        }

        return result;

    }
}
