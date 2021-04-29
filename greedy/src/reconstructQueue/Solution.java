package reconstructQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 解题思路: 贪心
 * <p>
 * 1. 先按照 h 升序、 k 降序(h相同)
 * 2. 然后根据 k 从左至右插入到指定的位置即可
 *
 * @author: itsuki
 * @create: 2021-04-29 10:09
 **/
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new LinkedList<>();
        // 根据 h 升序、h相同 k降序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        // 从左至右插入到k的位置
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][]);
    }
}
