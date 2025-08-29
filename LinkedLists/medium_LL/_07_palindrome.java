/*
 * Given the head of a singly linked list, return true if it is a 
palindrome
 or false otherwise.

    O(n) = 2N (n/2 + n/2 +n/2 + n/2)
    & O(s) = 1;
 */

package medium_LL;

public class _07_palindrome {
    // You can't do -> find the middle & then check from middle & start at the same time cause
    // how will u check from middle backward for the left half?? you can't
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;

        ListNode newNode = reverse(middle.next);

        ListNode first = head;
        ListNode second = newNode;
        while (second != null) {
            if (first.val != second.val) {
                reverse(newNode); // reversing to revert the LL to originaal format
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newNode);
        return true;
    }

    // to reverse the second half of the LL
    public static ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode temp = head, previous = null;
        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = previous;
            previous = temp;
            temp = nextNode;
        }
        return previous;
    }
}

/*
 * URL: https://leetcode.com/problems/palindrome-linked-list/description/

234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a  or false otherwise.

 
Example 1:
Input: head = [1,2,2,1]
Output: true
Example 2:
Input: head = [1,2]
Output: false

 
Constraints:

	The number of nodes in the list is in the range [1, 105].
	0 <= Node.val <= 9
	Follow up: Could you do it in O(n) time and O(1) space?
 */