package Maths;

import java.util.HashSet;
import java.util.Set;

public class L3718 {
    
    public int missingMultiple(int[] nums, int k) {
        
        Set<Integer> st = new HashSet<Integer>();
        
        for(int x : nums){
            if(x % k == 0) st.add(x);
        }

        int i = k;

        while(true){

            if(!st.contains(i)) break;
            i = i + k;

        }

        return i;

    }

}
