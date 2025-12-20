package mycollection;

import java.util.*;

public class TreeMaps {
    public static void main(String[] args) {
        Map<Integer, String> mp1 = new TreeMap<>(); // Instead of Map we can use SortedMap, NavigableMap

        mp1.put(1,"vedant");
        mp1.put(4,"john");
        mp1.put(3,"Martin");
        mp1.put(2,"josh");
        
        Set<Integer> s1 = mp1.keySet(); 
        for(Integer x:s1){
            System.out.println(x + " -> " + mp1.get(x));
        }
        

        // lets store elements in reverse order (descending) using lambdas
        SortedMap<Integer, String> mp2 = new TreeMap<>((a,b) -> b-a); 
        mp2.put(1,"vedant");
        mp2.put(4,"john");
        mp2.put(3,"Martin");
        mp2.put(2,"josh");
        

        Set<Integer> s2 = mp2.keySet();
        for(Integer x:s2){
            System.out.println(x + " -> " + mp2.get(x));
        }



        // NavigableMap interface operations
        NavigableMap<Integer, String> mp3 = new TreeMap<>(); 
        mp3.put(1,"vedant");
        mp3.put(4,"john");
        mp3.put(3,"Martin");
        mp3.put(2,"josh");


        // NavigableSet function on Map.Entry
        System.out.println("first entry -> " + mp3.firstEntry());
        System.out.println("last entry -> " + mp3.lastEntry());
        System.out.println("Ceiling for 3 -> " + mp3.ceilingEntry(3)); // greater than or equal to 3
        System.out.println("floor for 4 -> " + mp3.floorEntry(4)); // lower than or equal to 4

        // NavigableSet function on Map.Keys
        System.out.println("first key -> " + mp3.firstKey());
        System.out.println("last key -> " + mp3.lastKey());
        System.out.println("Ceiling for 3 -> " + mp3.ceilingKey(3)); // greater than or equal to 3
        System.out.println("floor for 4 -> " + mp3.floorKey(4)); // lower than or equal to 4
    }
}
