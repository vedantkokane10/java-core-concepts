package stackExample;

public class Stack {
    private int[] arr;
    private int size;
    int top;
    Object lock;
    public Stack(int size){
        this.size = size;
        this.top = -1;
        arr = new int[size];
        this.lock = new Object();
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean push(int element){
        if(this.top+1 < size){
            this.top++;

            try {
                // current thread sleeps for 1000 mili-seconds
                Thread.sleep(1000);
            } 
            catch (Exception e) {
                System.out.println("Error - " + e);
            }

            this.arr[this.top] = element;
            return true;
        }
        return false;
    }

    public int pop(){
        if(isEmpty() == true){
            return -1;
        }
        int topElement = arr[top];
        arr[top] = Integer.MAX_VALUE;

        try {
            Thread.sleep(1000);
        } 
        catch (Exception e) {
            System.out.println("Error - " + e);
        }

        top--;
        return topElement;
    }

    public boolean isFull(){
        return this.top >= this.size-1;
    }

    public boolean pushSync(int element){
        if(this.top+1 < size){

            // here we are using synchronized block we can use any object (Integer, Object, String) as lock 
            // if the thread has the lock then it can enter the critical section which is nothing but synchronized block
            // critical section is a section which contains shared resources
            // if there t1,t2 threads and lets suppose t1 has access to lock and enters the pushSync method then t2, t3 cannot enter pushSync, as well as popSync
            // because both pushSync and popSync are bounded by same lock (lock object), so whichever thread has access to lock can access these 2 functions
            // This essentially means even if methods are completely different but bound by same lock, then the methods cannot be accessed concurrently by multiple threads at same time
            // But if we have different locks for different methods then the threads can access methods concurrently depending upon the lock's access they have
            // Ex lock1 -> push, lock2 -> pop, here t1 can have access to push and concurrently t2 can have access to pop method
            // in our case for Stack class we should have only 1 lock, because we want to prevent concurrent execution of push and pop
            synchronized (this) {
                // synchronized (lock) -> can also work

                this.top++;

                try {
                    // current thread sleeps for 1000 mili-seconds
                    Thread.sleep(1000);
                } 
                catch (Exception e) {
                    System.out.println("Error - " + e);
                }

                this.arr[this.top] = element;
            }
            
            return true;
        }

        // if we want to synchronize the entire method instead of some part then we can use synchronized key word while defining the function
        // public synchronized boolean pushSync(int element){}
        // here we don't need a explicit lock 
        // because (compiler translates) the method body into -> synchronized(this) { function body } 
        // it uses the reference i.e instance of current object (this) as lock
        // if there are multiple synchronized methods then all methods share same lock (this only) so only 1 method can be executed by thread at a time 
        // If methods are declared synchronized, they block on the same object reference (this). So only one thread can execute any synchronized method on that object at a time.
        // If t1 enters a synchronized method, t2 must wait until t1 exits,
        // because all synchronized methods lock on the same object (this)
        return false;
    }

    public int popSync(){
        if(this.isEmpty()){
            return -1;
        }
        int topElement = -1;
        synchronized(this){
            topElement = arr[top];
            arr[top] = Integer.MAX_VALUE;

            try {
                Thread.sleep(1000);
            } 
            catch (Exception e) {
                System.out.println("Error - " + e);
            }

            top--;
        }

        return topElement;
    }
}
