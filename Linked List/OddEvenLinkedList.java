class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while(even != null && even.next != null){

            odd = odd.next.next;
            even = even.next.next;

            even = even.next;
            odd = odd.next;

        }

        odd.next = evenHead;
        return head;

    }
    
}
