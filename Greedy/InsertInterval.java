import java.util.ArrayList;

public class InsertInterval {
    
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        
        ArrayList<int[]> ans = new ArrayList<int[]>();
        
        int i = 0;
        
        int n = intervals.length;
        
        while(i < n && intervals[i][1] < newInterval[0]){
            
            ans.add(new int[]{intervals[i][0] , intervals[i][1]});
            i++;
            
        }
        
        while(i < n && intervals[i][0] <= newInterval[1]){
            
            newInterval[0] = Math.min(newInterval[0] , intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1] , intervals[i][1]);
            i++;
            
        }
        
        ans.add(new int[]{newInterval[0] , newInterval[1]});
        
        while(i < n){
            
            ans.add(new int[]{intervals[i][0] , intervals[i][1]});
            i++;
            
        }
        
        return ans;
        
    }
    
}
