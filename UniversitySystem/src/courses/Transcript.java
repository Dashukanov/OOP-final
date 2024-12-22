package courses;

import java.util.*;
import users.Student;

/**
 * Represents the student's transcript, containing the list of courses, credits, and marks.
 */
public class Transcript {
    private final Map<Course, Integer> courseCredits; 
    private final Map<Course, Mark> courseMarks;      
    private final Student student;                  

    /**
     * Constructs a new Transcript for the given student.
     *
     * @param student The student associated with this transcript.
     */
    public Transcript(Student student) {
        this.courseCredits = new HashMap<>();
        this.courseMarks = new HashMap<>();
        this.student = student;
    }

    /**
     * Gets the map of course marks.
     *
     * @return A map of courses and their corresponding marks.
     */
    public Map<Course, Mark> getCourseMarks() {
        return courseMarks;
    }

    /**
     * Prints a full transcript summary for the student, including course details, credits, grades, and GPA.
     */
    public void getTranscriptSummary() {
        System.out.println("Transcript for " + student.getName() + ":");
        if (courseMarks.isEmpty()) {
            System.out.println("No courses completed yet.");
            return;
        }

        double gpa = calculateGPA();
        System.out.printf("%-10s %-20s %-10s %-10s%n", "Course", "Title", "Credits", "Grade");
        for (Course course : courseMarks.keySet()) {
            Mark mark = courseMarks.get(course);
            int credits = courseCredits.getOrDefault(course, 0);

            System.out.printf("%-10s %-20s %-10d %-10s%n",
                    course.getCourseID(), course.getTitle(), credits, mark != null ? mark.getValue() : "Not Graded");
        }
        System.out.printf("Overall GPA: %.2f%n", gpa);
    }

    /**
     * Calculates the GPA for the student based on their course marks and credits.
     *
     * @return The GPA as a double value.
     */
    public double calculateGPA() {
        double totalGradePoints = 0.0;
        int totalCredits = 0;

        for (Course course : courseMarks.keySet()) {
            Mark mark = courseMarks.get(course);
            int credits = courseCredits.getOrDefault(course, 0);

            double gradePoint = mark != null ? convertMarkToGradePoint(mark.getValue()) : 0.0;

            totalGradePoints += gradePoint * credits;
            totalCredits += credits;
        }

        return totalCredits == 0 ? 0.0 : totalGradePoints / totalCredits;
    }

    /**
     * Converts a numeric mark to a 4.0 GPA scale grade point.
     *
     * @param mark The numeric mark (0–100).
     * @return Grade point on a 4.0 scale.
     */
    private double convertMarkToGradePoint(int mark) {
        if (mark >= 90) return 4.0;
        if (mark >= 80) return 3.0;
        if (mark >= 70) return 2.0;
        if (mark >= 60) return 1.0;
        return 0.0;
    }

    /**
     * Adds a course to the transcript with the given number of credits.
     *
     * @param course  The course to add.
     * @param credits The number of credits for the course.
     */
    public void addCourse(Course course, int credits) {
        courseCredits.put(course, credits);
    }

    /**
     * Sets the mark for a course.
     *
     * @param course The course for which the mark is set.
     * @param mark   The mark to assign.
     */
    public void setMark(Course course, Mark mark) {
        courseMarks.put(course, mark);
    }

    /**
     * Updates the transcript by setting the mark and adding credits for a specific course.
     *
     * @param course The course to update.
     * @param mark   The mark to update.
     */
    public void updateTranscript(Course course, Mark mark) {
        setMark(course, mark);
        addCourse(course, course.getCredits());
        System.out.println("Transcript updated for course: " + course.getTitle() + ", Mark: " + mark.getValue());
    }
}
