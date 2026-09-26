import java.util.Arrays;

public class ShortestJobFirst {

    static int solve(int bt[]) {
        
        Arrays.sort(bt);
        
        int t = 0;
        int wt = 0;
        
        for(int i=0;i<bt.length;i++){
            
            wt = wt + t;
            t = t + bt[i];
            
        }
        
        return wt / bt.length;
        
    }

}
