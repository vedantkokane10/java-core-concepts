package mycollection;

import java.util.*;

// Sets stores unique values
// HashSet uses hash table for efficient, unordered storage
// HashSet<> -> stores elements in unsorted fashion (insertion order is also not maintained)
// add(element) -> takes O(1)
// remove(element) -> takes O(1)
// contains(element) -> takes O(1) (to search a element whether present in set of not)


public class HashSets{
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        s1.add(11);
        s1.add(6);
        s1.add(4);
        s1.add(3);
        s1.add(1);
        s1.add(2);

        System.err.println(s1);

        Set<Integer> s = new HashSet<>(s1);
        Set<Integer> s2 = new HashSet<>(Arrays.asList(1,2,3,6,8,99));

        // Set operations
        s1.addAll(s2);
        System.err.println(s1); // Union -> addAll()

        Set<Integer> s3 = new HashSet<>(s);
        s3.retainAll(s2);  // Intersection -> retainAll()
        System.err.println(s3); 

        Set<Integer> s4 = new HashSet<>(s);
        s4.retainAll(s2); // Set difference -> removeAll()
        System.err.println(s4); 

        Set<Integer> s5 = new HashSet<>(s);
        System.err.println(s5.containsAll(s2)); // Subset check 
    }
}