import java.util.Stack;

public class L1614 {
    
    public int maxDepth(String s) {
        
        int max_count = 0;

        Stack<Character> st = new Stack<Character>();

        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }

            else if(s.charAt(i) == ')'){
                st.pop();
            }

            max_count = Math.max(max_count , st.size());

        }

        return max_count;
        
    }
    
}
