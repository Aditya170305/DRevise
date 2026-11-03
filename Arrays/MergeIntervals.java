import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals , ( a , b ) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();

        int n = intervals.length;

        for(int i=0;i<n;i++){

            if(list.isEmpty() || intervals[i][0] > list.get(list.size() - 1)[1]){

                list.add(intervals[i]);

            }

            else{

                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1] , intervals[i][1]);

            }

        }

        int ans [][] = new int [list.size()][2];

        int index = 0;

        for(int i=0;i<list.size();i++){

            ans[index][0] = list.get(i)[0];
            ans[index][1] = list.get(i)[1];
            index++;

        }

        return ans;
        
    }
    
}
