public class L238 {
    
    public int[] productExceptSelf(int[] nums) {
        
        // int product = 1;
        // int zeros = 0;
        // int zero_index = 0;

        // int n = nums.length;

        // for(int i=0;i<n;i++){

        //     int num = nums[i];

        //     if(num != 0){
        //         product = product * num;
        //     }

        //     else{
        //         zeros++;
        //         zero_index = i;
        //     }

        // }

        // int result [] = new int [n];

        // if(zeros > 1){
        //     return result;
        // }

        // if(zeros == 1){
        //     result[zero_index] = product;
        //     return result;
        // }

        // int index = 0;

        // for(int i=0;i<n;i++){

        //     result[index] = product / nums[i];
        //     index++;

        // }

        // return result;

        int n = nums.length;
        
        int [] prefix = new int [n];
        int [] suffix = new int [n];
        
        prefix[0] = nums[0];
        
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i - 1] * nums[i];
        }
        
        suffix[n - 1] = nums[n - 1];
        
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i + 1] * nums[i];
        }
        
        nums[0] = suffix[1];
        nums[n - 1] = prefix[n - 2];
        
        for(int i=1;i<n-1;i++){
            nums[i] = prefix[i - 1] * suffix[i + 1];
        }
        
        return nums;

    }

}
