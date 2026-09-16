import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    
    public boolean wordPattern(String pattern, String s) {
        
        String str [] = s.split(" ");

        if(pattern.length() != str.length) return false;

        Map<Character , String> mpp = new HashMap<Character , String>();
        Map<String , Character> rev = new HashMap<String , Character>();

        int i = 0;

        while(i < str.length){

            char ch = pattern.charAt(i);

            if(mpp.containsKey(ch)){
                if(!mpp.get(ch).equals(str[i])) return false;
            }

            if(rev.containsKey(str[i])){
                if(rev.get(str[i]) != ch) return false;
            }

            mpp.put(ch , str[i]);
            rev.put(str[i] , ch);

            i++;

        }

        return true;

    }
}
