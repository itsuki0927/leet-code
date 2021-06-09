package findRedundantConnection;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-06-09 19:20
 **/
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);

        for (int[] edge : edges) {
            if (unionFind.isConnected(edge[0], edge[1])) {
                return edge;
            }
            unionFind.union(edge[0], edge[1]);
        }
        return null;
    }

    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        int findRoot(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        void union(int x, int y) {
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);
            if (xRoot == yRoot) return;
            parent[xRoot] = yRoot;
        }

        boolean isConnected(int x, int y) {
            return findRoot(x) == findRoot(y);
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println(Arrays.toString(new Solution().findRedundantConnection(edges)));
    }
}
