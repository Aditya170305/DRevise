import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L1807 {
    
    public String evaluate(String s, List<List<String>> knowledge) {
        
        Map<String ,String> mpp = new HashMap<String , String>();

        int n = knowledge.size();
        
        for(int i=0;i<n;i++){
            
            String key = knowledge.get(i).get(0);
            String val = knowledge.get(i).get(1);

            mpp.put(key , val);

        }

        StringBuilder ans = new StringBuilder();

        n = s.length();
        int br_index = -1;

        for(int i=0;i<n;i++){
            
            if(s.charAt(i) == '('){
                br_index = i;
                continue;
            }

            if(br_index != -1){
                if(s.charAt(i) == ')'){
                    if(mpp.containsKey(s.substring(br_index + 1 , i))){
                        ans.append(mpp.get(s.substring(br_index + 1 , i)));
                    }

                    else{
                        ans.append("?");
                    }

                    br_index = -1;
                }
            }

            else{
                ans.append(s.charAt(i));
            }

        }

        return ans.toString();

    }
    
}
