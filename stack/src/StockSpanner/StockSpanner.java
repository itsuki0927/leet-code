package StockSpanner;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author: itsuki
 * @create: 2021-06-05 14:41
 **/
public class StockSpanner {
    Deque<Integer> deque;
    HashMap<Integer, Integer> hashMap;

    public StockSpanner() {
        deque = new ArrayDeque<>();
        hashMap = new HashMap<>();
    }

    public int next(int price) {
        int count = 1;
        while (!deque.isEmpty() && deque.peekLast() <= price) {
            int p = deque.pollLast();
            count += hashMap.getOrDefault(p, 0);
        }
        hashMap.put(price, count);
        deque.offerLast(price);
        return count;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.print(stockSpanner.next(100) + "\t");
        System.out.print(stockSpanner.next(80) + "\t");
        System.out.print(stockSpanner.next(60) + "\t");
        System.out.print(stockSpanner.next(70) + "\t");
        System.out.print(stockSpanner.next(60) + "\t");
        System.out.print(stockSpanner.next(75) + "\t");
        System.out.print(stockSpanner.next(85) + "\t");
    }
}
