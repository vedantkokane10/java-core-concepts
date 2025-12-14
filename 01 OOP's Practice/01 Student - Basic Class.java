import java.util.*;

class Student{
    private int id;
    private String name;
    private List<Integer> marks;
    
    Student(int id, String name, List<Integer> marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
        
    public double getAverage(){
        int n = this.marks.size();
        if(n == 0){
            return 0.0;
        }
        double sum = 0.0;
        for(int i=0;i<n;i++){
            sum += marks.get(i);
        }
        return sum / (double) n;
    }
        
    public char getGrade(double marks){
        if(marks >= 80.0){
            return 'O';
        }
        else if(marks >= 70.0 && marks < 80.0){
            return 'A';
        }
        else if(marks >= 50 && marks < 70){
            return 'B';
        }
        else if(marks >= 35 && marks < 50){
            return 'C';
        }
        else{
            return 'F';
        }
    }
        
    public void printResult(){
        double average = getAverage();
        char grade = getGrade(average);
        String ans = this.id + "\t\t" + this.name + "\t\t" + average + "\t\t" + grade;
        System.out.println(ans);
    }
    
    public int getId(){
        return this.id;
    }
}


public class Main
{
	public static void main(String[] args) {
		List<Student> Students = new ArrayList<>();
		Student s1 = new Student(100, "Raj", Arrays.asList(55,67,78));
		Student s2 = new Student(101, "Narendra", Arrays.asList(55,44,77));
		Student s3 = new Student(102, "Nikhil", Arrays.asList(88,95,78));
		Students.add(s2);
		Students.add(s1);
		Students.add(s3);
		
		Collections.sort(Students, new Comparator<Student>(){
		    public int compare(Student s1, Student s2){
		        return s1.getId() - s2.getId(); 
		    }
		});
		
		
		
		String heading = "Id \t\t Name \t\t Average \t\t Grade";
		System.out.println(heading);
		for(int i=0;i<Students.size();i++){
		    Students.get(i).printResult();
		}
		
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		int start=0, end=Students.size()-1;
		boolean found = false;
		while(start <= end){
		    int mid = start + (end-start) / 2;
		    //System.out.println(Students.get(mid).getId());
		    if(Students.get(mid).getId() == target){
		        Students.get(mid).printResult();
		        found = true;
		        break;
		    }
		    
		    if(Students.get(mid).getId() < target){
		        start = mid+1;
		    }
		    else{
		        end = mid-1;
		    }
		}
		if(!found){
		    System.out.println("No record found for id - " +  target);
		}
	
	}
}