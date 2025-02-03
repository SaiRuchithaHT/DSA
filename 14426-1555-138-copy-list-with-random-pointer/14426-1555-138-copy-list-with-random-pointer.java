/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node itr = head, newHead = head, newHeadItr = head;
        while(itr!=null){
            Node newNode = new Node(itr.val);
            newNode.next = itr.next;
            newNode.random = itr.random;
            itr.next = newNode;
            itr = itr.next.next;
        }
        itr = head;
        while(itr!=null){
            if(itr.random!=null){
                itr.next.random = itr.random.next;
            } else {
                itr.next.random = null;
            }
            itr = itr.next.next;
        }
        itr = head;
        newHead = itr.next;
        newHeadItr = itr.next;
        Node dummy = new Node(-1);
        dummy.next = head.next;
        Node res = dummy;
        while(itr!=null && itr.next!=null && newHeadItr!=null && newHeadItr.next!=null){
            itr.next = itr.next.next;
            itr = itr.next;
            newHeadItr.next = newHeadItr.next.next;
            newHeadItr = newHeadItr.next;
        } 
        itr.next = itr.next.next;
        return newHead;
    }
}