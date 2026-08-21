import java.util.ArrayList;
import java.util.List;

public class HouseRobberII {
    
    public int find(List<Integer> nums){

        int prev = nums.get(0);
        int prev2 = 0;

        for(int i=1;i<nums.size();i++){

            int take = nums.get(i) + prev2;
            int not_take = 0 + prev;

            int curi = Math.max(take , not_take);

            prev2 = prev;
            prev = curi;

        }

        return prev;

    }
    
    public int rob(int[] nums) {
        
        int n = nums.length;

        if(nums.length == 1) return nums[0];

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        for(int i=0;i<n;i++){

            if(i != 0) list1.add(nums[i]);
            if(i != n - 1) list2.add(nums[i]);

        }

        return Math.max(find(list1) , find(list2));

    }
}
