package staff;

import users.Employee;

/**
 * Class representing a message.
 */
public class Message {

    private Integer id;               // Unique identifier of the message
    private Employee sender;          // The sender of the message
    private String messageContent;    // The content of the message
    private boolean isRead;           // Read status of the message
    private boolean isArchived;       // Archive status of the message

    /**
     * Constructor to create a new message.
     *
     * @param id             Unique identifier of the message.
     * @param messageContent The text content of the message.
     */
    public Message(Integer id, String messageContent) {
        this.id = id;
        this.messageContent = messageContent;
        this.isRead = false;          // By default, the message is unread
        this.isArchived = false;      // By default, the message is not archived
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getSender() {
        return sender;
    }

    public void setSender(Employee sender) {
        this.sender = sender;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public boolean isRead() {
        return isRead;
    }

    public boolean isArchived() {
        return isArchived;
    }

    // Operations

    /**
     * Marks the message as read.
     */
    public void markAsRead() {
        if (!isRead) {
            isRead = true;
            System.out.println("Message marked as read.");
        } else {
            System.out.println("Message is already marked as read.");
        }
    }

    /**
     * Marks the message as unread.
     */
    public void markAsUnread() {
        if (isRead) {
            isRead = false;
            System.out.println("Message marked as unread.");
        } else {
            System.out.println("Message is already marked as unread.");
        }
    }

    /**
     * Archives the message.
     */
    public void archiveMessage() {
        if (!isArchived) {
            isArchived = true;
            System.out.println("Message archived.");
        } else {
            System.out.println("Message is already archived.");
        }
    }

    /**
     * Restores the message from the archive.
     */
    public void restoreFromArchive() {
        if (isArchived) {
            isArchived = false;
            System.out.println("Message restored from archive.");
        } else {
            System.out.println("Message is not archived.");
        }
    }

    /**
     * Returns detailed information about the message.
     *
     * @return A string with message details.
     */
    public String getMessageDetails() {
        return "Message Details:\n" +
                "ID: " + id + "\n" +
                "Sender: " + (sender != null ? sender.getName() : "Not specified") + "\n" +
                "Content: " + messageContent + "\n" +
                "Status: " + (isRead ? "Read" : "Unread") + "\n" +
                "Archived: " + (isArchived ? "Yes" : "No");
    }

    /**
     * Returns a string representation of the Message object.
     *
     * @return A string with the message data.
     */
    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + (sender != null ? sender.getName() : "Not specified") +
                ", messageContent='" + messageContent + '\'' +
                ", isRead=" + isRead +
                ", isArchived=" + isArchived +
                '}';
    }
}
