package PeekingIterator;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * @author: itsuki
 * @create: 2021-06-03 11:11
 **/
public class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> queue;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        queue = new ArrayDeque<>();
        while (iterator.hasNext()) {
            int n = iterator.next();
            queue.offer(n);
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return queue.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}