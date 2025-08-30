package Hard_LL;

public class _01_reverse_LL_in_sets_of_k_length {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode nextNode = cur, prev = null;

        while (cur != null) {
            ListNode k_node = KthNode(cur, k);
            if (k_node == null) {
                if (prev != null) prev.next = cur;
                return head;
            }
            nextNode = k_node.next;
            k_node.next = null;

            ListNode newHead = reverse(cur); // new head = kth node

            if (prev == null) head = newHead;
            else prev.next = newHead;

            prev = cur;
            cur = nextNode;
        }
        return head;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }

    private static ListNode KthNode(ListNode head, int k) {
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            cnt++;
            if (cnt == k) return cur;
            cur = cur.next;
        }
        return null;
    }
}

/*
 * URL: https://leetcode.com/problems/reverse-nodes-in-k-group/description/

25. Reverse Nodes in k-Group

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.

 
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

 
Constraints:

	The number of nodes in the list is n.
	1 <= k <= n <= 5000
	0 <= Node.val <= 1000
	Follow-up: Can you solve the problem in O(1) extra memory space?
 */