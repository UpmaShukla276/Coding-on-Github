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
    public ListNode reverseList(ListNode head) {
        ListNode builtSoFar = null; 
        ListNode current = head;   

        while (current != null) {
            ListNode remaining = current.next; 

            current.next = builtSoFar;  
            builtSoFar = current;        
            current = remaining;         
        }

        return builtSoFar; // once current runs out, builtSoFar IS the fully reversed list
    }
}
