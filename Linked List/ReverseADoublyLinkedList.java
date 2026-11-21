class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class ReverseADoublyLinkedList {
    
    public Node reverse(Node head) {
        
        if(head == null || head.next == null) return head;
        
        Node prev = null;
        Node current = head;
        
        while(current != null){
            
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            
            current = current.prev;
            
        }
        
        return prev.prev;
        
    }
    
}
