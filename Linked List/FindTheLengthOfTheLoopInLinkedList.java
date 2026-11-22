class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
    
}

public class FindTheLengthOfTheLoopInLinkedList {
    
    public int lengthOfLoop(Node head) {
        
        Node slow = head , fast = head;
        
        while(fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                
                int ans = 1;
                
                fast = fast.next;
                
                while(slow != fast){
                    
                    ans++;
                    fast = fast.next;
                    
                }
                
                return ans;
                
            }
            
        }
        
        return 0;
        
    }

}
