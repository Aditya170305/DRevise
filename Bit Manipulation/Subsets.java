import java.util.ArrayList;
import java.util.List;

public class Subsets {
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        int subsets = (1 << n);

        for(int i=0;i<subsets;i++){

            List<Integer> temp = new ArrayList<Integer>();

            for(int j=0;j<n;j++){

                if((i & (1 << j)) != 0) temp.add(nums[j]);

            }

            ans.add(temp);

        }

        return ans;

    }
    
}
