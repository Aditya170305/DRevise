import java.util.Stack;

public class SumOfSubarrayRanges {
    
    public void findNext(int [] nums , int [] nse , int [] nge , int n){

        Stack<Integer> s_nse = new Stack<Integer>();
        Stack<Integer> s_nge = new Stack<Integer>();

        for(int i=n-1;i>=0;i--){

            while(!s_nse.isEmpty() && nums[s_nse.peek()] >= nums[i]){
                s_nse.pop();
            }

            while(!s_nge.isEmpty() && nums[s_nge.peek()] <= nums[i]){
                s_nge.pop();
            }

            nse[i] = s_nse.isEmpty() ? n : s_nse.peek();
            nge[i] = s_nge.isEmpty() ? n : s_nge.peek();

            s_nse.add(i);
            s_nge.add(i);

        }

    }

    public void findPrev(int [] nums , int [] pse , int [] pge , int n){

        Stack<Integer> s_pse = new Stack<Integer>();
        Stack<Integer> s_pge = new Stack<Integer>();

        for(int i=0;i<n;i++){

            while(!s_pse.isEmpty() && nums[s_pse.peek()] > nums[i]){
                s_pse.pop();
            }

            while(!s_pge.isEmpty() && nums[s_pge.peek()] < nums[i]){
                s_pge.pop();
            }

            pse[i] = s_pse.isEmpty() ? -1 : s_pse.peek();
            pge[i] = s_pge.isEmpty() ? -1 : s_pge.peek();

            s_pse.add(i);
            s_pge.add(i);

        }

    }

    public long subArrayRanges(int[] nums) {
        
        int n = nums.length;
        int nse [] = new int [n];
        int nge [] = new int [n]; 

        findNext(nums , nse , nge , n);

        int pse [] = new int [n];
        int pge [] = new int [n];

        findPrev(nums , pse , pge , n);

        long totalMaximum = 0L;
        long totalMinimum = 0L;

        for(int i=0;i<n;i++){

            long leftMax = i - pge[i];
            long rightMax = nge[i] - i;

            totalMaximum = totalMaximum + (leftMax * rightMax * nums[i]);

            long leftMin = i - pse[i];
            long rightMin = nse[i] - i;

            totalMinimum = totalMinimum + (leftMin * rightMin * nums[i]);

        }

        return totalMaximum - totalMinimum;

    }
    
}
