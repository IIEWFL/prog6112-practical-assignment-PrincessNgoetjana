/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagementApp;

/**
 *
 * @author lab_services_student
 */
public class java {
    
}
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementApp {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagementApp() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String choice = scanner.nextLine();
            if (!choice.equals("1")) {
                System.out.println("Exiting application...");
                break;
            }

            displayMenu();
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    captureStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    printStudentReport();
                    break;
                case 5:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new student.");
        System.out.println("(2) Search for a student.");
        System.out.println("(3) Delete a student.");
        System.out.println("(4) Print student report.");
        System.out.println("(5) Exit Application.");
    }

    private void captureStudent() {
        System.out.println("CAPTURE A NEW STUDENT");
        Student student = new Student();

        System.out.print("Enter the student id: ");
        student.setId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter the student name: ");
        student.setName(scanner.nextLine());

        while (true) {
            System.out.print("Enter the student age: ");
            int age = Integer.parseInt(scanner.nextLine());
            if (age >= 16) {
                student.setAge(age);
                break;
            } else {
                System.out.println("You have entered an incorrect student age!!! Please re-enter the student age.");
            }
        }

        System.out.print("Enter the student email: ");
        student.setEmail(scanner.nextLine());

        System.out.print("Enter the student course: ");
        student.setCourse(scanner.nextLine());

        students.add(student);
        System.out.println("Student details have been successfully saved.");
    }

    private void searchStudent() {
        System.out.print("Enter the student id to search: ");
        int searchId = Integer.parseInt(scanner.nextLine());

        for (Student student : students) {
            if (student.getId() == searchId) {
                System.out.println("STUDENT ID: " + student.getId());
                System.out.println("STUDENT NAME: " + student.getName());
                System.out.println("STUDENT AGE: " + student.getAge());
                System.out.println("STUDENT EMAIL: " + student.getEmail());
                System.out.println("STUDENT COURSE: " + student.getCourse());
                return;
            }
        }

        System.out.println("Student with Student Id: " + searchId + " was not found!");
    }

    private void deleteStudent() {
        System.out.print("Enter the student id to delete: ");
        int deleteId = Integer.parseInt(scanner.nextLine());

        for (Student student : students) {
            if (student.getId() == deleteId) {
                System.out.print("Are you sure you want to delete student " + student.getId() + "? (y/n): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("y")) {
                    students.remove(student);
                    System.out.println("Student with Student Id: " + deleteId + " was deleted!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                return;
            }
        }

        System.out.println("Student with Student Id: " + deleteId + " was not found!");
    }

    private void printStudentReport() {
        int count = 1;
        for (Student student : students) {
            System.out.println("STUDENT " + count);
            System.out.println("STUDENT ID: " + student.getId());
            System.out.println("STUDENT NAME: " + student.getName());
            System.out.println("STUDENT AGE: " + student.getAge());
            System.out.println("STUDENT EMAIL: " + student.getEmail());
            System.out.println("STUDENT COURSE: " + student.getCourse());
            count++;
        }
    }

    public static void main(String[] args) {
        StudentManagementApp app = new StudentManagementApp();
        app.run();
    }
}