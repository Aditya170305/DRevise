import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSubsequencesOfAString {
    
    public void find(int index , String s , StringBuilder str , List<String> ans){
        
        if(index == s.length()){
            
            if(str == null) ans.add("");
            else ans.add(str.toString());
            return;
            
        }
        
        str.append(s.charAt(index));
        
        find(index + 1 , s , str , ans);
        
        str.deleteCharAt(str.length() - 1);
        
        find(index + 1 , s , str , ans);
        
    }
    
    public List<String> powerSet(String s) {
        
        List<String> ans = new ArrayList<String>();
        
        find(0 , s , new StringBuilder() , ans);
        
        Collections.sort(ans);
        
        return ans;
        
    }
    
}
