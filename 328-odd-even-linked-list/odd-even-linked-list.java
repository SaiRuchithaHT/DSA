/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        // 1 2 3 4 5 6
        // 1 3 5
        // 2 4 6

        if(head==null || head.next==null || head.next.next==null)
            return head;
        
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode evenHeadItr = head.next;
        while(evenHeadItr!=null && evenHeadItr.next!=null){
            oddHead.next = evenHeadItr.next;
            oddHead = oddHead.next;
            evenHeadItr.next = oddHead.next;
            evenHeadItr = evenHeadItr.next;
        }
        oddHead.next = evenHead;
        return head;
    }
}