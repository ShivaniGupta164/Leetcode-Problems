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
        ListNode head = null;
        ListNode curr = null;
        boolean carry = false;
        while(l1!=null || l2!=null){
            int add = 0;
            if(l1 == null)
                add = l2.val;
            else if(l2 == null)
                add = l1.val;
            else
                add = l1.val + l2.val;
            if(carry){
                add +=1;
                carry = false;
            }if(add>9){
                add %=10;
                carry = true;
            }
            if(head == null){
                head = new ListNode(add);
                curr = head;
            }else{
                curr.next = new ListNode(add);
                curr = curr.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry)
            curr.next = new ListNode(1);
        return head;
    }
}