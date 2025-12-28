package mypackage;

public class MainClass {
    public static void main(String[] args) {
        // Main Function is also a single thread
        // It is the ultimate parent thread
        // any thread (thread classes we execute) that we run from here are child thread for this main thread
        // all child and main thread are user threads
        // There are 2 types of thread user and daemon
        // Main is user and also if we don't explicitly mention then any derived thread is user thread

        System.out.println("Main Thread is executing");

        Thread1 t1 = new Thread1();
        t1.start(); 
        // start() moves the thread from NEW to RUNNABLE state.
        // Actual execution depends on the JVM thread scheduler.
        // if again used t1.start() then exception might raised that t1 already started


        Thread2 t2 = new Thread2("Thread2");
        t2.setDaemon(true);
        t2.start();
        // Since t2 is daemon thread it can happen it might not get executed as once all user thread stop execution the program terminates even if there are any daemon thread currently executing


        System.out.println("Main Thread is exiting its execution");

        // Order cannot be determined, so do not make any assumptions.
        // The first line always executes first.
        // After start(), execution order depends on the JVM scheduler.



        // Lets see the use of Runnable interface
        // Thread3 is class that we defined and it implements Runnable interface
        Thread t3 = new Thread(new Thread3(), "Thread3");
        t3.start();


        // Thread is a non-abstract class
        // so we can make a directly make object of Thread class as well
        new Thread().run();
        // this will do nothing
        // Because inside Thread class we have a target/task which is instance of Runnable
        // by default it is null 
        // it executes by target.run() if its not null
        // So if we pass our Thread3's instace to the Thread(new Thread3) then the target becomes Thread3
        // so target.run() will execute the Thread3's run() function
        // which we did earlier
        // This is a way to pass instace of Runnable to the Thread class
        // There is another way as well, where directly extending the Thread class writing the run() which we did earlier for Thread1 and Thread2
        
        // Implenting Threadvia Runnable interface is better appraoch because if we extend Thread class we cannot extend any other class where as we can implement multiple interfaces

        // use of Lambdas instead of Run Method
        Thread t4 = new Thread(
            () ->{
                for(int i=1;i<=5;i++){
                    System.out.println("Currently inside " + Thread.currentThread().getName() + ", i=" + i);
                }
            },
            "Thread4"
        );
        t4.start();
        // Here we used lambdas instead of writing a classs which either extends Thread class or implements Runnable interface and overriding the run() function

    }
}
