import java.util.ArrayList;
import java.util.List;

public class RearrangeElementsBySignOfDifferentSize {
    
    void rearrange(ArrayList<Integer> arr) {
        
        List<Integer> pos = new ArrayList<Integer>();
        List<Integer> neg = new ArrayList<Integer>();
        
        for(int num : arr){
            
            if(num >= 0) pos.add(num);
            
            else neg.add(num);
            
        }
        
        if(pos.size() > neg.size()){
            
            for(int i=0;i<neg.size();i++){
                
                arr.set(2 * i , pos.get(i));
                arr.set(2 * i + 1 , neg.get(i));
                
            }
            
            int index = neg.size() * 2;
            
            for(int i=neg.size();i<pos.size();i++){
                
                arr.set(index , pos.get(i));
                index++;
                
            }
            
        }
        
        else{
            
            for(int i=0;i<pos.size();i++){
                
                arr.set(2 * i , pos.get(i));
                arr.set(2 * i + 1 , neg.get(i));
                
            }
            
            int index = pos.size() * 2;
            
            for(int i=pos.size();i<neg.size();i++){
                
                arr.set(index , neg.get(i));
                index++;
                
            }
            
        }
        
    }
}
