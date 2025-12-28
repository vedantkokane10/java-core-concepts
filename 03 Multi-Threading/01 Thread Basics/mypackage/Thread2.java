package mypackage;

public class Thread2 extends Thread{

    public Thread2(String threadName) {
        super(threadName);
    }

    @Override
    public void run(){
        for (int i = 1; i <= 5; i++) {
            System.out.println("Currently inside " + Thread.currentThread().getName() + ", i=" + i);
        }

        // Thread in above line is static method
        // if we dont mention .getName() after Thread.currentThread() then returns -> [CurrentThreadName, Priority, ParentThreadName]
    }

}
