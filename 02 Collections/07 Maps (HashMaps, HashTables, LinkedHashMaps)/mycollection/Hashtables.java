package mycollection;

import java.util.*;


// Hashtables Same as HashMap, key difference is Hashtable are type safe
// and does not allow null values (for both keys as well as values)

public class Hashtables {
    public static void main(String[] args) {
        Map<String,Integer> mp1 = new Hashtable<>(); 

        mp1.put("Vedant", 1);
        mp1.put("Martin", 2);
        mp1.put("Josh", 2);

        System.out.println(mp1.get("Vedant"));
        System.out.println(mp1.get("David")); // null

        System.out.println(mp1.getOrDefault("David", -1)); // if data not found in map it returns the default value which is -1 in this case
        System.out.println(mp1.getOrDefault("Martin", -1)); // 2 -> as Martin exists

        System.err.println(mp1.containsKey("Josh")); // true
        mp1.remove("Josh");


        // Iterating over a map
        System.out.println("Iterating over a map ->");
        Set<Map.Entry<String, Integer>> entrySet = mp1.entrySet();
        for(Map.Entry<String, Integer> x:entrySet){
            System.out.println(x.getKey() + " " + x.getValue());
        }

        // Iterating using the keys
        System.out.println("Iterating over a map using  keySet() ->");
        Set<String> keySets = mp1.keySet();
        for(String x:keySets){
            System.out.println(x + " " + mp1.get(x));
        }





        // Graph Adjacency List 
        /*
        {
            1 -> {2,3,4}
            2 -> {1,3}
            3 -> {1,2}
            4 -> {1}
        }
        */
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // To add a new Node in the adj list and a emppty list which will store its neighbours
        // if(adj.get(1) == null){
        //     adj.put(1, new ArrayList<>());
        // }
        // adj.get(1).add(2);
        
        // the above code can be replaced with one function computIfAbsent() and adding a lambda inside
        adj.computeIfAbsent(1, f -> new ArrayList<>()).add(2);  // this takes 2 arguments -> (key, mappingFunction)
        // It first checks if we have a key 1, if YES the mapping function is not called, else it is called and a new ArrayList is created
        
    

    }
}
