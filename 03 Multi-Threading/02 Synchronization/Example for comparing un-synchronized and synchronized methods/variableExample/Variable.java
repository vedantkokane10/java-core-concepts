package variableExample;

public class Variable {
    int sharedVariable; // <- Shared resource

    public Variable(int value){
        this.sharedVariable = value;
    }

    public int increment(){
        int x = sharedVariable;
        x++;

        // sleep for 1000 ms
        try {
            Thread.sleep(1000);
        } 
        catch (Exception e) {
            System.out.println("Error - " + e);
        }

        sharedVariable = x;

        return x;   
    }

    public int decrement(){
        int y = sharedVariable;
        y--;

        // sleep for 1000 ms
        try {
            Thread.sleep(1000);
        } 
        catch (Exception e) {
            System.out.println("Error - " + e);
        }

        sharedVariable = y;
        return sharedVariable;
    }

    public int getSharedVariableValue(){
        return sharedVariable;
    }


    public synchronized int incrementSync(){
        int x = sharedVariable;
        x++;

        // sleep for 1000 ms
        try {
            Thread.sleep(1000);
        } 
        catch (Exception e) {
            System.out.println("Error - " + e);
        }

        sharedVariable = x;

        return x;   
    }

    public synchronized int decrementSync(){
        int y = sharedVariable;
        y--;

        // sleep for 1000 ms
        try {
            Thread.sleep(1000);
        } 
        catch (Exception e) {
            System.out.println("Error - " + e);
        }

        sharedVariable = y;
        return sharedVariable;
    }
}
