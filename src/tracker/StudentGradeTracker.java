package tracker;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentGradeTracker tracker = new StudentGradeTracker();
        tracker.run();
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Summary Report");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displaySummary();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        double grade;
        while (true) {
            System.out.print("Enter grade (0 - 100): ");
            grade = scanner.nextDouble();
            scanner.nextLine();
            if (grade >= 0 && grade <= 100) {
                break;
            } else {
                System.out.println("Invalid grade! Please enter between 0 and 100.");
            }
        }

        students.add(new Student(name, grade));
        System.out.println("Student added successfully!");
    }

    private void displaySummary() {
        if (students.isEmpty()) {
            System.out.println("No students in the record.");
            return;
        }

        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String highestName = "", lowestName = "";

        System.out.println("\n--- Student Grades ---");
        for (Student s : students) {
            System.out.println(s.getName() + " : " + s.getGrade());
            total += s.getGrade();

            if (s.getGrade() > highest) {
                highest = s.getGrade();
                highestName = s.getName();
            }
            if (s.getGrade() < lowest) {
                lowest = s.getGrade();
                lowestName = s.getName();
            }
        }

        double average = total / students.size();

        System.out.println("\n--- Summary of Student Details---");
        System.out.println("Average Score: " + average);
        System.out.println("Highest Score: " + highest + " (" + highestName + ")");
        System.out.println("Lowest Score: " + lowest + " (" + lowestName + ")");
    }
}
