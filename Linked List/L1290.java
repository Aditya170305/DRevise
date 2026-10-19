class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; 
    }

}

public class L1290 {
    
    public ListNode reverse(ListNode head){

        ListNode temp = head;
        ListNode prev = null;

        while(temp != null){

            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;

        }

        return prev;

    }
    public int getDecimalValue(ListNode head) {
        
        int pow = 1;
        int num = 0;

        ListNode temp = reverse(head);

        while(temp != null){

            if(temp.val == 1) num = num + pow;
            pow = pow * 2;
            temp = temp.next;

        }

        return num;

    }

}
