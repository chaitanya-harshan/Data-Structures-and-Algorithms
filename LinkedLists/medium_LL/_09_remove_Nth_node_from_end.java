
package medium_LL;

public class _09_remove_Nth_node_from_end {
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        for (int i=1; i<n; i++) {
            fast = fast.next;
        }
        if (fast.next == null) return head.next;
        
        ListNode previous = null;
        while (fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next;
        }
        previous.next = slow.next;
        slow.next = null;
        return head;
    }
}

/*
 * URL: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

 
Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:
Input: head = [1], n = 1
Output: []
Example 3:
Input: head = [1,2], n = 1
Output: [1]

 
Constraints:

	The number of nodes in the list is sz.
	1 <= sz <= 30
	0 <= Node.val <= 100
	1 <= n <= sz
	Follow up: Could you do this in one pass?
 */