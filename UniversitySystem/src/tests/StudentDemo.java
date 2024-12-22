package tests;

import java.util.*;
import courses.*;
import users.*;

public class StudentDemo {
    private final Scanner in = new Scanner(System.in);

    // Utility method to print list elements
    private void printList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ") " + list.get(i));
        }
    }

    // Show courses enrolled by the student along with marks
    private void viewCoursesWithMarks(Student student) {
        System.out.println("Courses and Marks for " + student.getName() + ":");
        if (student.getCourses().isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (Map.Entry<Course, List<Mark>> entry : student.getCourses().entrySet()) {
                Course course = entry.getKey();
                List<Mark> marks = entry.getValue();
                System.out.print("- Course: " + course.getTitle() + ", Marks: ");
                if (marks.isEmpty()) {
                    System.out.println("Not Graded");
                } else {
                    for (Mark mark : marks) {
                        System.out.print(mark.getValue() + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    // Enroll student in a selected course
    private void enrollInCourse(Student student, List<Course> availableCourses) {
        if (availableCourses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("Select a course to enroll in:");
        printList(availableCourses);
        int choice = in.nextInt() - 1;
        in.nextLine();  // Consume newline character after int input

        if (choice >= 0 && choice < availableCourses.size()) {
            Course selectedCourse = availableCourses.get(choice);
            student.enrollInCourse(selectedCourse);
            System.out.println("Successfully enrolled in " + selectedCourse.getTitle());
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // View student transcript summary
    private void viewTranscript(Student student) {
        student.viewTranscriptSummary();
    }

    // Rate a teacher
    private void rateTeacher(Student student, List<Teacher> teachers) {
        if (teachers.isEmpty()) {
            System.out.println("No teachers available to rate.");
            return;
        }
        System.out.println("Select a teacher to rate:");
        printList(teachers);
        int choice = in.nextInt() - 1;
        in.nextLine();  // Consume newline character after int input

        if (choice >= 0 && choice < teachers.size()) {
            Teacher selectedTeacher = teachers.get(choice);
            System.out.println("Enter rating (1–5):");
            int rating = in.nextInt();
            in.nextLine();  // Consume newline character after int input
            if (rating >= 1 && rating <= 5) {
                student.rateTeacher(selectedTeacher.getId(), rating);
                System.out.println("Successfully rated teacher " + selectedTeacher.getName() + " with rating " + rating);
            } else {
                System.out.println("Invalid rating. Please provide a rating between 1 and 5.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Main menu loop for demo
    public void runDemo(Student student, List<Course> availableCourses, List<Teacher> teachers) {
        System.out.println("Welcome, " + student.getName() + "!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1) Enroll in a course");
            System.out.println("2) View courses with marks");
            System.out.println("3) View transcript");
            System.out.println("4) Rate a teacher");
            System.out.println("5) Exit");

            int choice = in.nextInt();
            in.nextLine();  // Consume newline character after int input

            switch (choice) {
                case 1:
                    enrollInCourse(student, availableCourses);
                    break;
                case 2:
                    viewCoursesWithMarks(student);
                    break;
                case 3:
                    viewTranscript(student);
                    break;
                case 4:
                    rateTeacher(student, teachers);
                    break;
                case 5:
                    System.out.println("Goodbye, " + student.getName() + "!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Entry point
    public static void main(String[] args) {
        // Sample setup
        List<Course> availableCourses = new ArrayList<>();
        availableCourses.add(new Course("CSCI1111", "Object-Oriented Programming", 80, 4));
        availableCourses.add(new Course("CSCI2222", "Data Structures", 60, 3));

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("T001", "Elnara", "password", "Lector", "CS", "PhD", 18, "SITE"));
        teachers.add(new Teacher("T002", "Aibek", "password", "Lector", "CS", "MSc", 15, "SITE"));

        Student student = new Student("Aibar", "23В031420");

        StudentDemo demo = new StudentDemo();
        demo.runDemo(student, availableCourses, teachers);
    }
}
