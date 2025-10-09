package graphs.dsu;

public class islands_2 {
    public static int[] numOfIslandsII(int n, int m, int[][] queries) {
        DSU uf = new DSU(n*m);
        boolean[][] visited = new boolean[n][m];
        int islands = 0;
        int[] ans = new int[queries.length];
        int idx = 0;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for (int[] q: queries) {
            int i = q[0], j = q[1];
            if (visited[i][j]) {
                ans[idx++] = islands;
                continue;
            }
            islands++;
            visited[i][j] = true;

            for (int d=0; d<4; d++) {
                int r = i + dr[d];
                int c = j + dc[d];
                if (!isValid(r,c,n,m)) continue;

                if ((visited[r][c]) && uf.find(i*m+j) != uf.find(r*m+c)) {
                    islands--;
                    uf.union(i*m+j, r*m+c);
                }
            }
            ans[idx++] = islands;
        }
        return ans;
    }

    static boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) return false;
        return true;
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
 * https://www.naukri.com/code360/problems/number-of-islands-ii_1266048
 */