import java.util.ArrayList;

public class MaxConsecutiveOnesIII {
    
    public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		
		int l = 0 , r = 0 , maxlen = 0;

		int zeros = 0;

		while(r < n){

			if(arr.get(r) == 0) zeros++;

			while(zeros > k){

				if(arr.get(l) == 0) zeros--;
				l++;

			}

			if(zeros <= k){
				maxlen = Math.max(maxlen , r - l + 1);
			}

			r++;

		}

		return maxlen;
		
	}
}
