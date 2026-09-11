public class SingleNumberIII {
    
    public int[] singleNumber(int[] nums) {
        
        int XOR = 0;

        for(int i=0;i<nums.length;i++){
            XOR = XOR ^ nums[i];
        }

        int rightmost = (XOR & XOR - 1) ^ XOR;

        int b1 = 0 , b2 = 0;

        for(int i=0;i<nums.length;i++){

            if((nums[i] & rightmost) != 0){
                b1 = b1 ^ nums[i];
            }

            else{
                b2 = b2 ^ nums[i];
            }

        }

        return new int []{b1 , b2};

    }
    
}
