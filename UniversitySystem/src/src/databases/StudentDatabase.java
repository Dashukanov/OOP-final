package databases;

import users.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton-класс для управления базой данных студентов.
 */
public class StudentDatabase {
    private static final String FILE_NAME = "students.txt"; // Файл для хранения данных о студентах
    private static StudentDatabase instance; // Экземпляр Singleton
    private List<Student> students; // Список студентов

    /**
     * Приватный конструктор для инициализации списка студентов и загрузки данных из файла.
     */
    private StudentDatabase() {
        students = new ArrayList<>();
        loadData(); // Загрузка данных из файла
    }

    /**
     * Возвращает единственный экземпляр класса (Singleton).
     *
     * @return Экземпляр StudentDatabase.
     */
    public static StudentDatabase getInstance() {
        if (instance == null) {
            synchronized (StudentDatabase.class) { // Блокировка для потокобезопасности
                if (instance == null) {
                    instance = new StudentDatabase();
                }
            }
        }
        return instance;
    }

    /**
     * Добавляет студента в базу данных и сохраняет изменения в файл.
     *
     * @param student Студент, которого нужно добавить.
     */
    public void addStudent(Student student) {
        students.add(student);
        saveData(); // Сохранение данных после добавления
    }

    /**
     * Возвращает список всех студентов из базы данных.
     *
     * @return Список студентов.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Загружает данные из файла в список студентов.
     * Если файл отсутствует или не удается его прочитать, выводится сообщение.
     */
    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject(); // Чтение списка студентов из файла
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found, starting fresh.");
        }
    }

    /**
     * Сохраняет текущий список студентов в файл.
     * В случае ошибки выводится стек-трейс.
     */
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students); // Запись списка студентов в файл
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
