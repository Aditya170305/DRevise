public class MissingNumber {
    
    public int missingNumber(int[] nums) {
        
        int n = nums.length;

        int XOR1 = 0;
        int XOR2 = 0;

        for(int i=0;i<n;i++){

            XOR1 = XOR1 ^ nums[i];
            XOR2 = XOR2 ^ (i + 1);

        }

        return XOR1 ^ XOR2;
        
    }
    
}
