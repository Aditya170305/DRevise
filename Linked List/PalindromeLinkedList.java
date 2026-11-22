class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

public class PalindromeLinkedList {
    
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

    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){

            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode newHead = reverse(slow.next);
        ListNode first = head;
        ListNode second = newHead;

        while(second != null){

            if(first.val != second.val) return false;

            first = first.next;
            second = second.next;

        }

        return true;

    }

}
