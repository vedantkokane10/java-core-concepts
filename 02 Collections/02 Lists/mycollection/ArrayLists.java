package mycollection;
import java.util.*;


public  class ArrayLists{
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println(list1);

        // to create a initialized list
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3));
        list2.add(5);
        list2.set(3,88); // to change value at index 3 with 88
        System.out.println(list2);

        // to use a existing ArrayList and create a new copy of it, list3 is a new list which is initialized to list2
        List<Integer> list3 = new ArrayList<>(list2);
        list3.add(33);
        System.out.println(list3);


        // list4 references to list1 so any changes made in either of list1 or list4 changes will be visible for both
        List<Integer> list4 = list1;
        list4.add(45);
        System.out.println(list4);
        System.out.println(list1);


        // Funtions
        System.out.println(list4.get(1)); // get(index) -> retrives element from the list present at index
        list4.set(3,90); // set(index, newValue) -> resets element at index to newValue
        System.out.println(list4.size()); // return the size
        System.out.println(list4.remove(0)); // remove(index) -> removes element present at index
        list4.clear(); // clear() -> removes all the elements
        System.out.println(list4.isEmpty()); // isEmpty() -> return true/false if list is empty or not

        list4.addAll(list3);   // addAll(list) -> adds list at the end
        list3.addAll(2, list2);  // addAll(index, list) -> adds a list after index
        System.out.println(list4);
        System.out.println(list3);


        // sorting arrays
        List<Integer> arr = new ArrayList<>(Arrays.asList(5,3,2,1,2,4,6,9,7));
        Collections.sort(arr);
        System.out.println("sorted in ascending order - " + arr);


        // descending order
        Collections.sort(arr, (a,b) -> b-a); 
        //Collections.sort(arr, Collections.reverseOrder()); // <- this would also work
        System.out.println("sorted in descending order - " + arr);
    }
}

/*
 javac mycollection/*.java
 java mycollection.ArrayLists
*/