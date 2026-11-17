public class MergeTwoSortedArraysByGapMethod {
    
    public void swapIfGreater(int a [] , int b [] , int ind1 , int ind2){
        
        if(a[ind1] > b[ind2]){
            
            int temp = a[ind1];
            a[ind1] = b[ind2];
            b[ind2] = temp;
            
        }
        
    }
    
    public void mergeArrays(int a[], int b[]) {
        
        int n1 = a.length;
        int n2 = b.length;
        
        int len = n1 + n2;
        
        int gap = (len / 2) + (len % 2);
        
        while(gap > 0){
            
            int left = 0;
            int right = left + gap;
            
            while(right < len){
                
                if(left < n1 && right >= n1) swapIfGreater(a , b , left , right - n1);
                
                else if(left >= n1) swapIfGreater(b , b , left - n1 , right - n1);
                
                else swapIfGreater(a , a , left , right);
                
                left++;
                right++;
                
            }
            
            if(gap == 1) break;
            gap = (gap / 2) + (gap % 2);
            
        }
        
    }
    
}
