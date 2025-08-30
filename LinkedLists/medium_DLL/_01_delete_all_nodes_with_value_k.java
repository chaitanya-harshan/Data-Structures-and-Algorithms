/*
https://www.naukri.com/code360/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list_8160461

 * You’re given a doubly-linked list and a key 'k'.
Delete all the nodes having data equal to ‘k’.

Example:
Input: Linked List: 10 <-> 4 <-> 10 <-> 3 <-> 5 <-> 20 <-> 10 and ‘k’ = 10

Output: Modified Linked List: 4 <-> 3 <-> 5 <-> 20
 */
package medium_DLL;
import _2D.*;

public class _01_delete_all_nodes_with_value_k {
    
    public static Node deleteAllOccurrences(Node head, int k) {
        // if (head == null) return null; // not needed as a dummy (-1) is created and loop check for null

        Node dummy = new Node(-1, head, null);
        Node prev = dummy;
        Node cur = head;
        while (cur != null) {
            if (cur.data != k) {
                prev.next = cur;
                cur.prev = prev;
                prev = cur;
            }
            cur = cur.next;
        }
        prev.next = null; // IMPORTANT
        return dummy.next;
    }
}
