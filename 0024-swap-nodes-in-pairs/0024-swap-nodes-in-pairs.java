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
    public ListNode swapPairs(ListNode head) {
        if(head==null ||head.next==null){
            return head;
        }
        ListNode firstnode=head;
        ListNode secondnode=head.next;
        ListNode rev=swapPairs(secondnode.next);
        secondnode.next=firstnode;
        firstnode.next=rev;
        return secondnode;
    }
}