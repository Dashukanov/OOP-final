package staff;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Class representing a news article.
 */
public class News {

    private String newsTitle;            // The title of the news
    private String newsContent;          // The content of the news
    private LocalDateTime creationDate;  // The creation date of the news
    private String category;             // The category of the news
    private boolean isPublished;         // Indicates whether the news is published or not
    private static final Set<News> newsList = new HashSet<>(); // A static set to hold all published news

    /**
     * Constructor to create a news article.
     *
     * @param newsTitle   The title of the news.
     * @param newsContent The content of the news.
     * @param category    The category under which the news falls.
     */
    public News(String newsTitle, String newsContent, String category) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.creationDate = LocalDateTime.now();  // Set the creation date to the current date and time
        this.category = category;
        this.isPublished = false;  // Initially, the news is not published
    }

    // Getters and setters

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public static Set<News> getNewsList() {
        return newsList;
    }

    // Operations

    /**
     * Publishes the news article.
     * If the news is not already published, it will be added to the list of published news.
     */
    public void publish() {
        if (!isPublished) {
            isPublished = true;
            newsList.add(this);  // Add to the published news list
            System.out.println("News published: " + newsTitle);
        } else {
            System.out.println("News is already published.");
        }
    }

    /**
     * Unpublishes the news article.
     * Removes the news from the list of published news if it was previously published.
     */
    public void unpublish() {
        if (isPublished) {
            isPublished = false;
            newsList.remove(this);  // Remove from the published news list
            System.out.println("News unpublished: " + newsTitle);
        } else {
            System.out.println("News is not published.");
        }
    }

    /**
     * Updates the content of the news article.
     *
     * @param newContent The new content to replace the old one.
     */
    public void updateContent(String newContent) {
        this.newsContent = newContent;
        System.out.println("News content updated.");
    }

    /**
     * Updates the title of the news article.
     *
     * @param newTitle The new title for the news article.
     */
    public void updateTitle(String newTitle) {
        this.newsTitle = newTitle;
        System.out.println("News title updated.");
    }

    /**
     * Updates the category of the news article.
     *
     * @param newCategory The new category for the news article.
     */
    public void updateCategory(String newCategory) {
        this.category = newCategory;
        System.out.println("News category updated.");
    }

    /**
     * Returns the details of the news article in a formatted string.
     *
     * @return A string representing the details of the news article.
     */
    public String getNewsDetails() {
        return "News Details:\n" +
                "Title: " + newsTitle + "\n" +
                "Content: " + newsContent + "\n" +
                "Category: " + category + "\n" +
                "Creation Date: " + creationDate + "\n" +
                "Published: " + (isPublished ? "Yes" : "No");
    }
}
