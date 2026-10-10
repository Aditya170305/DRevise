class Node {

    int val;
    Node next;

    public Node(int val){
        this.val = val;
    }

    public Node(int val , Node next){
        this.val = val;
        this.next = next;
    }

}

public class DesignLinkedList {
    
    int size;
    Node head;

    public DesignLinkedList() {
        
        size = 0;
        head = null;

    }
    
    public int get(int index) {
        
        if(index >= size) return -1;

        Node temp = head;

        while(temp != null){
            if(index == 0) break;
            index--;
            temp = temp.next;
        }

        return temp.val;

    }
    
    public void addAtHead(int val) {

        size++;
        
        if(head == null){
            head = new Node(val , null);
            return;
        }

        Node node = new Node(val);
        node.next = head;
        head = node;

    }
    
    public void addAtTail(int val) {

        size++;

        if(head == null){
            head = new Node(val , null);
            return;
        }
        
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node node = new Node(val);
        temp.next = node;

    }
    
    public void addAtIndex(int index, int val) {
        
        if(index == 0){
            addAtHead(val);
            return;
        }

        if(index == size){
            addAtTail(val);
            return;
        }

        if(index > size) return;

        Node t1 = null;
        Node t2 = head;

        while(t2 != null){
            if(index == 0) break;
            t1 = t2;
            t2 = t2.next;
            index--;
        }

        Node node = new Node(val);
        t1.next = node;
        node.next = t2;
        size++;

    }
    
    public void deleteAtIndex(int index) {
        
        if(head == null) return;
        if(index >= size) return;

        if(index == 0){
            head = head.next;
            size--;
            return;
        }

        if(index == size - 1){
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            size--;
            return;
        }

        Node t1 = null;
        Node t2 = head;

        while(t2 != null){
            if(index == 0) break;
            t1 = t2;
            t2 = t2.next;
            index--;
        }

        t1.next = t2.next;
        size--;
        
    }

}
