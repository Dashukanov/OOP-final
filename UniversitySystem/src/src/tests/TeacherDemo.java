package tests;

import courses.*;
import users.*;
import java.util.*;

public class TeacherDemo {

    private final Scanner in = new Scanner(System.in);

    // Method to display a list of courses or students
    private void displayList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ") " + list.get(i));
        }
    }

    // Assign a course to the teacher if not already assigned
    private void assignCourseToTeacher(Teacher teacher, Course course) {
        if (!teacher.getCourses().contains(course)) {
            teacher.getCourses().add(course);
            System.out.println("Course " + course.getTitle() + " has been assigned to teacher " + teacher.getName());
        } else {
            System.out.println("Teacher " + teacher.getName() + " is already managing the course: " + course.getTitle());
        }
    }

    // Add a mark to a student for a specific course
    private void addMarkToStudent(Teacher teacher, Student student, Course course) {
        System.out.print("Enter mark for student " + student.getName() + " in course " + course.getTitle() + ": ");
        int markValue = in.nextInt();
        Mark mark = new Mark(markValue);
        boolean success = teacher.putMark(student, course, mark);
        if (!success) {
            System.out.println("Failed to assign mark.");
        }
    }

    // Display the courses managed by the teacher
    private void viewTeacherCourses(Teacher teacher) {
        teacher.manageCourses();
    }

    // Main menu for the teacher
    private void teacherMenu(Teacher teacher, List<Course> courses, List<Student> students) {
        while (true) {
            System.out.println("\n=== Teacher Menu ===");
            System.out.println("1) Assign a course to teacher");
            System.out.println("2) View teacher's courses");
            System.out.println("3) Add mark to student");
            System.out.println("4) Exit");
            System.out.print("Enter your choice: ");

            int choice = in.nextInt();
            in.nextLine();  // Consume the newline left by nextInt()

            switch (choice) {
                case 1:
                    System.out.println("Select a course to assign:");
                    displayList(courses);
                    int courseChoice = in.nextInt() - 1;
                    in.nextLine();  // Consume the newline
                    if (courseChoice >= 0 && courseChoice < courses.size()) {
                        assignCourseToTeacher(teacher, courses.get(courseChoice));
                    } else {
                        System.out.println("Invalid course selection.");
                    }
                    break;

                case 2:
                    viewTeacherCourses(teacher);
                    break;

                case 3:
                    System.out.println("Select a student:");
                    displayList(students);
                    int studentChoice = in.nextInt() - 1;
                    in.nextLine();  // Consume the newline
                    if (studentChoice >= 0 && studentChoice < students.size()) {
                        Student student = students.get(studentChoice);
                        System.out.println("Select a course:");
                        displayList(teacher.getCourses());
                        int courseIndex = in.nextInt() - 1;
                        in.nextLine();  // Consume the newline
                        if (courseIndex >= 0 && courseIndex < teacher.getCourses().size()) {
                            Course course = teacher.getCourses().get(courseIndex);
                            addMarkToStudent(teacher, student, course);
                        } else {
                            System.out.println("Invalid course selection.");
                        }
                    } else {
                        System.out.println("Invalid student selection.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Teacher Menu...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Method to start the demo
    public void run() {
        // Sample data
        Teacher teacher = new Teacher("T001", "Elnara", "password", "Lector", "CS", "PhD", 18, "SITE");
        List<Course> courses = Arrays.asList(
            new Course("CS101", "Introduction to CS", 100, 4),
            new Course("CS102", "Algorithms", 50, 3),
            new Course("CS103", "Data Structures", 60, 3)
        );
        List<Student> students = Arrays.asList(
            new Student("Aibar", "23В031420"),
            new Student("Emir", "23B031195"),
            new Student("Dastan", "22B030472")
        );

        // Start teacher menu
        teacherMenu(teacher, courses, students);
    }

    // Main entry point
    public static void main(String[] args) {
        TeacherDemo demo = new TeacherDemo();
        demo.run();
    }
}
