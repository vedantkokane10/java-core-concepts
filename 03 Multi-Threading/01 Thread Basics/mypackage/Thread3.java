package mypackage;;

public class Thread3 implements Runnable{

    @Override
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println("Currently inside " + Thread.currentThread().getName() + ", i=" + i);
        }
    }

}
