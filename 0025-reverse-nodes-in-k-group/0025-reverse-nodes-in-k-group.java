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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prevGroupEnd=dummy;
        while(true){
            ListNode kth=getkthNode(prevGroupEnd,k);
            if(kth==null)break;
            ListNode groupstart=prevGroupEnd.next;
            ListNode nextGroupstart=kth.next;
            ListNode prev=kth.next;
            ListNode curr=groupstart;
            while(curr!=nextGroupstart){
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            prevGroupEnd.next=kth;
            prevGroupEnd=groupstart;
        }        
        return dummy.next;
    }
    private ListNode getkthNode(ListNode start,int k){
        while(start!=null&&k>0){
            start=start.next;
            k--;

        }
        return start;
    }
}
