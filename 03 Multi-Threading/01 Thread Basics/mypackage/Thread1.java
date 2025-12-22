package mypackage;

public class Thread1 extends Thread {
    
    @Override
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println("Currently inside thread1, i=" + i);
        }
    }
    
}
