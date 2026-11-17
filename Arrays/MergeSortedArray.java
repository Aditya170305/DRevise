public class MergeSortedArray {
    
    public void swap(int ind1 , int ind2 , int nums []){

        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int len = nums1.length;

        int index = 0;

        for(int i=m;i<len;i++){

            nums1[i] = nums2[index];
            index++;

        }

        int gap = (len / 2) + (len % 2);

        while(gap > 0){

            int left = 0;
            int right = left + gap;

            while(right < len){

                if(nums1[left] > nums1[right]){

                    swap(left , right , nums1);

                }

                left++;
                right++;

            }

            if(gap == 1) break;
            gap = (gap / 2) + (gap % 2);
            
        }

    }
    
}
