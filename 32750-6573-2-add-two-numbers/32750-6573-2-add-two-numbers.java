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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode result = l1;
        ListNode finalRes = l1;
        int carry = 0, sum = 0;
        while(l1!=null && l2!=null){
            sum = l1.val + l2.val + carry;
            if(sum>9){
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            result = l1;
            result.val = sum;
            sum = 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1==null && l2==null){
            if(carry>0){
                ListNode node = new ListNode(carry);
                node.next = null;
                result.next = node;
            }
        }else if(l1==null){
            result.next = l2;
            while(l2!=null){
                sum = l2.val + carry;
                if(sum>9){
                    carry = 1;
                    sum -= 10;
                } else {
                    carry = 0;
                }
                result = l2;
                result.val = sum;
                sum = 0;
                l2 = l2.next;
            }
            if(carry>0){
                ListNode node = new ListNode(carry);
                node.next = null;
                result.next = node;
            }
        } else {
            while(l1!=null){
                sum = l1.val + carry;
                if(sum>9){
                    carry = 1;
                    sum -= 10;
                } else {
                    carry = 0;
                }
                result = l1;
                result.val = sum;
                sum = 0;
                l1 = l1.next;
            }
            if(carry>0){
                ListNode node = new ListNode(carry);
                node.next = null;
                result.next = node;
            }
        }
        return finalRes;   
    }
}