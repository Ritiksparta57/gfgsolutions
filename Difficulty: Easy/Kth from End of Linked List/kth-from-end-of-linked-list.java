/* Node Structure
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public int getKthFromLast(Node head, int k) {
        Node temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        temp=head;
        if(len<k)return -1;
        while(len>k){
            temp=temp.next;
            len--;
        }
        int val=temp.data;
        return val;
    }
}