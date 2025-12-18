package PriorityQueueExample;

import java.util.*;

public class MainClass{
    public static void main(String[] args) {
        List<Student> v1 = new Vector<>();
        v1.add(new Student(45,55));
        v1.add(new Student(36,77));
        v1.add(new Student(66,87));


        Queue<Student> p1 = new PriorityQueue<>(v1); // <- here we used the Comparable class but instead we can also use lambdas
        // here we used the comparable class, which we implemented while defining the Student class
        while(!p1.isEmpty()){
            System.err.println(p1.peek().print());
            p1.poll();
        }


        // In lambdas (a,b) -> (b-a) for max to min and (a-b) for min to max
        Queue<Student> p2 = new PriorityQueue<>((s1,s2) -> (s2.getMath() - s1.getMath())); // <- use of lambdas
        // Here we used the comparator function, where we directly tell the priorityqueue, in what format we want the data
        for(Student x:v1){
            p2.offer(x);
        }
        while(!p2.isEmpty()){
            System.err.println(p2.peek().print());
            p2.poll();
        }
    }
    
}