package tests;

import courses.Course;
import courses.Mark;
import users.*;

public class aidTest {

    public static void main(String[] args) {
        // Create Teachers
        Teacher elnara = new Teacher("123", "Elnara", "password", "Lector", "CS", "PhD", 18, "SITE");
        Teacher aibek = new Teacher("124", "Aibek", "password", "Lector", "CS", "MBE", 20, "SITE");

        // Create Courses
        Course OOP = new Course("CSCI1111", "OOP", 80, 4);
        Course PP1 = new Course("CSCI1122", "PP1", 90, 3);

        // Create Student and Manager
        Student aibar = new Student("aibar", "23B032222");
        Manager manager = new Manager();

        // Assign courses to teachers
        manager.addCourseToTeacher(OOP, elnara);
        manager.addCourseToTeacher(PP1, aibek);

        // Teacher manages courses
        elnara.manageCourses();
        aibek.manageCourses();

        // Student enrolls in a course
        aibar.enrollInCourse(OOP);

        // Teacher assigns marks to the student
        elnara.putMark(aibar, OOP, new Mark(90));
        elnara.putMark(aibar, OOP, new Mark(90));
        elnara.putMark(aibar, OOP, new Mark(94));

        // Student views their courses and marks
        aibar.viewCoursesWithMarks();
        aibar.printEnrolledCourses();

        // Student views their transcript summary
        aibar.viewTranscriptSummary();
        aibar.getTranscript().getTranscriptSummary();
    }
}
