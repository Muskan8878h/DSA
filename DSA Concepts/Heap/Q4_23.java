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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap=new PriorityQueue<>((a,b)-> a.val-b.val);
        for(ListNode list: lists){
            if(list!=null){
                minHeap.offer(list);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(!minHeap.isEmpty()){
            ListNode smallestNode=minHeap.poll();
            curr.next=smallestNode;
            curr=curr.next;
            if(smallestNode.next!=null){
                minHeap.offer(smallestNode.next);
            }
        }
        return dummy.next;
    }
}