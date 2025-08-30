/*
https://www.naukri.com/code360/problems/flatten-a-linked-list_1112655

 * You are given a linked list containing 'n' 'head' nodes, where every node in the linked list contains two pointers:

(1) ‘next’ which points to the next node in the list
(2) ‘child’ pointer to a linked list where the current node is the head.

Each of these child linked lists is in sorted order and connected by 'child' pointer.

Your task is to flatten this linked such that all nodes appear in a single layer or level in a 'sorted order'.
Constraints:
1 <= n <= 100
1 <= k <= 20
1 <= Node.data <= 10^9

Time Limit: 1 sec
*/

 
//    head -> [3] -> [2] -> [1] -> [4] -> [5] -> NULL
//             |      |      |      |      | 
//             v      v      v      v      v 
//            NULL   [10]   [7]    [9]    [6]
//                     |     |      |      |
//                     v     v      v      v
//                    NULL  [11]   NULL   [8]
//                           |             |
//                           v             v
//                          [12]          NULL
//                           |
//                           v
//                          NULL


package Hard_LL;

class Node {

     int data;
     Node next;
     Node child;

    Node() {
        this.data = 0;
        this.next = null;
        this.child = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }

    Node(int data, Node next, Node child) {
        this.data = data;
        this.next = next;
        this.child = child;
    }
}

public class _03_flatten_LL {

        public static Node flattenLinkedList(Node head) {
        //Write your code here
        if (head == null || head.next == null) {
            return head;
        }

        Node merged = flattenLinkedList(head.next);
        return mergeLL(head, merged);
    }

    // similar to merging from merge sort
    static Node mergeLL(Node t1, Node t2) {
        Node dummy = new Node(-1);
        Node tail = dummy;

        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
                tail.child = t1;
                tail = tail.child;
                t1 = t1.child;
            } else {
                tail.child = t2;
                tail = tail.child;
                t2 = t2.child;
            }
        }
        if (t1 == null) {
            tail.child = t2; 
        }else if (t2 == null) {
            tail.child = t1;
        }
        return dummy.child;
    }
}
