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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null|| head.next==null)return head;
        ArrayList<ListNode> arr=new ArrayList<>();
        ListNode temp=head;

        while(temp!=null){
            arr.add(temp);
            temp=temp.next;
        }
        int n=arr.size();
        k=k%n;
        if(k==0)return head;
        ListNode rotated=arr.get(n-k);
        ListNode tempnode=rotated;
        for(int i=n-k+1;i<n;i++){
            tempnode.next=arr.get(i);
            tempnode=tempnode.next;
        }
        for(int i=0;i<n-k;i++){
            tempnode.next=arr.get(i);
            tempnode=tempnode.next;
        }
        tempnode.next=null;
       return rotated;
        
    }
}