package tests;

import users.*;
import java.util.*;
import staff.*;
import courses.*;

public class coursesTest {

    public static void main(String[] args) {
        
        // Create Manager to handle course and student operations
        Manager manager = new Manager();

        // Create courses
        Course oop = new Course("CSCI1111", "Object-Oriented Programming", 80, 4);
        Course ds = new Course("CSCI2222", "Data Structures", 60, 3);
        Course algo = new Course("CSCI3333", "Algorithms", 70, 4);

        // Create teachers
        Teacher elnara = new Teacher("T001", "Elnara", "password", "Lector", "CS", "PhD", 18, "SITE");
        Teacher aibek = new Teacher("T002", "Aibek", "password", "Lector", "CS", "MSc", 15, "SITE");

        // Assign courses to teachers using the Manager
        manager.addCourseToTeacher(oop, elnara);
        manager.addCourseToTeacher(ds, aibek);
        manager.addCourseToTeacher(algo, elnara);

        // Create students
        Student aibar = new Student("Aibar", "23B031420");
        Student emir = new Student("Emir", "23B031195");
        Student dastan = new Student("Dastan", "22B030472");

        // Enroll students in courses
        manager.enrollStudentInCourse(aibar, oop);
        manager.enrollStudentInCourse(aibar, ds);
        manager.enrollStudentInCourse(emir, ds);
        manager.enrollStudentInCourse(emir, algo);
        manager.enrollStudentInCourse(dastan, oop);
        manager.enrollStudentInCourse(dastan, algo);

        // Teachers assign marks to students
        elnara.putMark(aibar, oop, new Mark(85));
        elnara.putMark(dastan, oop, new Mark(92));
        aibek.putMark(aibar, ds, new Mark(78));
        aibek.putMark(emir, ds, new Mark(88));
        elnara.putMark(emir, algo, new Mark(95));
        elnara.putMark(dastan, algo, new Mark(80));

        // Create a list of students for generating the performance report
        List<Student> students = Arrays.asList(aibar, emir, dastan);

        // Generate and display performance report
        manager.generateSimplePerformanceReport(students);

        // View students sorted alphabetically
        manager.viewStudentsAlphabetically(students);
    }
}
