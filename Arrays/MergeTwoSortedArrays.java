import java.util.Arrays;

public class MergeTwoSortedArrays {
    
    public void mergeArrays(int a[], int b[]) {
        
        int n1 = a.length;
        int n2 = b.length;
        
        int left = n1 - 1;
        int right = 0;
        
        while(left >= 0 && right < n2){
            
            if(a[left] > b[right]){
                
                int temp = a[left];
                a[left] = b[right];
                b[right] = temp;
                
                left--;
                right++;
                
            }
            
            else{
                
                break;
                
            }
            
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
        
    }
    
}
