public class RearrangeElementsBySign {
    
    public int[] rearrangeArray(int[] nums) {
        
        int n = nums.length;

        int ans [] = new int [n];

        int posIndex = 0;
        int negIndex = 1;

        for(int num : nums){

            if(num < 0){

                ans[negIndex] = num;
                negIndex = negIndex + 2;

            }

            else{

                ans[posIndex] = num;
                posIndex = posIndex + 2;

            }

        }

        return ans;

    }
    
}
