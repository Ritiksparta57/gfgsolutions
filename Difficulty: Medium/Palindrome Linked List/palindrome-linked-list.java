/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    public boolean isPalindrome(Node head) {
        // code here
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node midnext=rev(slow);
        Node temp=head;
        Node mid=midnext;
        while(mid!=null){
            if(temp.data!=mid.data)return false;
            temp=temp.next;
            mid=mid.next;
        }
        return true;
    }
    public Node rev(Node midnext){
        Node temp=midnext;
        Node prev=null;
        while(temp!=null){
            Node next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
}