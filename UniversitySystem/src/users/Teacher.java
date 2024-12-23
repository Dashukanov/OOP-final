package users;

import courses.*;
import java.util.*;

/**
 * Represents a Teacher, which extends the Employee class. The Teacher class handles
 * the management of courses, assigning marks to students, and generating reports for attendance.
 */
public class Teacher extends Employee {

    // Instance variables
    private String degree;
    private int officeHours;
    private Map<Course, Mark> courseMarks = new HashMap<>();
    private List<Course> courses; // List of courses managed by the teacher
    private String faculty;

    /**
     * Default constructor. Initializes a teacher with default values.
     */
    public Teacher() {
        super();
        this.courses = new ArrayList<>();
        this.degree = "None";
        this.officeHours = 0;
        this.faculty = "Unknown";
    }

    /**
     * Constructor with parameters to initialize the teacher with specific values.
     *
     * @param id The ID of the teacher.
     * @param username The username of the teacher.
     * @param password The password of the teacher.
     * @param role The role of the teacher.
     * @param department The department where the teacher works.
     * @param degree The degree of the teacher.
     * @param officeHours The office hours of the teacher.
     * @param faculty The faculty the teacher belongs to.
     */
    public Teacher(String id, String username, String password, String role, String department, String degree, int officeHours, String faculty) {
        super(id, username, password, role, department);
        this.courses = new ArrayList<>();
        this.degree = degree;
        this.officeHours = officeHours;
        this.faculty = faculty;
        this.setName(username);
    }

    /**
     * Displays the list of courses managed by the teacher.
     * If no courses are assigned, it prints a message indicating so.
     */
    public void manageCourses() {
        System.out.println("Courses managed by " + getUsername() + ":");
        if (courses.isEmpty()) {
            System.out.println("No courses assigned yet.");
        } else {
            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                System.out.println((i + 1) + ". " + course.getTitle() + " (ID: " + course.getCourseID() + ")");
            }
        }
    }

    /**
     * Assigns a mark to a student for a specific course.
     * The student must be enrolled in the course to receive a mark.
     *
     * @param student The student to assign the mark to.
     * @param course The course where the student is enrolled.
     * @param mark The mark to assign to the student.
     * @return true if the mark was successfully assigned, false otherwise.
     */
    public boolean putMark(Student student, Course course, Mark mark) {
        if (!student.getCourses().containsKey(course)) {
            System.out.println("Student " + student.getName() + " is not enrolled in the course: " + course.getTitle());
            return false;
        }
        student.getCourses().get(course).add(mark);
        
        if (student.getTranscript() == null) {
            student.setTranscript(new Transcript(student));
        }
        student.getTranscript().updateTranscript(course, mark);
        System.out.println("Mark " + mark.getValue() + " for " + student.getName() + " in course " + course.getTitle() + " successfully assigned.");
        return true;
    }

    /**
     * Prints a mock attendance report for a specific course.
     *
     * @param courseName The name of the course for which the attendance is checked.
     */
    public void checkAttendance(String courseName) {
        System.out.println("Attendance report for course \"" + courseName + "\":");
        System.out.println("Aibar: Present");
        System.out.println("Emir: Absent");
        System.out.println("Dastan: Present");
    }

    /**
     * Sends a complaint to the administration.
     *
     * @param student The student who is sending the complaint.
     * @param manager The manager who will handle the complaint.
     * @param urgency The urgency level of the complaint.
     * @param title The title of the complaint.
     */
    public void sendComplaint(Student student, Manager manager, Urgency urgency, String title) {
        manager.employeeRequests.add(new Complaint(title, urgency));
    }

    // Getters and Setters

    /**
     * Gets the list of courses managed by the teacher.
     *
     * @return The list of courses managed by the teacher.
     */
    public List<Course> getCourses() {
        return new ArrayList<>(courses); // Avoid exposing the internal list directly
    }

    /**
     * Sets the list of courses managed by the teacher.
     *
     * @param courses The new list of courses.
     */
    public void setCourses(List<Course> courses) {
        if (courses != null) {
            this.courses = new ArrayList<>(courses); // Defensive copy
        }
    }

    /**
     * Gets the degree of the teacher.
     *
     * @return The degree of the teacher.
     */
    public String getDegree() {
        return degree;
    }

    /**
     * Sets the degree of the teacher.
     *
     * @param degree The degree to set.
     */
    public void setDegree(String degree) {
        this.degree = degree;
    }

    /**
     * Gets the office hours of the teacher.
     *
     * @return The office hours of the teacher.
     */
    public int getOfficeHours() {
        return officeHours;
    }

    /**
     * Sets the office hours of the teacher.
     *
     * @param officeHours The office hours to set.
     */
    public void setOfficeHours(int officeHours) {
        this.officeHours = officeHours;
    }

    /**
     * Gets the faculty of the teacher.
     *
     * @return The faculty of the teacher.
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * Sets the faculty of the teacher.
     *
     * @param faculty The faculty to set.
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * Returns a string representation of the Teacher object.
     *
     * @return A string containing the teacher's details.
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", degree='" + degree + '\'' +
                ", officeHours=" + officeHours +
                ", faculty='" + faculty + '\'' +
                ", courses=" + courses +
                '}';
    }
}
