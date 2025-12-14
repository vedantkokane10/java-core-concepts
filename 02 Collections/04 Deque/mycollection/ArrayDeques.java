package mycollection;

import java.util.ArrayDeque;
import java.util.Deque;

// most functions are same as Queue Interface just it offers First and Last functionalities with offer, add, peek, remove

public class ArrayDeques{
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>();
        d1.offerLast(44);
        d1.offerFirst(34);
        System.err.println(d1.peekFirst());
        d1.pollFirst();
        d1.offerFirst(4);
        System.err.println(d1.peekLast());
    }
}