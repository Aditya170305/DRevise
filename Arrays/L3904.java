public class L3904 {
    
    public int firstStableIndex(int[] nums, int k) {
        
        int n = nums.length;

        int prefMax [] = new int [n];
        int suffMax [] = new int [n];

        prefMax[0] = nums[0];
        suffMax[n - 1] = nums[n - 1];

        int index = n - 1;

        for(int i=1;i<n;i++){

            prefMax[i] = Math.max(prefMax[i - 1] , nums[i]);
            suffMax[n - i - 1] = Math.min(suffMax[index--] , nums[n -i - 1]);

        }

        for(int i=0;i<n;i++){

            if(prefMax[i] - suffMax[i] <= k) return i;

        }

        return -1;

    }
}
