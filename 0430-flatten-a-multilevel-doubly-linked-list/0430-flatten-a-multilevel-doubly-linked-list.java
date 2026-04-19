/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node node=head;
        if(node==null)return head;
        while(node!=null){
            if(node.child==null){
                node=node.next;
                continue;
            }
            Node tail=node.child;
            while(tail.next!=null){
                tail=tail.next;
            }
            tail.next=node.next;
            if(node.next!=null){
                node.next.prev=tail;
            }
            node.next=node.child;
            node.child.prev=node;
            node.child=null;
        }
        return head;
    }
}