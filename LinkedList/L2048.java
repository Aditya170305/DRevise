package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class L2048 {
    
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        int min = -1;
        int max = -1;

        if(head.next.next == null) return new int [] {-1 , -1};

        ListNode prev = head;
        ListNode temp = head.next;
        int index = 1;
        int last = 0;

        while(temp.next != null){

            index++;

            if(prev.val > temp.val && temp.val < temp.next.val){

                if(min == -1 && max == -1){
                    min = index;
                    max = index;
                }

                else{
                    if(last == min) min = index - last;
                    else min = Math.min(min , index - last);
                }

                last = index;

            }

            else if(prev.val < temp.val && temp.val > temp.next.val){

                if(min == -1 && max == -1){
                    min = index;
                    max = index;
                }

                else{
                    if(last == min) min = index - last;
                    else min = Math.min(min , index - last);
                }

                last = index;

            }

            prev = temp;

            temp = temp.next;

        }

        if(last == min) return new int [] {-1 , -1};

        if(last != 0){
            max = last - max;
        }

        return new int [] {min , max};

    }

}
