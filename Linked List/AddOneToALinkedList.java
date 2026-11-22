class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

public class AddOneToALinkedList {
    
    public Node reverse(Node head){
        
        Node temp = head;
        Node prev = null;
        
        while(temp != null){
            
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
            
        }
        
        return prev;
        
    }
    
    public Node addOne(Node head) {
        
        head = reverse(head);
        
        Node temp = head;
        
        int carry = 1;
        
        while(temp != null){
            
            temp.data = temp.data + carry;
            
            if(temp.data < 10){
                
                carry = 0;
                break;
                
            }
            
            else{
                
                temp.data = 0;
                carry = 1;
                
            }
            
            temp = temp.next;
            
        }
        
        if(carry == 1){
            
            Node newNode = new Node(1);
            head = reverse(head);
            newNode.next = head;
            return newNode;
            
        }
        
        head = reverse(head);
        
        return head;
        
    }
    
}
