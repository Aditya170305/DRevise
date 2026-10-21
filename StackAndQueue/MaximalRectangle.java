import java.util.Stack;

public class MaximalRectangle {
    
    public int findMax(int [] nums){

        int n = nums.length;

        Stack<Integer> st = new Stack<Integer>();
        int maxArea = 0;

        for(int i=0;i<n;i++){

            while(!st.isEmpty() && nums[st.peek()] > nums[i]){

                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(maxArea , nums[element] * (nse - pse - 1));

            }

            st.add(i);

        }

        while(!st.isEmpty()){

            int nse = n;
            int element = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(maxArea , nums[element] * (nse - pse - 1));

        }

        return maxArea;

    }

    public int maximalRectangle(char[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        int prefSum [][] = new int [n][m];

        for(int j=0;j<m;j++){

            int sum = 0;

            for(int i=0;i<n;i++){

                sum = sum + matrix[i][j] - '0';
                if((matrix[i][j] - '0') == 0) sum = 0;
                prefSum[i][j] = sum;

            }

        }

        int maxArea = 0;

        for(int i=0;i<n;i++){

            maxArea = Math.max(maxArea , findMax(prefSum[i]));

        }

        return maxArea;

    }
    
}
