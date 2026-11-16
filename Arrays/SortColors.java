public class SortColors {
    
    public void swap(int a , int b , int [] nums){

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }

    public void sortColors(int[] nums) {
        
        int n = nums.length;

        int low = 0;
        int mid = 0;
        int high = n - 1;

        while(mid <= high){

            if(nums[mid] == 0){

                swap(mid , low , nums);
                low++;
                mid++;

            }

            else if(nums[mid] == 1){

                mid++;

            }

            else{

                swap(mid , high , nums);
                high--;

            }

        }

    }
    
}
