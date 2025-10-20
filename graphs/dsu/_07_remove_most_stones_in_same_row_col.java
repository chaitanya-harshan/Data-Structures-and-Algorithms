package graphs.dsu;

import java.util.HashSet;

public class _07_remove_most_stones_in_same_row_col {
    // we see each row & col as nodes and each stone x,y acts as a edge connecting x & y.
    // after connecting we will consider/take one stone from each node
    // then total stones - these one_stone_per_connected_component
    public int removeStones(int[][] stones) {
        int maxRow = 0, maxCol = 0;
        for (int[] e: stones) {
            maxRow = Math.max(maxRow, e[0]);
            maxCol = Math.max(maxCol, e[1]);
        }

        DSU uf = new DSU(maxRow + 1 + maxCol + 1);

        for (int[] e: stones) {
            int x = e[0];
            int y = maxRow + 1 + e[1];
            uf.union(x, y);
        }

        // Initially we have max row + call + 2 unique notes in the Union-Find. But we are going to combine some of 
        // the notes, that is, rows and columns. But in the end we won't touch some rows and columns in the     
        // Union-Find cause there aren't stones, so they will live as separate nodes. But we only want the 
        // component where things are connected. Therefore we iterate and try to find the unique items instead of 
        // just calling uf.sets 

        // Here we iterate through only the stones so the nodes which persisted in the uf due to no stones in them
        // won't be called and effect the set size.
        HashSet<Integer> set = new HashSet<>();
        for (int[] s: stones) {
            set.add(uf.find(s[0])); // using s[1] will result the same as they are already connected
        }

        return stones.length - set.size();
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
 * URL: https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/

947. Most Stones Removed with Same Row or Column

On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.

 
Example 1:
Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Explanation: One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
Example 2:
Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Explanation: One way to make 3 moves is as follows:
1. Remove stone [2,2] because it shares the same row as [2,0].
2. Remove stone [2,0] because it shares the same column as [0,0].
3. Remove stone [0,2] because it shares the same row as [0,0].
Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
Example 3:
Input: stones = [[0,0]]
Output: 0
Explanation: [0,0] is the only stone on the plane, so you cannot remove it.

 
Constraints:

	1 <= stones.length <= 1000
	0 <= xi, yi <= 104
	No two stones are at the same coordinate point.
 */