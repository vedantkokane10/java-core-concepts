package PriorityQueueExample;


public class Student implements Comparable<Student>{
    private int math;
    private int science;

    public Student(int math, int science){
        this.math = math;
        this.science = science;
    }

    public String print(){
        String ans = "Science - " + this.science + ", Math - " + this.math; 
        return ans;
    }

    public int getMath(){
        return this.math;
    }

    public int getScience(){
        return this.science;
    }

    @Override
    public int compareTo(Student obj) {
        /*
        Logic - for smallest at the top 
            if(currentObject < otherObject){
                return -1; <- any -ve number is fine
            }
            else if(currentObject > otherObject){
                return 1;
            }
            else{
                return 0;
            }
            vice-versa for largest at the top
        */

        if(this.math < obj.math){
            return -1;
        }
        else{
            return 1;
        }

        //throw new UnsupportedOperationException("Not supported yet.");
    }
}