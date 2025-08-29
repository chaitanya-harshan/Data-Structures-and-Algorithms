package medium_LL;

/*
 * time complexity:   log N (N + N/2) ≈ N Log N
 */
public class _11_sort {
    public static void main(String[] args) {
        int[] arr = {3,7,2,9,4,6,1,5,8,10};
        // ListNode head = arr_to_LL.constructLL(arr);
        // print_LL.print(head);
        // head = mergeSortList(head);
        // print_LL.print(head);
    }

    public static ListNode mergeSortList(ListNode head) {
        if (head.next == null) return head;

        // spliting in middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;

        // sorting 2 halves
        ListNode left = mergeSortList(head);
        ListNode right = mergeSortList(secondHead);
        head = mergeTwoLists(left, right);

        return head;
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1, null);
        ListNode t1 = list1, t2 = list2;
        ListNode tail = dummy;

        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                tail.next = t1;
                tail = tail.next;
                t1 = t1.next;
            }
            else {
                tail.next = t2;
                tail = tail.next;
                t2 = t2.next;
            }
        }

        if (t1 == null) tail.next = t2;
        else if (t2 == null) tail.next = t1;

        return dummy.next;
    }
}

/*
 * URL: https://leetcode.com/problems/sort-list/description/

148. Sort List

Given the head of a linked list, return the list after sorting it in ascending order.

 
Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:
Input: head = []
Output: []

 
Constraints:

	The number of nodes in the list is in the range [0, 5 * 104].
	-105 <= Node.val <= 105
	Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */