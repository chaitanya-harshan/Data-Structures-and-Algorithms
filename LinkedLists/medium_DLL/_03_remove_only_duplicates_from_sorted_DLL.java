package medium_DLL;
import _2D.Node;

public class _03_remove_only_duplicates_from_sorted_DLL {
    
    public static Node uniqueSortedList(Node head) {
        if (head == null) return null;
        
        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
                if (temp.next != null) temp.next.prev = temp;
            }
            else temp = temp.next;
        }
        return head;
    }
}

/*
https://www.naukri.com/code360/problems/remove-duplicates-from-a-sorted-doubly-linked-list_2420283

 * You are given a sorted doubly linked list of size 'n'.

Remove all the duplicate nodes present in the linked list.

Example :
Input: Linked List: 1 <-> 2 <-> 2 <-> 2 <-> 3

Output: Modified Linked List: 1 <-> 2 <-> 3

 */