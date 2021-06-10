package longestConsecutive;

import java.util.HashMap;

/**
 * @author: itsuki
 * @create: 2021-06-10 08:22
 **/
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        UnionFind unionFind = new UnionFind(nums);
        for (int v : nums) {
            unionFind.union(v, v + 1);
        }

        // 二次遍历，记录领队距离
        int max = 1;
        for (int v : nums)
            max = Math.max(max, unionFind.findRoot(v) - v + 1); // uf.find() 查找领队
        return max;
    }

    static class UnionFind {
        HashMap<Integer, Integer> hashMap;

        UnionFind(int[] nums) {
            hashMap = new HashMap<>();
            for (int num : nums) {
                hashMap.put(num, num);
            }
        }

        Integer findRoot(int x) {
            if (!hashMap.containsKey(x)) return null;
            while (hashMap.get(x) != x) {
                hashMap.put(x, hashMap.get(hashMap.get(x)));
                x = hashMap.get(x);
            }
            return x;
        }

        void union(int x, int y) {
            Integer xRoot = findRoot(x);
            Integer yRoot = findRoot(y);
            if (xRoot == null || yRoot == null) {
                return;
            }
            if (xRoot.equals(yRoot)) return;
            hashMap.put(xRoot, yRoot);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
