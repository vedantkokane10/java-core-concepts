package mycollection;

import java.util.*;

public class LinkedLists{
    public static void main(String[] args) {

        // LinkedList -> is a doubly linkedlist so we can iterate forward as well as backward

        List<Integer> list1 = new LinkedList<>();
        list1.add(1); // Adds at last
        list1.add(2);
        list1.addFirst(5); // Adds at first
        list1.addLast(7); // adds at last

        System.err.println(list1);
        System.err.println(list1.getFirst());
        System.err.println(list1.getLast());

        list1.removeFirst();
        list1.removeLast();
        list1.remove(0);
        System.err.println(list1);

        // All of ArrayList methods are applicable for LinkedList as well 

        // Iteration
        for(Integer x:list1){
            System.err.println(x);
        }      

        list1.add(11); 
        list1.add(24);
        list1.addFirst(544);


        // forward Iterator
        Iterator<Integer> iterator = list1.iterator();
        while(iterator.hasNext()){
            System.err.print(iterator.next() + " ");
        }
        System.err.println();

        // reverse Iterator 
        LinkedList<Integer> list2 = new LinkedList<>(list1);
        Iterator<Integer> reverseIterator = list2.descendingIterator(); // for this to work, we need LinkedList and not List on the LHS, while declaring the list
        while(reverseIterator.hasNext()){
            System.err.print(reverseIterator.next() + " ");
        }
    }
}

/*
 javac mycollection/*.java
 java mycollection.LinkedLists
*/