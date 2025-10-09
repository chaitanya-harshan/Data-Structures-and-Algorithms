package graphs.dsu;

public class _number_of_ops_to_make_network_connected {
    public int makeConnected(int n, int[][] connections) {
        int extra_edges = 0;
        DSU uf = new DSU(n);

        for (int[] e: connections) {
            if (uf.find(e[0]) == uf.find(e[1])) extra_edges++;
            else uf.union(e[0], e[1]);
        }

        if (extra_edges >= uf.sets-1) return uf.sets-1;
        else return -1;
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
 * URL: https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/

1319. Number of Operations to Make Network Connected

There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

 
Example 1:
Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
Example 2:
Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:
Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.

 
Constraints:

	1 <= n <= 105
	1 <= connections.length <= min(n * (n - 1) / 2, 105)
	connections[i].length == 2
	0 <= ai, bi < n
	ai != bi
	There are no repeated connections.
	No two computers are connected by more than one cable.
 */