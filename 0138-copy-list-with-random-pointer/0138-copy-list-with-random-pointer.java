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
        if (head == null){
            return null;
        }
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node naklihead = new Node(0);
        Node copyCurr = naklihead;

        while(curr!=null){
            Node front = curr.next.next;
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;

            curr.next = front;
            curr = front;
        }

        return naklihead.next;        
    }
}