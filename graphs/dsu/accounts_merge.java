package graphs.dsu;

public class accounts_merge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        HashMap<String, Integer> mailMap = new HashMap<>();
        DSU uf = new DSU(n);

        for (int i=0; i<n; i++) {
            for (int j=1; j<accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                
                if (!mailMap.containsKey(mail)) mailMap.put(mail, i);
                else uf.union(i, mailMap.get(mail));
            }
        }

        List<String>[] merged = new ArrayList[n];
        for (int i=0; i<n; i++) merged[i] = new ArrayList<>();

        for (Map.Entry<String, Integer> e: mailMap.entrySet()) {
            int p = uf.find(e.getValue());
            merged[p].add(e.getKey());
        }

        List<List<String>> res = new ArrayList<>();

        for (int i=0; i<n; i++) {
            if (merged[i].size() == 0) continue;
            Collections.sort(merged[i]);

            String name = accounts.get(i).get(0);
            merged[i].add(0, name);
            res.add(new ArrayList<>(merged[i]));
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

    void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);

        if (pi == pj) return;

        if (size[pi] < size[pj]) {
            parent[pi] = pj;
            size[pj] += size[pi];
        } else {
            parent[pj] = pi;
            size[pi] += size[pj];
        }

        sets--;
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