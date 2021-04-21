package getKthMagicNumber;

import java.util.*;

public class Solution {
    public static int getKthMagicNumber(int k) {
        long[] prime = {3, 5, 7};
        PriorityQueue<Long> list = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        list.offer(1L);
        while (--k > 0) {
            Long num = list.poll();
            for (long n : prime) {
                if (set.add(num * n)) {
                    list.offer(n * num);
                }
            }
        }
        return list.poll().intValue();
    }

    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(5));
    }
}
