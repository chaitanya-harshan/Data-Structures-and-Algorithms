package medium_LL;
import _1D.*;

public class _12_sort_0s_1s_2s {
    
    public static Node sortList(Node head) {
        if (head == null || head.next == null) return head;
        
        Node h0 = new Node(-1), h1 = new Node(-1), h2 = new Node(-1);
        Node t0 = h0, t1 = h1, t2 = h2;
        Node temp = head;
        
        while (temp != null) {
            if (temp.data == 0) {
                t0.next = temp;
                t0 = t0.next;
                temp = temp.next;
            }
            else if (temp.data == 1) {
                t1.next = temp;
                t1 = t1.next;
                temp = temp.next;
            }
            else {
                t2.next = temp;
                t2 = t2.next;
                temp = temp.next;
            }
        }
        h0 = h0.next;
        h1 = h1.next;
        h2 = h2.next;
        // if (h2 != null) t2.next = null; 
        t2.next = null;

        if (h1 == null) h1 = h2;
        else t1.next = h2;

        if (h0 == null) h0 = h1;
        else t0.next = h1;
        
        return h0;
    }
}

/*
 * https://www.naukri.com/code360/problems/sort-linked-list-of-0s-1s-2s_1071937
 * 
Given a linked list of 'N' nodes, where each node has an integer value that can be 0, 1, or 2. You need to sort the linked list in non-decreasing order and the return the head of the sorted list.



Example:
Given linked list is 1 -> 0 -> 2 -> 1 -> 2. 
The sorted list for the given linked list will be 0 -> 1 -> 1 -> 2 -> 2.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
7
1 0 2 1 0 2 1


Sample Output 1:
0 0 1 1 1 2 2


Explanation Of Sample Input 1:
Input: 1 -> 0 -> 2 -> 1 -> 0 -> 2 -> 1

Output: 0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2

Explanation: 
In this example, the original linked list contains two 0s, three 1s, and two 2s. The sorted linked list has all the 0s at the beginning, followed by all the 1s, and finally, all the 2s at the end.


Sample Input 2:
8
2 1 0 2 1 0 0 2


Sample Output 2:
0 0 0 1 1 2 2 2


Follow Up:
Can you solve this without updating the Nodes of the given linked list?


Constraints :
1 <= N <= 10^3
0 <= data <= 2 

Where 'N' is the length of the linked list.

Time Limit: 1 sec
 */