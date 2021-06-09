package makeConnected;

/**
 * @author: itsuki
 * @create: 2021-06-09 19:50
 **/
public class Solution {
    public int makeConnected(int n, int[][] connections) {
        UnionFind unionFind = new UnionFind(n);
        int result = 0;
        for (int[] connection : connections) {
            result += unionFind.union(connection[0], connection[1]);
        }
        if (unionFind.count == 1) return 0;
        if (result < unionFind.count - 1) return -1;
        return unionFind.count - 1;
    }

    static class UnionFind {
        int count;
        int[] parent;

        public UnionFind(int count) {
            this.count = count;
            this.parent = new int[count];
            for (int i = 0; i < count; i++) {
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

        int union(int x, int y) {
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);
            if (xRoot == yRoot) return 0;
            parent[xRoot] = yRoot;
            count--;
            return 1;
        }
    }
}
