package mycollection;

import java.util.*;

// Sets stores unique values
// LinkedHashSet<> -> stores elements in insertion order
// We use LinkedHashSet only when we want to preserve the insertion order

// add(element) -> takes O(1)
// remove(element) -> takes O(1)
// contains(element) -> takes O(1) (to search a element whether present in set of not) return true/false


public class LinkedHashSets{
    public static void main(String[] args) {
        Set<Integer> s1 = new LinkedHashSet<>();
        s1.add(11);
        s1.add(6);
        s1.add(4);
        s1.add(3);
        s1.add(1);
        s1.add(2);

        System.err.println(s1);

        Set<Integer> s = new LinkedHashSet<>(s1);
        Set<Integer> s2 = new LinkedHashSet<>(Arrays.asList(1,2,3,6,8,99));

        // Set operations
        s1.addAll(s2);
        System.err.println(s1); // Union -> addAll()

        Set<Integer> s3 = new LinkedHashSet<>(s);
        s3.retainAll(s2);  // Intersection -> retainAll()
        System.err.println(s3); 

        Set<Integer> s4 = new LinkedHashSet<>(s);
        s4.retainAll(s2); // Set difference -> removeAll()
        System.err.println(s4); 

        Set<Integer> s5 = new LinkedHashSet<>(s);
        System.err.println(s5.containsAll(s2)); // Subset check 
    }
}