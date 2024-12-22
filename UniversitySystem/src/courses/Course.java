package courses;

import users.*;
import java.util.*;

public class Course {
    private Faculty faculty;
    private String courseID;
    private String title;
    private Set<Student> studentsList;
    private List<Teacher> instructorsList;
    private Set<Lesson> schedule;
    private Lesson lesson;
    private Mark mark;
    private int limit;
    private int credits;

    public Course(String courseID, String title, int limit, int credits) {
        this.courseID = courseID;
        this.title = title;
        this.limit = limit;
        this.credits = credits;
        this.instructorsList = new ArrayList<>();
        this.studentsList = new HashSet<>();
        this.schedule = new HashSet<>();
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getTitle() {
        return title;
    }

    public Set<Student> getStudentsList() {
        return studentsList;
    }

    public List<Teacher> getInstructorsList() {
        return instructorsList;
    }

    public Set<Lesson> getSchedule() {
        return schedule;
    }

    public void assignTeacher(Teacher teacher) {
        if (instructorsList.contains(teacher)) {
            System.out.println("Teacher " + teacher.getName() + " is already assigned to the course " + title);
        } else {
            instructorsList.add(teacher);
            System.out.println("Teacher " + teacher.getName() + " assigned to the course " + title);
        }
    }

    public void registerToCourse(Student student) {
        if (studentsList.size() >= limit) {
            System.out.println("Cannot register student " + student.getName() + ". The course is full.");
        } else {
            studentsList.add(student);
            System.out.println("Student " + student.getName() + " successfully registered for the course " + title + ".");
        }
    }

    public void registerToCourse(Student[] students) {
        for (Student student : students) {
            registerToCourse(student);
        }
    }

    @Override
    public String toString() {
        String studentNames = studentsList.stream()
                .map(Student::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("No students");

        return courseID + " " + title + " [Students: " + studentNames + "] " + instructorsList;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
