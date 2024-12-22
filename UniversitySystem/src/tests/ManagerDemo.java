package tests;

import java.util.*;
import courses.*;
import users.*;

public class ManagerDemo {
    private final Scanner in = new Scanner(System.in);

    // Utility method to print list elements
    private void printList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ") " + list.get(i));
        }
    }

    // Show list of students, returns false if no students
    public boolean showStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available. Try adding one.");
            return false;
        }
        printList(students);
        return true;
    }

    // Show list of courses, returns false if no courses
    public boolean showCourses(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("No courses available. Try adding one.");
            return false;
        }
        printList(courses);
        return true;
    }

    // Add new student
    private void addStudent(List<Student> students) {
        System.out.print("Enter the name of the student: ");
        String name = in.nextLine();
        System.out.print("Enter the ID of the student: ");
        String id = in.nextLine();
        students.add(new Student(name, id));
        System.out.println("Student added successfully.");
    }

    // Add new course
    private void addCourse(List<Course> courses) {
        System.out.print("Enter the name of the course: ");
        String title = in.nextLine();
        System.out.print("Enter the course ID: ");
        String courseID = in.nextLine();
        System.out.print("Enter the course limit: ");
        int limit = in.nextInt();
        System.out.print("Enter the number of credits: ");
        int credits = in.nextInt();
        in.nextLine();  // Consume the newline character
        courses.add(new Course(courseID, title, limit, credits));
        System.out.println("Course added successfully.");
    }

    // Enroll student in a course
    private void enrollStudentInCourse(List<Student> students, List<Course> courses) {
        if (!showStudents(students)) return;
        System.out.print("Choose a student (enter number): ");
        int studentIndex = in.nextInt() - 1;
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student selection.");
            return;
        }
        Student student = students.get(studentIndex);

        if (!showCourses(courses)) return;
        System.out.print("Choose a course (enter number): ");
        int courseIndex = in.nextInt() - 1;
        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course selection.");
            return;
        }
        Course course = courses.get(courseIndex);

        // Enroll student in course if not already enrolled
        if (!student.getCourses().containsKey(course)) {
            student.getCourses().put(course, new ArrayList<>());
            course.getStudentsList().add(student);
            System.out.println("Student " + student.getName() + " successfully enrolled in " + course.getTitle());
        } else {
            System.out.println("Student is already enrolled in this course.");
        }
    }

    // View details of a student
    private void viewStudentDetails(List<Student> students) {
        if (!showStudents(students)) return;
        System.out.print("Choose a student to view details (enter number): ");
        int studentIndex = in.nextInt() - 1;
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student selection.");
            return;
        }
        Student student = students.get(studentIndex);

        // Print student details
        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getId());
        System.out.println("Courses enrolled:");
        student.getCourses().forEach((course, marks) -> {
            System.out.println("- " + course.getTitle());
        });
    }

    // Main menu loop
    public void run() {
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        System.out.println("Welcome to the Manager System!");
        while (true) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1) Add student");
            System.out.println("2) Add course");
            System.out.println("3) Enroll student in a course");
            System.out.println("4) View student details");
            System.out.println("5) Show all students");
            System.out.println("6) Show all courses");
            System.out.println("7) Exit");

            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            in.nextLine();  // Consume the newline character after an integer input

            switch (choice) {
                case 1 -> addStudent(students);
                case 2 -> addCourse(courses);
                case 3 -> enrollStudentInCourse(students, courses);
                case 4 -> viewStudentDetails(students);
                case 5 -> showStudents(students);
                case 6 -> showCourses(courses);
                case 7 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Entry point
    public static void main(String[] args) {
        ManagerDemo demo = new ManagerDemo();
        demo.run();
    }
}
