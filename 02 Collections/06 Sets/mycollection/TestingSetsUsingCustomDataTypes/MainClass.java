package TestingSetsUsingCustomDataTypes;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        Set<Student> s1 = new HashSet<>();
        s1.add(new Student(40,50));
        System.err.println(s1.contains(new Student(40,50))); // will give true because we overrided the hashCode() and equals() methods
    }
}
