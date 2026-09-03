import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L2948 {
    
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int n = nums.length;

        int nums1 [] = nums.clone();

        Arrays.sort(nums1);

        int groupNo = 0;
        Map<Integer , Integer> numToGroup = new HashMap<Integer , Integer>();
        numToGroup.put(nums1[0] , groupNo);
        Map<Integer , List<Integer>> groupToList = new HashMap<>();
        groupToList.put(groupNo , new ArrayList<>());
        groupToList.get(groupNo).add(nums1[0]);

        for(int i=1;i<n;i++){

            if(Math.abs(nums1[i] - nums1[i - 1]) > limit){
                groupNo = groupNo + 1;
            }

            if(!groupToList.containsKey(groupNo)) groupToList.put(groupNo , new ArrayList<>());

            numToGroup.put(nums1[i] , groupNo);
            groupToList.get(groupNo).add(nums1[i]);

        }

        Map<Integer , Integer> pointer = new HashMap<Integer , Integer>();

        for(int i=0;i<=groupNo;i++){
            pointer.put(i , 0);
        }

        for(int i=0;i<n;i++){

            int num = nums[i];
            int group = numToGroup.get(num);
            int index = pointer.get(group);

            nums1[i] = groupToList.get(group).get(index);
            pointer.put(group , index + 1);

        }

        return nums1;

    }
    
}
