import java.util.Stack;

public class L1190 {
    
    public void reverse(StringBuilder sb , int left , int right){

        while(left < right){

            char temp = sb.charAt(left);
            sb.setCharAt(left , sb.charAt(right));
            sb.setCharAt(right , temp);

            left++;
            right--;

        }
    }
    public String reverseParentheses(String s) {
        
        Stack<Integer> st = new Stack<Integer>();
        StringBuilder ans = new StringBuilder();

        int n = s.length();

        for(int i=0;i<n;i++){

            char ch = s.charAt(i);

            if(ch == '('){
                st.push(ans.length());
            }

            else if(ch == ')'){
                reverse(ans , st.pop() , ans.length() - 1);
            }

            else{
                ans.append(ch);
            }

        }

        return ans.toString();

    }
    
}
