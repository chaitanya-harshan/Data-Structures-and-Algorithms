/*
https://takeuforward.org/plus/dsa/problems/find-pairs-with-given-sum-in-doubly-linked-list

https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1

 * Given the head of a sorted doubly linked list of positive distinct integers, and a target integer, 
 * return a 2D array containing all unique pairs of nodes (a, b) such that a + b == target.
Each pair should be returned as a 2-element array [a, b] with a < b. The list is sorted in 
ascending order. If there are no such pairs, return an empty list.

Example :
Input: Linked List: 1 <-> 2 <-> 3 <-> 4 <-> 9 and 'k' = 5
Output: (1, 4) and (2, 3)
Explanation: There are 2 pairs in the linked list having sum 'k' = 5.

Input: head = [1, 2, 4, 5, 6, 8, 9], target = 7
Output: [[1, 6], [2, 5]]
Explanation: 1 + 6 = 7 and 2 + 5 = 7 are the valid pairs.

Input: head = [1, 5, 6], target = 6
Output: [[1, 5]]
Explanation: 1 + 5 = 6 is the only valid pair.
 */
package medium_DLL;
import _2D.*;
import java.util.ArrayList;
import java.util.Arrays;

public class _02_pairs_with_sum_k_in_DLL {
    public static void main(String[] args) {
        int[] arr = {1,4,5,6,10,11,12,13,14,15,19,20,21,22,25,26,27,31};
        Node head = arr_to_DLL.constructDLL(arr);
        System.out.println(findPairsWithGivenSum(31, head));
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> table = new ArrayList<>();
        if (head == null) return table;

        Node left = head, right = findTail(head);

        // while (left != right && left.prev != right) { // without using the sorted nature

        while (left.data < right.data ) { // using the sorted nature
            int sum = left.data + right.data;
            
            if (target == sum) {
                ArrayList<Integer> pair = new ArrayList<>(Arrays.asList(left.data, right.data));
                table.add(pair);
                left = left.next;
                right = right.prev;
            }
            else if (sum > target) {
                right = right.prev;
            }
            else left = left.next;
        }
        return table;
    }
    
    private static Node findTail(Node head) {
        if (head == null) return null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
}
