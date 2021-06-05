package StockSpanner;

import java.util.*;

/**
 * @author: itsuki
 * @create: 2021-06-05 14:41
 **/
public class StockSpanner2 {
    Deque<Integer> deque;
    List<Integer> stock;
    int index;

    public StockSpanner2() {
        deque = new ArrayDeque<>();
        stock = new ArrayList<>();
        stock.add(10_0000 + 1);
        deque.offerLast(0);
        index = 0;
    }

    public int next(int price) {
        index++;
        while (!deque.isEmpty() && stock.get(deque.peekLast()) <= price) {
            deque.pollLast();
        }

        int count = index - deque.peekLast();
        deque.offerLast(index);
        stock.add(price);
        return count;
    }

    public static void main(String[] args) {
        StockSpanner2 stockSpanner = new StockSpanner2();
        System.out.print(stockSpanner.next(100) + "\t");
        System.out.print(stockSpanner.next(80) + "\t");
        System.out.print(stockSpanner.next(60) + "\t");
        System.out.print(stockSpanner.next(70) + "\t");
        System.out.print(stockSpanner.next(60) + "\t");
        System.out.print(stockSpanner.next(75) + "\t");
        System.out.print(stockSpanner.next(85) + "\t");
    }
}
