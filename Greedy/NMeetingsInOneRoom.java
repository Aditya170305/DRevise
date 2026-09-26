import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Data {
    
    public int start;
    public int end;
    public int position;
    
    public Data(int start , int end , int position){
        
        this.start = start;
        this.end = end;
        this.position = position;
        
    }
    
}


public class NMeetingsInOneRoom {
    
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        
        int n = s.length;
        
        Data arr [] = new Data [n];
        
        for(int i=0;i<n;i++){
            
            arr[i] = new Data(s[i] , f[i] , i + 1);
            
        }
        
        Arrays.sort(arr , new Comparator<Data>(){
           
           @Override
           public int compare(Data a , Data b){
               return a.end - b.end;
           }
            
        });
        
        int freeTime = arr[0].end;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(arr[0].position);
        
        for(int i=1;i<n;i++){
            
            if(arr[i].start > freeTime){
                freeTime = arr[i].end;
                ans.add(arr[i].position);
            }
            
        }
        
        Collections.sort(ans);
        
        return ans;
        
    }

}
