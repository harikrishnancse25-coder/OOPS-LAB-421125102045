import java.util.ArrayList;
import java.util.Scanner;
class Student {
 private int id;
 private String name;
 private String department;
 private int marks;
 Student(int id, String name, String department, int marks) {
 this.id = id;
 this.name = name;
 this.department = department;
 this.marks = marks;
 }
 int getId() {
 return id;
 }
 void update(String department, int marks) {
 this.department = department;
 this.marks = marks;
 }
 String getGrade() {
 if (marks >= 90)
 return "A+";
 else if (marks >= 80)
 return "A";
 else if (marks >= 70)
 return "B";
 else if (marks >= 60)
 return "C";
 else
 return "D";
 }
 void display() {
 System.out.println(
 id + "\t" + name + "\t" +
 department + "\t" + marks + "\t" +
 getGrade()
 );
 }
}
public class Main12{
 static ArrayList<Student> students = new ArrayList<>();
 static Scanner sc = new Scanner(System.in);
 static void addStudent() {
 System.out.print("Enter ID: ");
 int id = sc.nextInt();
 sc.nextLine();
 System.out.print("Enter Name: ");
 String name = sc.nextLine();
 System.out.print("Enter Department: ");
 String department = sc.nextLine();
 System.out.print("Enter Marks: ");
 int marks = sc.nextInt();
 students.add(new Student(id, name, department, marks));
 System.out.println("Student added successfully!");
 }
 static void viewStudents() {
 if (students.isEmpty()) {
 System.out.println("No students available.");
 return;
 }
 System.out.println("\nID\tName\tDepartment\tMarks\tGrade");
 System.out.println("---------------------------------------------");
 for (Student s : students) {
 s.display();
 }
 }
 static void searchStudent() {
 System.out.print("Enter Student ID: ");
 int id = sc.nextInt();
 for (Student s : students) {
 if (s.getId() == id) {
 System.out.println("\nID\tName\tDepartment\tMarks\tGrade");
 s.display();
 return;
 }
 }
 System.out.println("Student not found!");
 }
 static void updateStudent() {
 System.out.print("Enter Student ID: ");
 int id = sc.nextInt();
 for (Student s : students) {
 if (s.getId() == id) {
 sc.nextLine();
 System.out.print("Enter New Department: ");
 String department = sc.nextLine();
 System.out.print("Enter New Marks: ");
 int marks = sc.nextInt();
 s.update(department, marks);
 System.out.println("Student updated successfully!");
 return;
 }
 }
 System.out.println("Student not found!");
 }
 static void deleteStudent() {
 System.out.print("Enter Student ID: ");
 int id = sc.nextInt();
 for (Student s : students) {
 if (s.getId() == id) {
 students.remove(s);
 System.out.println("Student deleted successfully!");
 return;
 }
 }
 System.out.println("Student not found!");
 }
 public static void main(String[] args) {
 int choice;
 do {
 System.out.println("\n================================");
 System.out.println(" STUDENT MANAGEMENT SYSTEM");
 System.out.println("================================");
 System.out.println("1. Add Student");
 System.out.println("2. View Students");
 System.out.println("3. Search Student");
 System.out.println("4. Update Student");
 System.out.println("5. Delete Student");
 System.out.println("6. Exit");
 System.out.print("Enter your choice: ");
 choice = sc.nextInt();
 switch (choice) {
 case 1:
 addStudent();
 break;
 case 2:
 viewStudents();
 break;
 case 3:
 searchStudent();
 break;
 case 4:
 updateStudent();
 break;
 case 5:
 deleteStudent();
 break;
 case 6:
 System.out.println("Thank you!");
 break;
 default:
 System.out.println("Invalid choice!");
 }
 } while (choice != 6);
 sc.close();
 }
}