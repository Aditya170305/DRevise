public class ImplementStackUsingArrays {
    
    int stack [];
    int top;

    public ImplementStackUsingArrays(int n) {
        
        stack = new int [n];
        top = -1;
        
    }

    public boolean isEmpty() {
        
        return (top == -1);
        
    }

    public boolean isFull() {
        
        return (top == stack.length - 1);
        
    }

    public void push(int x) {
        
        if(!isFull()){
            top = top + 1;
            stack[top] = x;
        }
        
    }

    public void pop() {
        
        if(top != -1) top = top - 1;
        
    }

    public int peek() {
        
        return (top != -1) ? stack[top] : -1;
        
    }

}
