public class FirstMissingPositive {
    
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;

        boolean contains = false;

        for(int i=0;i<n;i++){

            if(nums[i] == 1) contains = true;

            if(nums[i] <= 0 || nums[i] > n) nums[i] = 1;

        }

        if(!contains) return 1;

        for(int i=0;i<n;i++){

            int num = Math.abs(nums[i]);
            int index = num - 1;

            if(nums[index] > 0){

                nums[index] = -nums[index];

            }

        }

        for(int i=0;i<n;i++){

            if(nums[i] > 0) return i + 1;

        }

        return n + 1;

    }
    
}
