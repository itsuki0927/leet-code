package numIslands;

/**
 * @author: itsuki
 * @create: 2021-06-09 16:50
 **/
public class Solution {
    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) return 0;
        cols = grid[0].length;
        int spaces = 0;
        UnionFind unionFind = new UnionFind(rows * cols);
        int[][] directions = {{1, 0}, {0, 1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 在遍历的过程中，同时记录空地的数量
                if (grid[i][j] == '0') {
                    spaces++;
                } else {
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        // 相邻的陆地（只需要向右看和向下看）合并，只要发生过合并，岛屿的数量就减少1
                        if (newX < rows && newY < cols && grid[newX][newY] == '1') {
                            unionFind.union(getIndex(i, j), getIndex(newX, newY));
                        }
                    }
                }
            }
        }

        // 并查集中连通分量的个数 - 空地的个数，就是岛屿数量
        return unionFind.count - spaces;
    }

    private int getIndex(int i, int j) {
        return i * cols + j;
    }

    static class UnionFind {
        int[] parent;
        int count;

        public UnionFind(int count) {
            this.count = count;
            this.parent = new int[count];
            for (int i = 0; i < count; i++) {
                this.parent[i] = i;
            }
        }

        public int findRoot(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);
            if (xRoot == yRoot) return;
            parent[xRoot] = yRoot;
            count--;
        }
    }

    public static void main(String[] args) {
        char[][] chars = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(new Solution().numIslands(chars));
    }
}
