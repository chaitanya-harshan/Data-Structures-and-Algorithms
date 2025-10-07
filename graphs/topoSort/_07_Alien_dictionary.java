package graphs.topoSort;

import java.util.*;

public class _07_Alien_dictionary {
    // GFG - using Map
    // naukri -- different problem statement
    // GFG - tried to not use Map -- went shit

    //========== GFG (best solution) ========================================================================================
    public String findOrder(String[] words) {
        int n = words.length;
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        for (int i=0; i<n-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            
            for (int j=0; j<Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    break;
                }
            } 
        }
        
        
        Queue<Character> q = new LinkedList<>();
        for (char c : inDegree.keySet()) if (inDegree.get(c) == 0) q.offer(c);
        StringBuilder sb = new StringBuilder();
        
        while (!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);
            
            for (char nei: adj.get(cur)) {
                inDegree.put(nei, inDegree.get(nei) - 1);
                if (inDegree.get(nei) == 0) q.offer(nei);
            }
        }
        
        return sb.length() == adj.size() ? sb.toString() : "";
    }


    //========== NAUKRI ========================================================================================
    // Question statement in naukri is absolute shit
    // k --> first k number of english alphabets are used by aliens
    public static String getAlienLanguage(String []dictionary, int k) {
        int n = dictionary.length;
        // --------------- graph creation ---------------
        List<Integer>[] adj = new ArrayList[k];
        for (int i=0; i<k; i++) adj[i] = new ArrayList<>();
        int[] inDegree = new int[k];

        for (int i=0; i<n-1; i++) {
            String w1 = dictionary[i];
            String w2 = dictionary[i+1];

            // we are checking for words being lexo sorted for real cause they only claimed and didnt guarantee it
            // eg: "cart" "car" --> here car should come first but its in 2nd
            // if (w1.length() > w2.length() && w1.startsWith(w2)) return "";

            for (int j=0; j<Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj[c1-'a'].add(c2-'a');
                    inDegree[c2-'a']++;
                    break;
                }
            }
        }
        //--------------- END ----------------

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<k; i++) if (inDegree[i] == 0) q.offer(i);
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append((char)('a'+cur));

            for (int nei: adj[cur]) {
                if (--inDegree[nei] == 0) q.offer(nei);
            }
        }

        return sb.length() == k ? sb.toString() : "";
    }
//================ GFG ========================================================================================================
    // Super shit way -- I was trying to not use Map so this happened.
    public String findOrder1(String[] words) {
        int n = words.length;
        HashSet<Character> set = new HashSet<>();
        for (String w: words) {
            for (char c: w.toCharArray()) {
                set.add(c);
            }
        }
        int k = 26; // idx to length
        
        List<Integer>[] adj = new ArrayList[k];
        for (int i=0; i<k; i++) adj[i] = new ArrayList<>();
        int[] inDegree = new int[k];
        
        for (int i=0; i<n-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            
            for (int j=0; j<Math.min(w1.length(), w2.length()); j++) {
                int a = w1.charAt(j)-'a', b = w2.charAt(j)-'a';
                if (a != b) {
                    adj[a].add(b);
                    inDegree[b]++;
                    break;
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (char i: set) if (inDegree[i-'a'] == 0) q.offer(i-'a');
        StringBuilder sb = new StringBuilder();
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append((char)('a'+cur));
            
            for (int nei: adj[cur]) {
                if (--inDegree[nei] == 0) q.offer(nei);
            }
        }
        
        return sb.length() == set.size() ? sb.toString() : "";
    }
}

/*
GFG - https://www.geeksforgeeks.org/problems/alien-dictionary/1
_Alien Dictionary_
 * A new alien language uses the English alphabet, but the order of letters is unknown. 
 * You are given a list of words[] from the alien language’s dictionary, where the words
 * are claimed to be sorted lexicographically according to the language’s rules.

Your task is to determine the correct order of letters in this alien language based 
on the given words. If the order is valid, return a string containing the unique letters 
in lexicographically increasing order as per the new language's rules. If there are 
multiple valid orders, return any one of them.

However, if the given arrangement of words is inconsistent with any possible letter ordering, 
return an empty string ("").

A string a is lexicographically smaller than a string b if, at the first position where 
they differ, the character in a appears earlier in the alien language than the corresponding 
character in b. If all characters in the shorter word match the beginning of the longer word, 
the shorter word is considered smaller.

Note: Your implementation will be tested using a driver code. It will print true if your 
returned order correctly follows the alien language’s lexicographic rules; otherwise, it
 will print false.

Examples:

Input: words[] = ["baa", "abcd", "abca", "cab", "cad"]
Output: true
Explanation: A possible corrct order of letters in the alien dictionary is "bdac".
The pair "baa" and "abcd" suggests 'b' appears before 'a' in the alien dictionary.
The pair "abcd" and "abca" suggests 'd' appears before 'a' in the alien dictionary.
The pair "abca" and "cab" suggests 'a' appears before 'c' in the alien dictionary.
The pair "cab" and "cad" suggests 'b' appears before 'd' in the alien dictionary.
So, 'b' → 'd' → 'a' → 'c' is a valid ordering.
Input: words[] = ["caa", "aaa", "aab"]
Output: true
Explanation: A possible corrct order of letters in the alien dictionary is "cab".
The pair "caa" and "aaa" suggests 'c' appears before 'a'.
The pair "aaa" and "aab" suggests 'a' appear before 'b' in the alien dictionary. 
So, 'c' → 'a' → 'b' is a valid ordering.
Input: words[] = ["ab", "cd", "ef", "ad"]
Output: ""
Explanation: No valid ordering of letters is possible.
The pair "ab" and "ef" suggests "a" appears before "e".
The pair "ef" and "ad" suggests "e" appears before "a", which contradicts the ordering rules.
Constraints:
1 ≤ words.length ≤ 500
1 ≤ words[i].length ≤ 100
words[i] consists only of lowercase English letters.
 */










 /*
  * Naukri 
https://www.naukri.com/code360/problems/alien-dictionary_630423 - very shit problem statement

  You have been given a sorted (lexical order) dictionary of an alien language.

Write a function that returns the order of characters as a string in the alien language. 
This dictionary will be given to you as an array of strings called 'dictionary', of size 'N'.

Example :
If the dictionary consists of the following words:-
["caa", "aaa", "aab"], and 'K' is 3.

Then, the order of the alphabet is -
['c', 'a', 'b']
Note:
If the language consists of four letters, the four letters should be the starting four letters of the English language. 

However, their order might differ in the alien language.
  */