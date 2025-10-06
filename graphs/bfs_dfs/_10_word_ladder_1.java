package graphs.bfs_dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _10_word_ladder_1 {
    // do bfs to find the number of steps.
    // each tep is finding the closest word to cur by brute force trying all possibilities
    // of checking a-z at 'i' of the current word
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String s: wordList) set.add(s);

        if (!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        set.remove(beginWord);

        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            steps++;

            for (int d=0; d<size; d++) {
                char[] cur = q.poll().toCharArray();

                for (int i=0; i<cur.length; i++) {
                    char ogChar = cur[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        cur[i] = c;
                        String nei = new String(cur);

                        if (set.contains(nei)) {
                            if (nei.equals(endWord)) return steps;

                            q.offer(nei);
                            set.remove(nei);
                        }
                    }
                    cur[i] = ogChar;
                }
            }
        }
        return 0;
    }
}

/*
 * URL: https://leetcode.com/problems/word-ladder/description/

127. Word Ladder

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 
Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

 
Constraints:

	1 <= beginWord.length <= 10
	endWord.length == beginWord.length
	1 <= wordList.length <= 5000
	wordList[i].length == beginWord.length
	beginWord, endWord, and wordList[i] consist of lowercase English letters.
	beginWord != endWord
	All the words in wordList are unique.
 */