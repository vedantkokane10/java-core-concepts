package mycollection;

import java.util.*;

// TreeSet implement NavigableSet which implements SortedSet Interface 
// TreeSet stores elements in sorted manner
// Internally uses a Red-Black Tree (self-balancing BST)
// add/remove/search -> O(log n)

public class TreeSets{
    public static void main(String[] args) {
        Set<Integer> t1 = new TreeSet<>(); // <- Ascending order
        t1.add(6);
        t1.add(5);
        t1.add(6);
        t1.add(9);
        t1.add(1);

        System.out.println("t1 elements");
        Iterator<Integer> it = t1.iterator();
        while(it.hasNext()){
            System.err.println(it.next());
        }

        // lets use a comparator function
        NavigableSet<Integer> t2 = new TreeSet<>((a,b) -> b-a); // <- Descending order
        it = t1.iterator();
        while(it.hasNext()){
            t2.add(it.next());
        }

        // Instead of this while loop t2.addAll(t1) might have also worked

        System.out.println("t2 elements");
        for(Integer x:t2){
            System.err.println(x);
        }
        


        // NavigableSet interface has many specific functions which are not part of the Set<> interface
        
        System.err.println("Floor - " + t2.floor(5));   // Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
        System.err.println("Ceiling - " + t2.ceiling(5)); // Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
        System.err.println("Lower - " + t2.lower(5));   // Returns the greatest element in this set strictly less than the given element, or null if there is no such element.
        System.err.println("Higher - " + t2.higher(5)); //Returns the least element in this set strictly greater than the given element, or null if there is no such element.



    }
}


/*
    Best Practice to write comparator function
    NavigableSet<Integer> t2 = new TreeSet<>((a, b) -> Integer.compare(b, a));

    Because, what if a = min value and b = max value then overflow might be caused
    a = Integer.MIN_VALUE
    b = Integer.MAX_VALUE
    → overflow → wrong ordering
*/