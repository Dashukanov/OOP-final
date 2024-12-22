package users;

import java.time.Year;
import java.util.*;

import courses.*;

/**
 * The Student class represents a student in the system.
 * It includes details about the student's courses, marks, clubs, and more.
 */
public class Student extends User {

    private Set<String> clubs;
    private Map<String, Role> clubRoles;
    private Vector<Map<Mark, Course>> marks;
    private String major;
    private Transcript transcript;
    private Set<String> enrolledCourses;
    private boolean dormLiver;
    private boolean grant;
    private Map<String, Integer> grades; // Course -> Grade
    private HashMap<Course, List<Mark>> courses;

    /**
     * Constructs a new Student with the given name and ID.
     *
     * @param name The student's name.
     * @param id   The student's unique ID.
     */
    public Student(String name, String id) {
        super(name, id);
        this.marks = new Vector<>();
        this.clubs = new HashSet<>();
        this.clubRoles = new HashMap<>();
        this.enrolledCourses = new HashSet<>();
        this.courses = new HashMap<>();
        this.transcript = new Transcript(this);
    }

    /**
     * Default constructor for the Student class.
     */
    public Student() {
        super();
    }

    /**
     * Enrolls the student in a given course.
     * If the student is already enrolled or the course is full, an error message will be shown.
     *
     * @param course The course to enroll in.
     */
    public void enrollInCourse(Course course) {
        if (courses.containsKey(course)) {
            System.out.println(this.getName() + " is already enrolled in the course: " + course.getTitle());
            return;
        }

        if (course.getStudentsList().size() >= course.getLimit()) {
            System.out.println("Cannot enroll " + this.getName() + " in the course: " + course.getTitle() + ". The course is full.");
            return;
        }

        // Add the student to the course's student list
        course.getStudentsList().add(this);
        // Add the course to the student's course list with an empty list of marks
        this.courses.put(course, new ArrayList<>());
        System.out.println(this.getName() + " successfully enrolled in the course: " + course.getTitle());
    }

    /**
     * Displays all courses that the student is enrolled in along with their marks.
     */
    public void viewCoursesWithMarks() {
        System.out.println("Courses and Marks for " + this.getName() + ":");
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (Map.Entry<Course, List<Mark>> entry : courses.entrySet()) {
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

    /**
     * Retrieves the list of courses the student is enrolled in.
     *
     * @return A HashMap where the key is a Course and the value is a List of Marks.
     */
    public HashMap<Course, List<Mark>> getCourses() {
        return courses;
    }

    /**
     * Calculates the student's current study year based on their ID.
     *
     * @return The student's current study year.
     * @throws IllegalArgumentException if the ID format is invalid.
     */
    public int getStudyYear() {
        String idString = String.valueOf(id);
        if (idString.length() < 2) {
            throw new IllegalArgumentException("Invalid ID format");
        }

        try {
            int admissionYear = Integer.parseInt(idString.substring(0, 2)) + 2000;
            int currentYear = Year.now().getValue();
            return currentYear - admissionYear + 1;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID format must start with two digits representing the admission year");
        }
    }

    /**
     * Allows the student to join a club with a specified role.
     *
     * @param clubName      The name of the club to join.
     * @param role          The role in the club.
     * @param availableClubs A set of available clubs to join.
     */
    public void joinClub(String clubName, Role role, Set<String> availableClubs) {
        if (!availableClubs.contains(clubName)) {
            System.out.println("Club \"" + clubName + "\" does not exist.");
            return;
        }

        if (clubs.contains(clubName)) {
            System.out.println(this.getName() + " is already a member of \"" + clubName + "\".");
        } else {
            clubs.add(clubName);
            clubRoles.put(clubName, role);
            System.out.println(this.getName() + " has successfully joined the club \"" + clubName + "\" as " + role + ".");
        }
    }

    /**
     * Displays the roles the student holds in clubs.
     */
    public void viewClubRoles() {
        if (clubRoles.isEmpty()) {
            System.out.println(this.getName() + " has no roles in any clubs.");
        } else {
            System.out.println(this.getName() + " has the following roles in clubs:");
            for (Map.Entry<String, Role> entry : clubRoles.entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    /**
     * Updates the student's role in a specific club.
     *
     * @param clubName The name of the club.
     * @param newRole  The new role to assign.
     */
    public void updateRole(String clubName, Role newRole) {
        if (clubRoles.containsKey(clubName)) {
            clubRoles.put(clubName, newRole);
            System.out.println(this.getName() + "'s role in \"" + clubName + "\" has been updated to " + newRole + ".");
        } else {
            System.out.println("Student is not a member of \"" + clubName + "\".");
        }
    }

    /**
     * Prints the list of courses the student is enrolled in.
     */
    public void printEnrolledCourses() {
        if (courses.isEmpty()) {
            System.out.println(this.getName() + " is not enrolled in any courses.");
        } else {
            System.out.println(this.getName() + " is enrolled in the following courses:");
            for (Course course : courses.keySet()) {
                System.out.println("- " + course.getTitle() + " (ID: " + course.getCourseID() + ")");
            }
        }
    }

    /**
     * Retrieves the student's transcript.
     *
     * @return The student's transcript.
     */
    public Transcript getTranscript() {
        return this.transcript;
    }

    /**
     * Sets the student's transcript.
     *
     * @param transcript The transcript to set.
     */
    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    /**
     * Displays a summary of the student's transcript.
     */
    public void viewTranscriptSummary() {
        transcript.getTranscriptSummary();
    }

    /**
     * Rates a teacher with a rating between 1 and 5.
     *
     * @param teacherId The ID of the teacher to rate.
     * @param rating    The rating to give (1–5).
     */
    public void rateTeacher(String teacherId, int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Please provide a rating between 1 and 5.");
        } else {
            System.out.println("Teacher with ID " + teacherId + " has been rated " + rating + "/5.");
        }
    }

    /**
     * Gets the student's schedule (mock implementation).
     *
     * @return The student's schedule as a string.
     */
    public String getSchedule() {
        return "Schedule: [Monday: Math, Tuesday: Physics, Wednesday: Programming]";
    }

    // Getters and Setters

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Set<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(Set<String> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public boolean isDormLiver() {
        return dormLiver;
    }

    public void setDormLiver(boolean dormLiver) {
        this.dormLiver = dormLiver;
    }

    public boolean isGrant() {
        return grant;
    }

    public void setGrant(boolean grant) {
        this.grant = grant;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, Integer> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + getName() +
                ", id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", major='" + major + '\'' +
                ", dormLiver=" + dormLiver +
                ", grant=" + grant +
                ", enrolledCourses=" + enrolledCourses +
                '}';
    }

    public String getAttendance() {
        return null;
    }

    public String getUsername() {
        return null;
    }

    public Vector<Map<Mark, Course>> getMarks() {
        return marks;
    }

    public void setMarks(Vector<Map<Mark, Course>> marks) {
        this.marks = marks;
    }

    /**
     * Lists the student's marks for all enrolled courses.
     * 
     * @return A string representing the student's marks.
     */
    public String listOfMarks() {
        StringBuilder result = new StringBuilder();
        for (Map<Mark, Course> map : marks) {
            for (Map.Entry<Mark, Course> entry : map.entrySet()) {
                result.append(this.getName())
                      .append(" has ")
                      .append(entry.getKey().getValue()) // Assuming Mark has a `getValue()` method
                      .append(" in ")
                      .append(entry.getValue().getTitle()) // Assuming Course has a `getTitle()` method
                      .append("\n");
            }
        }
        return result.toString();
    }
}
