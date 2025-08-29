package medium_LL;

public class _02_reverse_LL {
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head, previous = null;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = previous;
            previous = cur;
            cur = nextNode;
        }
        return previous;
    }

    /**
     * _03 _reverse LL using recursion
    */

    // recursion
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList2(head.next);
        // ListNode front = head.next;
        // front.next = head;
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}

/*
 * URL: https://leetcode.com/problems/reverse-linked-list/description/

206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.

 
Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:
Input: head = [1,2]
Output: [2,1]
Example 3:
Input: head = []
Output: []

 
Constraints:

	The number of nodes in the list is the range [0, 5000].
	-5000 <= Node.val <= 5000
	Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */