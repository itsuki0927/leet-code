package maxDistance;

import java.util.Arrays;

/**
 * @author: itsuki
 * @create: 2021-05-18 07:28
 **/
public class Solution {
    public boolean check(int[] position, int mid, int m) {
        int count = 1, prev = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - prev >= mid) {
                count++;
                prev = position[i];
            }
        }
        return count >= m;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = (position[position.length - 1] - position[0]) / (m - 1);
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(position, mid, m)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
