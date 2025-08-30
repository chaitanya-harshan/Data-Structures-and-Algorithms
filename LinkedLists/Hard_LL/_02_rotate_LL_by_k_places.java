
package Hard_LL;

public class _02_rotate_LL_by_k_places {
    
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        
        int length = 1;
        ListNode temp = head;
        // fiding length 
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        temp.next = head; // Looping the LL so that all we need to find is the new tail <break point> based on k & length

        int n = length - (k % length); // finding the breakpoint/new_Tail index

        int cnt = 1;
        temp = head;
        while (cnt != n) {
            cnt++;
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        
        return head;
    }
}

/*
 * URL: https://leetcode.com/problems/rotate-list/description/

61. Rotate List

Given the head of a linked list, rotate the list to the right by k places.

 
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]

 
Constraints:

	The number of nodes in the list is in the range [0, 500].
	-100 <= Node.val <= 100
	0 <= k <= 2 * 109
 */