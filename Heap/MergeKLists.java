import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; 
    }

}

public class MergeKLists {
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        int n = lists.length;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(( a , b ) -> Integer.compare(a.val , b.val));

        if(n == 0) return null;

        for(int i=0;i<n;i++){

            if(lists[i] != null){
                pq.add(lists[i]);
            }

        }

        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        while(!pq.isEmpty()){

            ListNode node = pq.poll();

            curr.next = node;
            curr = node;

            if(node.next != null){
                pq.add(node.next);
            }

        }

        curr.next = null;
        return dummyNode.next;

    }

}
