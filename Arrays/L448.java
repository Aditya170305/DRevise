import java.util.ArrayList;
import java.util.List;

public class L448 {
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        // int freq [] = new int [nums.length + 1];

        // for(int i=0;i<nums.length;i++){
        //     freq[nums[i]]++;
        // }

        // List<Integer> ans = new ArrayList<Integer>();

        // for(int i=1;i<nums.length+1;i++){
        //     if(freq[i] == 0) ans.add(i);
        // }

        // return ans;

        for(int i=0;i<nums.length;i++){

            int index = Math.abs(nums[i]) - 1;

            if(nums[index] > 0){
                nums[index] = -nums[index];
            }

        }

        List<Integer> ans = new ArrayList<Integer>();

        for(int i=0;i<nums.length;i++){

            if(nums[i] > 0){
                ans.add(i + 1);
            }

        }

        return ans;

    }
    
}
