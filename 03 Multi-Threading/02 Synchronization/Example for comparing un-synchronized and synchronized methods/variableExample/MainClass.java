package variableExample;

import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Main thread is starting");

        Variable v1 = new Variable(5);


        // In Java, threads can’t be forced to start at the exact same time because scheduling is OS dependent. But we can synchronize their start using CountDownLatch so they begin execution simultaneously from a common barrier point.
        CountDownLatch latch = new CountDownLatch(1); // 1 means "wait until 1 event happens"
        // CountDownLatch is used as a starting barrier.
        // The threads call latch.await() and wait until the latch count becomes 0.
        // When latch.countDown() is called, all waiting threads are released and start execution together.
        // The number (1) in CountDownLatch(1) is NOT time; it is the number of events to wait for.


        Thread t1 = new Thread(() -> {
            try {
                latch.await(); // -> wait
            } 
            catch (Exception e) {
                System.out.println("Error - " + e);
            }
            System.out.println("Incrementer executing, x: " + v1.increment());
        }, "Incrementer");

        Thread t2 = new Thread(() -> {
            try {
                latch.await();
            } 
            catch (Exception e) {
                System.out.println("Error - " + e);
            }
            System.out.println("Decrementer executing, x: " + v1.decrement());
        }, "Decrementer");

        t1.start();
        t2.start();

        // Release latch → both threads start together (as close as possible)
        latch.countDown(); // -> go

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println("Error - " + e);
        }
    

        try {
            // telling the Main thread to sleep for 3000 mili-seconds
            Thread.sleep(3000);
        }
        catch (Exception e) {
            System.out.println("Error - " + e);
        }

        System.out.println("After all thread's execution x: " + v1.getSharedVariableValue());


        // we are passing 5 as default value
        // we are incrementing it and we are also decrementing, so its final value should be 5
        // but we are getting either of 4 or 6 because, here race condition has occured
        // the output depends on the order of execution of the threads & and is unpredictable




        // Synchronized
        Thread t3 = new Thread(() -> {
            try {
                latch.await();
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("Incrementer (Sync) executing, x: " + v1.incrementSync());
        },"Increment Sync");

        Thread t4 = new Thread(() -> {
            try {
                latch.await();
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("Decrementer (Sync) executing, x: " + v1.decrementSync());
        },"Decrement Sync");

        t3.start();
        t4.start();

        latch.countDown();


        try {
            t1.join();
            t2.join();
            Thread.sleep(3000);
            System.out.println("After all thread's execution x: " + v1.getSharedVariableValue());
        } 
        catch (Exception e) {
            System.out.println(e);
        }

        
    }  
}
