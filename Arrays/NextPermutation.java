public class NextPermutation {
    
    public void swap(int a , int b , int [] nums){

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    public void reverse(int left , int right , int [] nums){

        while(left < right){

            swap(left , right , nums);
            left++;
            right--;            

        }

    }

    public void nextPermutation(int[] nums) {
        
        int n = nums.length;

        int index = -1;

        for(int i=n-2;i>=0;i--){

            if(nums[i] < nums[i + 1]){

                index = i;
                break;

            }

        }

        if(index == -1){

            reverse(0 , n - 1 , nums);
            return;

        }

        for(int i=n-1;i>=0;i--){

            if(nums[i] > nums[index]){

                swap(i , index , nums);
                break;

            }

        }

        reverse(index + 1 , n - 1 , nums);
        
    }
    
}
