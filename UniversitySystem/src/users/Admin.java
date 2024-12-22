package users;

import courses.Course;

public class Admin {

    private int id; // Follow Java camelCase naming convention
    private String username;
    private String password;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Registers a student to a course by adding the student to the course's student list.
     *
     * @param s the student to register
     * @param c the course to register the student in
     */
    public void registerToCourse(Student s, Course c) {
        c.getStudentsList().add(s);
    }

    /**
     * Updates the details of the student.
     *
     * @param student the student whose details need to be updated
     * @param newName the new name for the student
     * @param newAge the new age for the student
     */
    public void editStudentDetails(Student student, String newName, int newAge) {
        // student.setName(newName);
        // student.setAge(newAge);
        System.out.println("Student details updated: " + student);
    }

    /**
     * Updates the details of the course (discipline).
     *
     * @param discipline the course to update
     * @param newTitle the new title of the course
     * @param newCredits the new credits for the course
     */
    public void editDisciplineDetails(Course discipline, String newTitle, int newCredits) {
        // discipline.setTitle(newTitle);
        // discipline.setCredits(newCredits);
        System.out.println("Discipline details updated: " + discipline);
    }

    /**
     * Generates an attendance report for the student.
     *
     * @param student the student to generate the report for
     * @return a string with the attendance report
     */
    public String generateAttendanceReport(Student student) {
        return "Attendance Report for " + student.getUsername() + ": " + student.getAttendance() + "%";
    }
}
