import java.util.ArrayList;

public class KMPAlgorithms {
    
     void computeLPS(String pat , int [] LPS){
        
        int len = 0;
        
        LPS[0] = 0;
        
        int i = 1;
        
        while(i < pat.length()){
            
            if(pat.charAt(i) == pat.charAt(len)){
                
                len++;
                LPS[i] = len;
                i++;
                
            }
            
            else{
                
                if(len != 0){
                    len = LPS[len - 1];
                }
                
                else{
                    LPS[i] = 0;
                    i++;
                }
                
            }
        }
        
    }
    ArrayList<Integer> search(String pat, String txt) {
        
        int n = txt.length();
        int m = pat.length();
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int LPS [] = new int [m];
        
        computeLPS(pat , LPS);
        
        int i = 0;
        int j = 0;
        
        while(i < n){
            
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            
            if(j == m){
                ans.add(i - m);
                j = LPS[j - 1];
            }
            
            else if(i < n && txt.charAt(i) != pat.charAt(j)){
                if(j != 0){
                    j = LPS[j - 1];
                }
                else{
                    i++;
                }
            }
            
        }
        
        return ans;
        
    }
}
