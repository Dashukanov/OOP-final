package users;

import java.util.*;
import courses.Course;
import courses.Mark;
import courses.Transcript;

public class Manager extends Employee {
    private ManagerType type;
    private List<String> newsFeed;
    private Set<Complaint> reports;
    public List<Complaint> employeeRequests;
    private int activeProjects;

    /**
     * Default constructor initializes default values.
     */
    public Manager() {
        super();
        this.reports = new HashSet<>();
        this.employeeRequests = new ArrayList<>();
        this.activeProjects = 0;
        this.type = ManagerType.OFFICE_REGISTRATOR;
        this.newsFeed = new ArrayList<>();
    }

    /**
     * Generates a simple academic performance report for a list of students.
     *
     * @param students The list of students whose performance report will be generated.
     */
    public void generateSimplePerformanceReport(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students to generate the report.");
            return;
        }

        double totalGPA = 0.0;
        int totalStudents = 0;

        System.out.println("\n=== Academic Performance Report ===");

        for (Student student : students) {
            Transcript transcript = student.getTranscript();
            if (transcript != null) {
                double gpa = transcript.calculateGPA();
                totalGPA += gpa;
                totalStudents++;

                System.out.println("Student: " + student.getName());
                System.out.printf("GPA: %.2f%n", gpa);
                System.out.println("Courses:");
                for (Map.Entry<Course, Mark> entry : transcript.getCourseMarks().entrySet()) {
                    System.out.println("- " + entry.getKey().getTitle() + ": " + entry.getValue().getValue());
                }
                System.out.println();
            }
        }

        double averageGPA = totalStudents == 0 ? 0.0 : totalGPA / totalStudents;
        System.out.printf("Average GPA of all students: %.2f%n", averageGPA);
        System.out.println("====================================");
    }

    /**
     * Adds a course to a teacher's course list.
     *
     * @param course  The course to be added.
     * @param teacher The teacher to whom the course will be assigned.
     */
    public void addCourseToTeacher(Course course, Teacher teacher) {
        if (!teacher.getCourses().contains(course)) {
            teacher.getCourses().add(course);
            System.out.println("Course \"" + course.getTitle() + "\" has been added to teacher " + teacher.getName() + "'s list.");
        } else {
            System.out.println("Course \"" + course.getTitle() + "\" is already in the teacher's list.");
        }
    }

    /**
     * Removes a course from a teacher's course list.
     *
     * @param course  The course to be removed.
     * @param teacher The teacher from whom the course will be removed.
     */
    public void removeCourseFromTeacher(Course course, Teacher teacher) {
        if (teacher.getCourses().contains(course)) {
            teacher.getCourses().remove(course);
            System.out.println("Course \"" + course.getTitle() + "\" has been removed from teacher " + teacher.getName() + "'s list.");
        } else {
            System.out.println("Course \"" + course.getTitle() + "\" is not in the teacher's list.");
        }
    }

    /**
     * Retrieves and formats all the employee requests awaiting action.
     *
     * @return A formatted string of employee requests.
     */
    public String getRequests() {
        StringBuilder requestsString = new StringBuilder();

        for (Complaint complaint : employeeRequests) {
            requestsString.append(complaint.toString()).append("\n");
        }

        return requestsString.toString();
    }

    /**
     * Lists the student's marks as part of the report.
     *
     * @param student The student whose marks are to be listed.
     * @return A string representation of the student's marks.
     */
    public String reports(Student student) {
        return student.listOfMarks();
    }

    /**
     * Enrolls a student in a course.
     *
     * @param student The student to enroll.
     * @param course  The course to enroll the student in.
     */
    public void enrollStudentInCourse(Student student, Course course) {
        if (course.getStudentsList().contains(student)) {
            System.out.println("Student " + student.getName() + " is already enrolled in the course: " + course.getTitle());
            return;
        }

        if (course.getStudentsList().size() >= course.getLimit()) {
            System.out.println("Cannot enroll student " + student.getName() + " in the course: " + course.getTitle() + ". The course is full.");
            return;
        }

        course.getStudentsList().add(student);
        student.getCourses().put(course, new ArrayList<>());

        System.out.println("Student " + student.getName() + " successfully enrolled in the course: " + course.getTitle());
    }

    /**
     * Assigns a teacher to a course.
     *
     * @param course  The course to assign the teacher to.
     * @param teacher The teacher to assign to the course.
     */
    public void assignCourseToTeacher(Course course, Teacher teacher) {
        if (course.getInstructorsList().contains(teacher)) {
            System.out.println("Teacher " + teacher.getName() + " is already assigned to the course: " + course.getTitle());
        } else {
            course.assignTeacher(teacher);
            System.out.println("Teacher " + teacher.getName() + " successfully assigned to the course: " + course.getTitle());
        }
    }

    /**
     * Views students sorted alphabetically.
     *
     * @param students The list of students to sort.
     */
    public void viewStudentsAlphabetically(List<Student> students) {
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Students sorted alphabetically:");
        for (Student student : students) {
            System.out.printf("Name: %s, GPA: %.2f%n", student.getName(), student.getTranscript().calculateGPA());
        }
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", department='" + getDepartment() + '\'' +
                ", type=" + type +
                ", reports=" + reports +
                ", employeeRequests=" + employeeRequests +
                ", activeProjects=" + activeProjects +
                '}';
    }

    // Getters and Setters

    public ManagerType getType() {
        return type;
    }

    public void setType(ManagerType type) {
        this.type = type;
    }

    public Set<Complaint> getReports() {
        return reports;
    }

    public void setReports(Set<Complaint> reports) {
        this.reports = reports;
    }
}
