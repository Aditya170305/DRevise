import java.util.ArrayList;

public class MaxEqualSumIn3Stacks {
    
    public int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2,
                           ArrayList<Integer> s3) {
        
        int sum1 = 0 , sum2 = 0 , sum3 = 0;
        
        for(int ele : s1){
            
            sum1 = sum1 + ele;
            
        }
        
        for(int ele : s2){
            
            sum2 = sum2 + ele;
            
        }
        
        for(int ele : s3){
            
            sum3 = sum3 + ele;
            
        }
        
        int n1 = s1.size();
        int n2 = s2.size();
        int n3 = s3.size();
        
        int top1 = 0 , top2 = 0 , top3 = 0;
        
        while(top1 < n1 && top2 < n2 && top3 < n3){
            
            if(sum1 == sum2 && sum2 == sum3) return sum1;
            
            if(sum1 >= sum2 && sum1 >= sum3) sum1 = sum1 - s1.get(top1++);
            
            else if(sum2 >= sum1 && sum2 >= sum3) sum2 = sum2 - s2.get(top2++);
            
            else sum3 = sum3 - s3.get(top3++);
            
        }
        
        return 0;
        
    }
    
}
