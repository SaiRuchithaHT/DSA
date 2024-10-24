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
    public ListNode reorderListImpl(ListNode head, ListNode nextNode) {
        if(head!=null && nextNode!=null && nextNode.next!=null)
            head = reorderListImpl(head, nextNode.next);
        
        if(head==null)
            return null;
        
        nextNode.next = null;
        if(head==nextNode)
            return null;
        if(head!=null && nextNode != head.next){
            nextNode.next = head.next;
            head.next = nextNode;
            head = nextNode.next;
        }else{
            nextNode.next = null;
            head = null;
        }
        return head;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        ListNode realHead = head;
        reorderListImpl(head, head.next);
    }
}