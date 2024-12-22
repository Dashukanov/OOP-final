package users;

import java.io.Serializable;

public abstract class User implements Serializable {
    private String id; // Changed to private for better encapsulation
    private String name;
    private String username;
    private String password;

    /**
     * Default constructor initializes the ID to an empty string.
     */
    public User() {
        this.id = "";
        this.name = "";
        this.username = "";
        this.password = "";
    }

    /**
     * Constructor to initialize the user with name and id.
     *
     * @param name Name of the user.
     * @param id   Unique identifier for the user.
     */
    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.username = "";
        this.password = "";
    }

    /**
     * Constructor to initialize the user with id, username, and password.
     *
     * @param id       Unique identifier for the user.
     * @param username Username of the user.
     * @param password Password of the user.
     */
    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = ""; // Initialize name as empty string if not provided
    }

    /**
     * Simulates user login.
     *
     * @return A message indicating the user has logged in.
     */
    public String login() {
        return "User " + username + " logged in.";
    }

    /**
     * Simulates user logout.
     *
     * @return A message indicating the user has logged out.
     */
    public String logout() {
        return "User " + username + " logged out.";
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the User object.
     *
     * @return A string containing the user's details.
     */
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
