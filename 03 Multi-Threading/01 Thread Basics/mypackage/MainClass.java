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

        Thread2 t2 = new Thread2("Thread2");
        t2.setDaemon(true);
        t2.start();
        // Since t2 is daemon thread it can happen it might not get executed as once all user thread stop execution the program terminates even if there are any daemon thread currently executing


        System.out.println("Main Thread is exiting its execution");

        // Order cannot be determined, so do not make any assumptions.
        // The first line always executes first.
        // After start(), execution order depends on the JVM scheduler.
    }
}
