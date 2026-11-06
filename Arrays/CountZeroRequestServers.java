import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountZeroRequestServers {
    
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs , ( a , b ) -> Integer.compare(a[1] , b[1]));

        int p = logs.length;
        int m = queries.length;

        int q [][] = new int [m][2];

        for(int i=0;i<m;i++){

            q[i][0] = queries[i];
            q[i][1] = i;

        }

        Arrays.sort(q , ( a , b ) -> Integer.compare(a[0] , b[0]));

        int ans [] = new int [m];

        Map<Integer , Integer> mpp = new HashMap<Integer , Integer>();

        int i = 0;
        int j = 0;

        for(int index=0;index<m;index++){

            int start = q[index][0] - x;
            int end = q[index][0];
            int final_index = q[index][1];

            while(j < p && logs[j][1] <= end){

                if(mpp.containsKey(logs[j][0])){
                    mpp.put(logs[j][0] , mpp.get(logs[j][0]) + 1);
                }

                else{
                    mpp.put(logs[j][0] , 1);
                }

                j++;

            }

            while(i < j && logs[i][1] < start){

                int id = logs[i][0];

                mpp.put(id , mpp.get(id) - 1);

                if(mpp.get(id) == 0){
                    mpp.remove(logs[i][0]);
                }

                i++;

            }

            ans[final_index] = n - mpp.size();

        }

        return ans;
        
    }
    
}
