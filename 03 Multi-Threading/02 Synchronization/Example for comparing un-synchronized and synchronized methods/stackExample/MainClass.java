package stackExample;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Main thread is starting");
        
        Stack s1 = new Stack(5);
        

        Thread t1 = new Thread(() -> {
            int counter = 1;
            while(counter <= 10){
                System.out.println("Pushed: " + 10);
                s1.push(10);
                counter++;
            }
        }, "Pusher");

        //t1.start();


        Thread t2 = new Thread(() -> {
            int counter = 1;
            while(counter <= 10){
                System.err.println("Popped: " + s1.pop());
                counter++;
            }
        }, "Popper");

        //t2.start();


        // We will end up getting exception 
        // Exception in thread "Pusher" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 5
        // Because when Pusher thread try to enter into the push method, it increments the stack top and waits for 1000 mili-seconds
        // At that time Popper thread might execute and pop all the elements 
        // as a result the stack counter may get decremented to -1 (Empty)
        // hence -1 index is out of bounds
        // So, we need synchronization for the stack's top variable so that only 1 thread can access it at a time
        // push() & pop() methods are changing the state 


        // we use synchronize block

        System.out.println("Main thread is starting (Synchronization)");

        Stack s2 = new Stack(5);

        Thread t3 = new Thread(() -> {
            int counter = 1;
            while(counter <= 10){
                System.out.println("Pushed (Synchronized) : " + 10);
                s1.pushSync(10);
                counter++;
            }
        }, "Pusher (Synchronized)");

        t3.start();


        Thread t4 = new Thread(() -> {
            int counter = 1;
            while(counter <= 10){
                System.err.println("Poped (Synchronized) : " + s1.popSync());
                counter++;
            }
        }, "Popper (Synchronized)");

        t4.start();

    }
}
