package PriorityQueueExample;

import java.util.*;

public class MainClass{
    public static void main(String[] args) {
        List<Student> v1 = new Vector<>();
        v1.add(new Student(45,55));
        v1.add(new Student(36,77));
        v1.add(new Student(66,87));


        Queue<Student> p1 = new PriorityQueue<>(v1);
        while(!p1.isEmpty()){
            System.err.println(p1.peek().print());
            p1.poll();
        }
    }
    
}