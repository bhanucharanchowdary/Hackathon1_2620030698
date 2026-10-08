import java.util.Scanner;

class Student {
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    public Student(String studentName, String rollNumber, double marks,
                   String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    public double calculateFee() {
        return courseCredits * 1500.0;
    }

    public boolean checkEligibility() {
        return marks >= 50;
    }

    public double calculateScholarship() {
        double fee = calculateFee();

        if (marks >= 85) {
            return fee * 0.20;
        } else if (marks >= 70) {
            return fee * 0.10;
        }
        return 0.0;
    }

    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    public void displayDetails() {
        System.out.println("\nStudent and Course Details");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligible for Registration: " + checkEligibility());
        System.out.printf("Total Course Fee: Rs. %.2f%n", calculateFee());
        System.out.printf("Scholarship: Rs. %.2f%n", calculateScholarship());
        System.out.printf("Final Fee: Rs. %.2f%n", calculateFinalFee());
    }
}

public class StudentCourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume the remaining newline.

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter course credits: ");
        int courseCredits = scanner.nextInt();

        Student student = new Student(
                studentName, rollNumber, marks, courseName, courseCredits);

        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("The student is not eligible for course registration.");
        }

        scanner.close();
    }
}