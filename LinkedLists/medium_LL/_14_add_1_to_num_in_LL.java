
package medium_LL;
import _1D.*;

public class _14_add_1_to_num_in_LL {
    
    public static Node addOne(Node head) {
		if (head == null) return null;
		
        // Recursion function
		int carry = addWithCarryToNextNode(head);
		if (carry == 1) {
			Node newHead = new Node(1);
			newHead.next = head;
			return newHead;
		}
		else return head;
	}

	private static int addWithCarryToNextNode(Node head) {
		if (head == null) return 1;

		int carry = addWithCarryToNextNode(head.next);

		int value = head.data + carry;
		if (value < 10) {
			head.data = value;
			return 0;
		}
		else {
			head.data = 0;
			return 1;
		}
	}
}

/*
https://www.naukri.com/code360/problems/add-one-to-a-number-represented-as-linked-list_920557

 * Add one to a number represented as Linked List

You're given a positive integer represented in the form of a singly linked-list of digits. The length of the number is 'n'.



Add 1 to the number, i.e., increment the given number by one.



The digits are stored such that the most significant digit is at the head of the linked list and the least significant digit is at the tail of the linked list.



Example:
Input: Initial Linked List: 1 -> 5 -> 2

Output: Modified Linked List: 1 -> 5 -> 3

Explanation: Initially the number is 152. After incrementing it by 1, the number becomes 153.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3
1 5 2


Sample Output 1:
1 5 3


Explanation For Sample Input 1:
Initially the number is 152. After incrementing it by 1, the number becomes 153.


Sample Input 2:
2
9 9


Sample Output 2:
1 0 0


Explanation For Sample Input 2:
Initially the number is 9. After incrementing it by 1, the number becomes 100. Please note that there were 2 nodes in the initial linked list, but there are three nodes in the sum linked list.


Expected time complexity :
The expected time complexity is O('n').


Constraints:
1 <= 'n' <=  10^5
0 <= Node in linked list <= 9

There are no leading zeroes in the number.

Time Limit: 1 sec
 */