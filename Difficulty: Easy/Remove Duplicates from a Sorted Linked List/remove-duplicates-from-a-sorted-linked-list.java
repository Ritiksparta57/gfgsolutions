/* Structure of linked list Node
class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        // code here
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            prev=temp;
            temp=temp.next;
            if(temp!=null&&prev.data==temp.data){
                while(temp!=null&&prev.data==temp.data){
                    prev.next=temp.next;
                    temp=temp.next;
                }
            }
        }
        return head;
    }
}