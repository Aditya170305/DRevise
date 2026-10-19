import java.util.Stack;

public class MinStack {
    
    Stack<Long> st;
    long mini;

    public MinStack() {
        
        st = new Stack<Long>();
        mini = 0;

    }
    
    public void push(int value) {

        long val = value;
        
        if(st.isEmpty()){
            st.add(val);
            mini = val;
        }
        else{
            if(val > mini) st.add(val);
            else{
                long nval = 2 * val - mini;
                st.push(nval);
                mini = value;
            }
        }

    }
    
    public void pop() {
        
        if(st.isEmpty()) return;

        long x = st.pop();

        if(x < mini){
            mini = 2 * mini - x;
        }

    }
    
    public int top() {
        
        if(st.isEmpty()) return -1;
        long x = st.peek();
        if(x > mini) return (int)x;
        return (int)mini;

    }
    
    public int getMin() {

        if(st.isEmpty()) return -1;
        return (int)mini;

    }
    
}
