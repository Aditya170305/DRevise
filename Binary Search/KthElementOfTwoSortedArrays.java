public class KthElementOfTwoSortedArrays {
    
    public int kthElement(int a[], int b[], int k) {
        
        int n1 = a.length;
        int n2 = b.length;
        
        int count = 0;
        
        int i = 0;
        int j = 0;
        
        while(i < n1 && j < n2){
            
            if(a[i] < b[j]){
                
                if(count == k - 1){
                    
                    return a[i];
                    
                }
                
                i++;
                count++;
                
            }
            
            else{
                
                if(count == k - 1){
                    
                    return b[j];
                    
                }
                
                j++;
                count++;
                
            }
            
        }
        
        while(i < n1){
            
            if(count == k - 1){
                
                return a[i];
                
            }
            
            i++;
            count++;
            
        }
        
        while(j < n2){
            
            if(count == k - 1){
                
                return b[j];
                
            }
            
            j++;
            count++;
            
        }
        
        return -1;
        
    }
    
}
