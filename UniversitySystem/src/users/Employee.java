package users;

import staff.Message;
import java.util.*;

public class Employee extends User {

    private List<Message> messages;
    private static final long serialVersionUID = 1L;
    private String role;
    private String department;

    // Default constructor initializes default values
    public Employee() {
        super();
        this.role = "";
        this.department = "";
        this.messages = new ArrayList<>();
    }

    // Parameterized constructor to initialize with specific values
    public Employee(String id, String username, String password, String role, String department) {
        super(id, username, password);
        this.role = role;
        this.department = department;
        this.messages = new ArrayList<>();
    }

    // Method to send a message from this employee to another
    public void sendMessage(Employee recipient, Message message) {
        message.setSender(this);
        recipient.messages.add(message);
    }

    // Getters and setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Method to get all messages as a string
    public String getMessages() {
        StringBuilder result = new StringBuilder();
        for (Message message : this.messages) {
            result.append(message).append("\n"); // Add a newline for better readability
        }
        return result.toString();
    }

    // Override toString to provide a string representation of the Employee object
    @Override
    public String toString() {
        return "Employee{" +
               "id=" + getId() +
               ", username='" + getUsername() + '\'' +
               ", role='" + role + '\'' +
               ", department='" + department + '\'' +
               '}';
    }
}
