package graphs.dsu;

import java.util.*;

public class _08_accounts_merge {
    // each person as connected_component: each mail of a person is a node and forms a edge from 
    // person -> their_mail
    // some nodes/mails are shared by multiple nodes/persons
    // we need to combine nodes/persons based on common mails to form connected components
    // -- commmon mails have multiple parents
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        // we use map to remember in which component was the node/mail present before
        HashMap<String, Integer> mailEdgesMap = new HashMap<>();
        DSU uf = new DSU(n);

        for (int i=0; i<n; i++) {
            // mails start from j=1
            for (int j=1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                // creating an edge
                if (!mailEdgesMap.containsKey(mail)) mailEdgesMap.put(mail, i);
                // common node found - if map contains node/mail then this node is connected to
                // another component so we need to merge the components
                else uf.union(i, mailEdgesMap.get(mail));
            }
        }

        List<String>[] merged = new ArrayList[n];
        for (int i=0; i<n; i++) merged[i] = new ArrayList<>();
        // iterating throught the edges and creating a connected component graph-ish
        for (Map.Entry<String, Integer> e: mailEdgesMap.entrySet()) {
            String mail = e.getKey();
            int immediateParent = e.getValue();

            int actualParent = uf.find(immediateParent);
            merged[actualParent].add(mail);
        }

        List<List<String>> res = new ArrayList<>();
        for (int i=0; i<n; i++) {
            List<String> list = merged[i];
            // these mails are added/combined into another person
            if (list.size() == 0) continue;

            Collections.sort(list);
            String name = accounts.get(i).get(0);
            list.add(0, name);
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}

class DSU {
    int[] parent;
    int[] size;
    int sets;

    public DSU(int n) {
        this.sets = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    boolean union(int i, int j) {
        int pi = find(i);
        int pj = find(j);

        if (pi == pj) return false;

        if (size[pi] < size[pj]) {
            parent[pi] = pj;
            size[pj] += size[pi];
        } else {
            parent[pj] = pi;
            size[pi] += size[pj];
        }

        sets--;
        return true;
    }
}

/*
 * URL: https://leetcode.com/problems/accounts-merge/description/

721. Accounts Merge

Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

 
Example 1:
Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Example 2:
Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]

 
Constraints:

	1 <= accounts.length <= 1000
	2 <= accounts[i].length <= 10
	1 <= accounts[i][j].length <= 30
	accounts[i][0] consists of English letters.
	accounts[i][j] (for j > 0) is a valid email.
 */