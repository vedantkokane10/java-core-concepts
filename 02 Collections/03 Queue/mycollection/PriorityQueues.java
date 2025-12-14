package mycollection;

import java.util.*;

public class PriorityQueues{
    public static void main(String[] args) {
        Queue<Integer> p1 = new PriorityQueue<>(); // Smallest on top
        p1.offer(101);
        p1.offer(22);
        p1.offer(44);

        System.err.println(p1.peek()); // [22]

 
        Queue<Integer> p2 = new PriorityQueue<>(Collections.reverseOrder()); // Largest on top
        p2.offer(101);
        p2.offer(22);
        p2.offer(44);

        System.err.println(p2.peek()); // [101]
        

        // Use of lambda function to choose the top
        Queue<Integer> p3 = new PriorityQueue<>((a,b) -> b-a); // this means largest element on top
        p3.offer(44);
        p3.offer(33);
        p3.offer(11);
        while(!p3.isEmpty()){
            System.err.println(p3.peek());
            p3.poll();
        }
    }
}

// javac mycollection/PriorityQueues.java
// java mycollection/PriorityQueues