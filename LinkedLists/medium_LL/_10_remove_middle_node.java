// Here we shift the 'fast' pointer by 1 position ahead of 'slow' pointer
// This way when 'fast' reaches the end, 'slow' will be just before the middle node
// and we can easily remove the middle node by adjusting the pointers
// Just a clever Trick. Nothing much.
package medium_LL;

public class _10_remove_middle_node {
    
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}


// when we increase the starting point of 'fast' then effectively the lenght of the LL reduced by 1
/*
 * this way odd length which used to have a perfect fit for 'fast' before - 12 34 5
 * now have one less element so therfore the count of jumps to comepletely traverse the list reduces by 1
 *  so this makes the 'slow' index one less.
 * 
 * IN the even length LL since it's alraedy not using 1 element (the last element) - 12 34 5(6)
 * now since one elment (last) is useless regardless, eventhough it is reduced it doesn't matter 
 * and it still gives the same index for slow.
 */

/*
 * URL: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

2095. Delete the Middle Node of a Linked List

You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.

 
Example 1:
Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Explanation:
The above figure represents the given linked list. The indices of the nodes are written below.
Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
We return the new list after removing this node.
Example 2:
Input: head = [1,2,3,4]
Output: [1,2,4]
Explanation:
The above figure represents the given linked list.
For n = 4, node 2 with value 3 is the middle node, which is marked in red.
Example 3:
Input: head = [2,1]
Output: [2]
Explanation:
The above figure represents the given linked list.
For n = 2, node 1 with value 1 is the middle node, which is marked in red.
Node 0 with value 2 is the only node remaining after removing node 1.

 
Constraints:

	The number of nodes in the list is in the range [1, 105].
	1 <= Node.val <= 105
 */