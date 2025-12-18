package  TestingSetsUsingCustomDataTypes;


public class Student{
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o; // type-casting the Object in Student class
        return math == student.math &&
            science == student.science;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(math, science);
    }
}