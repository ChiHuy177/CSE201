package CSE201;

import java.util.Scanner;

public class EICREDIT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int testCase = sc.nextInt();
		while (testCase-- > 0) {
			String id = sc.next();
			int subject = sc.nextInt();
			int[]grade = new int[subject]; 
			for (int i = 0; i<subject; i++) {
				grade[i] = sc.nextInt();
			}
			Student1 student = new Student1(id, grade);
			sb.append(student.getId()+" "+student.getPass()+"\n");
		}
		System.out.println(sb);
	}

}
class Student1 {
	String id;
	int subject;
	int[]grade = new int[subject];
	
	public Student1(String id, int[] grade) {
		super();
		this.id = id;
		this.grade = grade;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPass(){
		int count = 0;
		for (int i = 0; i<grade.length; i++) {
			if (grade[i] >= 50)
				count+=4;
		}
		return count;
	}
	
	
}
