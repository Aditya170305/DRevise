import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class JobScheduling {
    
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        
        int n = deadline.length;
        
        int arr [][] = new int [n][3];
        
        for(int i=0;i<n;i++){
            
            arr[i][0] = i;
            arr[i][1] = deadline[i];
            arr[i][2] = profit[i];
            
        }
        
        int count = 0;
        int total_profit = 0;
        
        Arrays.sort(arr , new Comparator<int[]>(){
           
           @Override
           public int compare(int [] a , int [] b){
               
               return b[2] - a[2];
               
           }
           
        });
        
        int maxDeadline = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            maxDeadline = Math.max(maxDeadline , deadline[i]);
        }
        
        int hashArray [] = new int [maxDeadline + 1];
        
        Arrays.fill(hashArray , -1);
        
        for(int i=0;i<n;i++){
            
            for(int j=arr[i][1];j>=1;j--){
                
                if(hashArray[j] == -1){
                    
                    count++;
                    hashArray[j] = arr[i][0];
                    total_profit = total_profit + arr[i][2];
                    break;
                    
                }
                
            }
            
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        ans.add(count);
        ans.add(total_profit);
        
        return ans;

    }
        
}

