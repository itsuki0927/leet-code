package minIncrementForUnique;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: itsuki
 * @create: 2021-06-10 08:56
 **/
public class Solution {
    public int minIncrementForUnique(int[] nums) {
        int result = 0;
        UnionFind unionFind = new UnionFind();
        for (int v : nums) {
            // 如果在并查集中
            if (unionFind.contains(v)) {
                int root = unionFind.findRoot(v);
                int add = root + 1;
                result += (add - v);
                unionFind.init(add);
            } else {
                unionFind.init(v);
            }
        }

        return result;
    }

    static class UnionFind {
        int[] parent;

        UnionFind() {
            parent = new int[9];
            Arrays.fill(parent, -1);
        }

        void init(int m) {
            parent[m] = m;
            // 看看左边, 在不在并查集中, 在的话合并
            if (m > 0 && contains(m - 1)) {
                union(m, m - 1);
            }
            // 看看右边, 在不在并查集中, 在的话合并
            if (contains(m + 1)) {
                union(m, m + 1);
            }
        }

        // 是否在并查集中
        boolean contains(int m) {
            return parent[m] != -1;
        }

        // 查询根节点
        int findRoot(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        // 合并
        void union(int x, int y) {
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);

            if (xRoot == yRoot) {
                return;
            }

            // 小的连接到大的上面
            if (xRoot < yRoot) {
                parent[xRoot] = yRoot;
            } else {
                parent[yRoot] = xRoot;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }
}
