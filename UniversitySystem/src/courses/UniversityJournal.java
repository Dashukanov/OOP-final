package courses;

import java.util.*;
import users.Student;

public class UniversityJournal {
    private Set<String> disciplineList;
    private boolean isDataSaved;
    private Set<String> disciplineProfessors;
    private Set<Student> studentList;
    private Student student;

    /**
     * Конструктор для инициализации журнала университета.
     */
    public UniversityJournal() {
        this.disciplineList = new HashSet<>();
        this.disciplineProfessors = new HashSet<>();
        this.studentList = new HashSet<>();
        this.isDataSaved = false;
    }

    public Set<String> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(Set<String> disciplineList) {
        this.disciplineList = disciplineList;
    }

    public boolean isDataSaved() {
        return isDataSaved;
    }

    public void setDataSaved(boolean isDataSaved) {
        this.isDataSaved = isDataSaved;
    }

    public Set<String> getDisciplineProfessors() {
        return disciplineProfessors;
    }

    public void setDisciplineProfessors(Set<String> disciplineProfessors) {
        this.disciplineProfessors = disciplineProfessors;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Отмечает посещаемость студента.
     *
     * @param student студент, для которого отмечается посещаемость.
     * @return true, если студент найден в списке, иначе false.
     */
    public boolean markAttendance(Student student) {
        if (studentList.contains(student)) {
            System.out.println("Attendance marked for: " + student.getName());
            return true;
        }
        System.out.println("Student not found in the journal.");
        return false;
    }

    /**
     * Добавляет новую дисциплину в журнал.
     *
     * @param discipline название дисциплины.
     */
    public void addDiscipline(String discipline) {
        disciplineList.add(discipline);
        System.out.println("Discipline added: " + discipline);
    }

    /**
     * Удаляет дисциплину из журнала.
     *
     * @param discipline название дисциплины.
     */
    public void removeDiscipline(String discipline) {
        if (disciplineList.remove(discipline)) {
            System.out.println("Discipline removed: " + discipline);
        } else {
            System.out.println("Discipline not found: " + discipline);
        }
    }

    /**
     * Добавляет студента в журнал.
     *
     * @param student студент, которого нужно добавить.
     */
    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Student added: " + student.getName());
    }

    /**
     * Удаляет студента из журнала.
     *
     * @param student студент, которого нужно удалить.
     */
    public void removeStudent(Student student) {
        if (studentList.remove(student)) {
            System.out.println("Student removed: " + student.getName());
        } else {
            System.out.println("Student not found: " + student.getName());
        }
    }
}
