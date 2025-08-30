/*
 * Given a linked list where every node in the linked list contains two pointers:

‘next’ which points to the next node in the list.
‘random’ which points to a random node in the list or ‘null’.
Create a ‘deep copy’ of the given linked list and return it.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, 
then for the corresponding two nodes x and y in the copied list, x.random --> y.
 */
package Hard_LL;

public class _04_create_copy_LL_with_random_pointer {

    static class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public static Node copyRandomList(Node head) {
        if (head == null) return head;

        // creating new nodes and placing them in between 
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;

            temp = temp.next.next;
        }

        // attaching ranodom pointers
        temp = head;
        while (temp != null) {
            temp.next.random = (temp.random != null) ? temp.random.next : null;
            temp = temp.next.next;
        }

        // seperating the copy nodes and linking them togeher and relinking the original LL
        Node dummy = new Node(-1);
        temp = head;
        Node t2 = dummy;
        
        while (temp != null) {
            // linking the nodesw of the duplicate LL
            t2.next = temp.next;
            t2 = t2.next;

            // relinking the original LL
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}

/*

Before the loop:
[7] -> [13] -> [11] -> [1] -> null

After the loop:
The list becomes an interwoven structure of original and new nodes.
[7] -> [7'] -> [13] -> [13'] -> [11] -> [11'] -> [1] -> [1'] -> null



   +-----------------------------------------+
   |                                         |
  [7] -> [7'] -> [13] -> [13'] -> [11] -> [11'] -> [1] -> [1'] -> null
   ^      ^       |       |        |       |      ^      ^
   |      |       +-------+        |       |      |      |
   |      +------------------------)-------+      |      |
   +-------------------------------+--------------+      |
          |                        |                     |
          +------------------------)---------------------+
                                   |
                                   +---------------------+

 */



 /*
  * URL: https://leetcode.com/problems/copy-list-with-random-pointer/description/

138. Copy List with Random Pointer

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
Return the head of the copied linked list.
The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 
Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]

 
Constraints:

	0 <= n <= 1000
	-104 <= Node.val <= 104
	Node.random is null or is pointing to some node in the linked list.
  */