package mycollection;

import java.util.*;

// ArrayDeque -> Faster than LinkedList, No node overhead, Used in real systems

public class ArrayDeques{
    public static void main(String[] args) {
        Queue<Integer> q1 = new ArrayDeque<>();
        

        // To add element at back
        q1.add(1);  // throws exception if fails (If queue is full)
        q1.offer(2); // returns false if fails (If queue is full)

        System.err.println(q1);

        // To remove element present at front
        q1.remove(); // throws exception if empty (If queue is empty)
        q1.poll(); // returns null if empty ((If queue is empty))

        System.err.println(q1);

        q1.offer(3);
        q1.offer(4);

        // to get front element
        System.err.println(q1.element());  // throws exception if empty
        System.err.println(q1.peek()); // returns null if empty

        System.err.println(q1);
    }
}