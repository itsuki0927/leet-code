package getPermutation;

/**
 * @author: itsuki
 * @create: 2021-06-16 09:15
 **/
public class Solution2 {
    boolean[] used;
    private int[] factorial;
    int n;
    int k;

    public String getPermutation(int n, int k) {
        if (n == 0) return null;
        this.n = n;
        this.k = k;
        used = new boolean[n + 1];

        StringBuilder path = new StringBuilder();
        calculateFactorial(n);
        dfs(0, path);

        return path.toString();
    }

    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    /**
     * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
     * @param path
     */
    private void dfs(int index, StringBuilder path) {
        if (index == n) {
            return;
        }

        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;
            // 如果cnt < k，表示不在这个全排列中
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            used[i] = true;
            path.append(i);
            dfs(index + 1, path);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution2().getPermutation(4, 9));
    }
}
