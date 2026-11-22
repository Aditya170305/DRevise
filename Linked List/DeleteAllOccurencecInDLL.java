class Node {
  public int data;
  public Node next;
  public Node prev;

  public Node(int x) {
      data = x;
      next = null;
      prev = null;
  }

}

public class DeleteAllOccurencecInDLL {

    public Node deleteAllOccurOfX(Node head, int x) {
        
        Node temp = head;
        
        while(temp != null){
            
            if(temp.data == x){
                
                if(temp == head){
                    
                    head = head.next;
                    head.prev = null;
                    
                }
                
                else if(temp.next == null){
                    
                    temp.prev.next = null;
                    break;
                    
                }
                
                else{
                    
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    
                }
                
            }
            
            temp = temp.next;
            
        }
        
        return head;
        
    }

}
