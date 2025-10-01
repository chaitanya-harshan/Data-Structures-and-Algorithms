package binary_search_trees;

import java.util.Stack;

public class _10_BST_Iterator {
    class BSTIterator{
        Stack<TreeNode> st = new Stack<>();
        
        public BSTIterator(TreeNode root) {
            pushAll(root);
        }
        
        public int next() {
            TreeNode node = st.pop();
            if (node.right == null) return node.val;
            pushAll(node.right);
            return node.val;
        }
        
        public boolean hasNext() {
            return !st.isEmpty();
        }
        
        void pushAll(TreeNode node) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
        }
    }
}

/*
 * URL: https://leetcode.com/problems/binary-search-tree-iterator/description/

173. Binary Search Tree Iterator

Amine FouratiSep 19, 2023bro who writes these Read more284Show 4 RepliesReplyRaviNov 24, 2017Why not simply traverse the bst in-order and add everything to a list?
Then for hasNext you get length of list(or keep length counter which is even faster)
and for Next you simply pop the first element off the list O(1).
The storage would be O(n) for initialize but next/hasnext don't use extra space. Read more60Show 5 RepliesReplyOM PRAKASHJan 31, 2024Very poor description, what is move to right. After watching some solution I got the idea. It is asking for some linked list type inorder way ... Read more52ReplyMatexaMar 04, 2024Some examples that may help. You're welcome :)
["BSTIterator","next","hasNext","next","hasNext","next","hasNext","next","hasNext"] [[[7,null,15,9,16]],[],[],[],[],[],[],[],[]]
["BSTIterator","next","hasNext","next","hasNext","next","hasNext","next","hasNext"] [[[9,6,10,3,null,null,null]],[],[],[],[],[],[],[],[]]
["BSTIterator","next","hasNext","next","hasNext","next","hasNext","next","hasNext","next","hasNext","next","hasNext","next","hasNext"] [[[8,5,10,3,6,9,12,1,null,null,7,null,null,11,null]],[],[],[],[],[],[],[],[],[],[],[],[],[],[]]
["BSTIterator","hasNext","next","hasNext"] [[[1]],[],[],[]] Read moreTip27Show 3 RepliesReplyAbdul Majid KhanFeb 21, 2025I got headache by just reading the Problem Description. Read more19ReplyQuan PhamJul 20, 2024If you store all values into a stack or a list, it would require O(N) extra space. Try Morris traversal method and use node.right as the next node. Read more18Show 2 RepliesReplyHiroki111Sep 16, 2023The description says:
The pointer should be initialized to a non-existent number smaller than any element in the BST.
Can someone rephrase this? I've seen a few solutions, but none of them are following this constraint Read more17Show 7 RepliesReplyVarunApr 20, 2022The question said "boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false". Shouldn't it mean for case [7, 3, 15, null, null, 9, 20], hasNext() for 9 must be false because 9 does not have a right child as to the right of the pointer of 9, there is nothing? I understand the solution sees the stack.top() but the question is saying hasNext() sees existence of number to the right of pointer. Can someone explain if I am reading something wrong or the words of question are put in the wrong way? Read more15Show 1 RepliesReplySunny CheungApr 20, 2022Why do we need to optimise code to O(h)
O(h) is not better than O(n) in worse case
Just like optimising bubble sort to deterministic quicksort, why
har har har
on99?
nvm leetcode ¯\(ツ)/¯ Read more13Show 8 RepliesReplyMarceloApr 05, 2025Worst problem description ever. Read moreFeedback9Reply
 */