package courses;

import java.util.*;
import users.Student;

public class Lesson {
    private Course course;
    private Time time;
    private LessonType type;
    private Set<Student> students;
    private int room;

    public Lesson() {
        this.students = new HashSet<>();
    }

    public Lesson(Course course, Time time, LessonType type, int room) {
        this.course = course;
        this.time = time;
        this.type = type;
        this.room = room;
        this.students = new HashSet<>();
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public LessonType getType() {
        return type;
    }

    public void setType(LessonType type) {
        this.type = type;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students != null ? students : new HashSet<>();
    }

    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        String studentNames = students.stream()
                .map(Student::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("No students");

        return "Lesson [Course: " + (course != null ? course.getTitle() : "None") + 
               ", Time: " + time + 
               ", Type: " + type + 
               ", Room: " + room + 
               ", Students: " + studentNames + "]";
    }
}
