package carPooling;

/**
 * 解题思路: 模拟
 *
 * @author: itsuki
 * @create: 2021-05-06 10:06
 **/
public class Solution2 {
    public boolean carPooling(int[][] trips, int capacity) {
        // 因为数据长度最大是1000, 所以直接模拟
        int[] locations = new int[1001];
        for (int[] trip : trips) {
            int num = trip[0], start = trip[1], end = trip[2];
            locations[start] += num; // 上车地点增加对应容量
            locations[end] -= num; // 下车地点减少对应容量
        }
        int sum = 0;
        for (int i = 0; i < 1001; i++) {
            sum += locations[i]; // 统计每个地点的容量
            if (sum > capacity) return false; // 容量不够
        }
        return true;
    }
}
