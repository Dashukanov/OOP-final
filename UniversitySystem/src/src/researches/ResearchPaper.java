// Class: ResearchPaper
package researches;

import java.util.List;

/**
 * Класс, представляющий научную статью.
 */
public class ResearchPaper {
    private String title;          // Название статьи
    private String abstractText;   // Текст аннотации
    private List<String> authors;  // Список авторов статьи
    private int publishedDate;     // Дата публикации (в формате YYYY)
    private String journal;        // Журнал, в котором опубликована статья

    /**
     * Конструктор для создания научной статьи.
     *
     * @param title         Название статьи.
     * @param abstractText  Текст аннотации.
     * @param authors       Список авторов статьи.
     * @param publishedDate Год публикации.
     * @param journal       Название журнала.
     */
    public ResearchPaper(String title, String abstractText, List<String> authors, int publishedDate, String journal) {
        this.title = title;
        this.abstractText = abstractText;
        this.authors = authors;
        this.publishedDate = publishedDate;
        this.journal = journal;
    }

    /**
     * Добавляет новых авторов к списку существующих.
     *
     * @param newAuthors Список новых авторов для добавления.
     */
    public void addAuthors(List<String> newAuthors) {
        authors.addAll(newAuthors);
    }

    /**
     * Выводит информацию о публикации статьи.
     */
    public void publish() {
        System.out.println("Published in: " + journal + " on " + publishedDate);
    }
}
