package mycollection;

import java.util.*;

public class PriorityQueues{
    public static void main(String[] args) {
        Queue<Integer> p1 = new PriorityQueue<>(); // Smallest on top
        p1.offer(101);
        p1.offer(22);
        p1.offer(44);

        System.err.println(p1); // [22, 101, 44]
        /**
           22
         /      \
      100       44 
         */
 
        Queue<Integer> p2 = new PriorityQueue<>(Collections.reverseOrder()); // Largest on top
        p2.offer(101);
        p2.offer(22);
        p2.offer(44);

        System.err.println(p2); // [101, 22, 44]

         /**
           100
         /      \
      22       44 
         */
    }
}

// javac mycollection/PriorityQueues.java
// java mycollection/PriorityQueues