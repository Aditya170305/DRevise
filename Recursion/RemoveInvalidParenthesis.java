import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParenthesis {
    
    public int max_len;

    public RemoveInvalidParenthesis(){
        max_len = 0;
    }

    public void solve(int index , Set<String> st , StringBuilder curr , int count , String s){

        if(count < 0) return;

        if(index == s.length()){
            if(count == 0){
                if(curr.length() > max_len){
                    max_len = curr.length();
                    st.clear();
                }

                if(curr.length() == max_len){
                    st.add(curr.toString());
                }
            }
            return;
        }

        if(s.charAt(index) != '(' && s.charAt(index) != ')'){
            curr.append(s.charAt(index));
            solve(index + 1 , st , curr , count , s);
            curr.deleteCharAt(curr.length() - 1);
            return;
        }

        curr.append(s.charAt(index));
        solve(index + 1 , st , curr , count + (s.charAt(index) == '(' ? 1 : -1) , s);
        curr.deleteCharAt(curr.length() - 1);
        solve(index + 1 , st , curr , count , s);

    }

    public List<String> removeInvalidParentheses(String s) {
        
        Set<String> st = new HashSet<String>();
        solve(0 , st , new StringBuilder() , 0 , s);

        // int max_len = Integer.MIN_VALUE;
        // for(String str : st){
        //     max_len = Math.max(max_len , str.length());
        // }

        List<String> ans = new ArrayList<String>();

        // for(String str : st){
        //     if(str.length() == max_len){
        //         ans.add(str);
        //     }
        // }

        for(String str : st){
            ans.add(str);
        }

        return ans;

    }

}
