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
        if(head==null || head.next==null || k==0){
            return head;
        }

        int len=1;
        ListNode curr=head;
        while(curr.next!=null){
            len++;
            curr=curr.next;
        }

        k=k%len;
        if(k==0){
            return head;
        }
        curr.next=head;
        int nodePosition=len-k;
        ListNode newNode=head;

        for(int i=1;i<nodePosition;i++){
            newNode=newNode.next;
        }
        ListNode newHead=newNode.next;
        newNode.next=null;
        return newHead;       
        
    }
}
