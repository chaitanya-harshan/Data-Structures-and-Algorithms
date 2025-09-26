package graphs;

public class _01_number_of_provinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU uf = new DSU(n);

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (isConnected[i][j] == 1) uf.union(i,j);
            }
        }
        return uf.sets;
    }
}

class DSU {
    int[] parent;
    int[] rank;
    int sets;

    DSU(int n) {
        sets = n;
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
    }

    int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi == pj) return;

        if (rank[i] > rank[j]) parent[pj] = parent[pi];
        else if (rank[i] < rank[j]) parent[pi] = parent[pj];
        else {
            parent[pj] = parent[pi];
            rank[pi]++;
        }

        sets--;
    }
}


public class _01_number_of_provincesDFS {
    public int findCircleNum1(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n+1];
        int provinces = 0;

        for (int i=0; i< n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(isConnected, visited, i, n);
            }
        }
        return provinces;
    }

    void dfs(int[][] isConnected, boolean[] visited, int node, int n) {
        if (visited[node]) return;

        visited[node] = true;
        for (int i=0; i<n; i++) {
            if (isConnected[node][i] == 1) dfs(isConnected, visited, i, n);
        }
    }
}
