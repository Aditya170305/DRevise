package Maths;

public class L3876 {
    
    public boolean uniformArray(int[] nums1) {
        
        int mini = Integer.MAX_VALUE;

        for(int i=0;i<nums1.length;i++){
            mini = Math.min(mini , nums1[i]);
        }

        if(mini % 2 == 1) return true;

        for(int i=0;i<nums1.length;i++){
            if(nums1[i] % 2 == 1) return false;
        }

        return true;

    }

}
