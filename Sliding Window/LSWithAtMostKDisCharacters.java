import java.util.Map;
import java.util.HashMap;

public class LSWithAtMostKDisCharacters {
    public static int kDistinctSubarrays(int[] arr, int n, int k) {
        
        int l = 0 , r = 0 , maxlen = 0;

        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();

        while(r < n){

            if(mpp.containsKey(arr[r])){
                mpp.put(arr[r] , mpp.get(arr[r]) + 1);
            }

            else{
                mpp.put(arr[r] , 1);
            }

            while(mpp.size() > k){

                mpp.put(arr[l] , mpp.get(arr[l]) - 1);

                if(mpp.get(arr[l]) == 0) mpp.remove(arr[l]);

                l++;

            }

            if(mpp.size() <= k){
                maxlen = Math.max(maxlen , r - l + 1);
            }

            r++;

        }

        return maxlen;
        
    }
}
