import java.util.TreeMap;

public class L1296 {
    
    public boolean isPossibleDivide(int[] nums, int k) {
        
        int n = nums.length;

        if(n % k != 0){
            return false;
        }

        TreeMap<Integer , Integer> mpp = new TreeMap<Integer , Integer>();

        for(int num : nums){

            if(mpp.containsKey(num)){
                mpp.put(num , mpp.get(num) + 1);
            }

            else{
                mpp.put(num , 1);
            }

        }

        while(!mpp.isEmpty()){

            int first = mpp.firstKey();

            for(int i=0;i<k;i++){

                int curr = first + i;

                if(!mpp.containsKey(curr)){
                    return false;
                }

                mpp.put(curr , mpp.get(curr) - 1);

                if(mpp.get(curr) == 0){
                    mpp.remove(curr);
                }

            }

        }

        return true;

    }
    
}
