package mycollections.generics;

import java.util.Iterator;


public class TestMain{
    public static void main(String[] args) {
        OurGenericList<Integer> list1 = new OurGenericList<>();
        list1.add(1);
        list1.add(2);

        Iterator<Integer> iterator = list1.iterator();

        // while(iterator.hasNext()){
        //     System.err.println(iterator.next());
        // }

        for(Integer x:list1){
            System.err.println(x); // The above code (while loop) is executing here the compiler is automatically calling next() and hasNext() functions
        }
    }
}

/*
 javac mycollections/generics/*.java
 java mycollections.generics.TestMain
 */