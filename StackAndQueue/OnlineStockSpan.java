import java.util.Stack;

class Pair {

    int val;
    int index;

    public Pair(int val , int index){

        this.val = val;
        this.index = index;

    }

}

public class OnlineStockSpan {
    
    Stack<Pair> st;
    int index;

    public OnlineStockSpan() {
        
        st = new Stack<Pair>();
        index = -1;

    }
    
    public int next(int price) {
        
        index = index + 1;

        while(!st.isEmpty() && st.peek().val <= price){
            st.pop();
        }

        int ans = index - (st.isEmpty() ? -1 : st.peek().index);

        st.add(new Pair(price , index));

        return ans;

    }

}
