import java.util.Stack;

public class RemoveKDigits {
    
    public String removeKdigits(String num, int k) {
        
        Stack<Character> st = new Stack<Character>();

        for(int i=0;i<num.length();i++){

            while(!st.isEmpty() && k > 0 && (st.peek() - '0') > (num.charAt(i) - '0')){
                st.pop();
                k--;
            }

            st.add(num.charAt(i));

        }

        while(k > 0){
            st.pop();
            k--;
        }

        if(st.isEmpty()) return "0";

        StringBuilder ans = new StringBuilder();

        while(!st.isEmpty()){

            ans.append(st.pop());

        }

        while(ans.length() != 0 && ans.charAt(ans.length() - 1) == '0'){
            ans.deleteCharAt(ans.length() - 1);
        }

        if(ans.length() == 0) return  "0";

        return ans.reverse().toString();

    }
    
}
