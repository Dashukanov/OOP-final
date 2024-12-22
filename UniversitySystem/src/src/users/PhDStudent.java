// Class: PhDStudent
package users;

import java.util.List;
import researches.*;

public class PhDStudent {
    private String phdThesisTopic;
    private Researcher supervisor;
    private List<ResearchPaper> publishedPapers;
    private int hIndex;

    // Constructor to initialize the PhD student details
    public PhDStudent(String phdThesisTopic, Researcher supervisor, List<ResearchPaper> publishedPapers, int hIndex) {
        this.phdThesisTopic = phdThesisTopic;
        this.supervisor = supervisor;
        this.publishedPapers = publishedPapers;
        this.hIndex = hIndex;
    }

    // Conducts research on the PhD thesis topic
    public void conductResearch() {
        System.out.println("Conducting PhD research on: " + phdThesisTopic);
    }

    // Publishes a research paper related to PhD work
    public void publishPaper() {
        System.out.println("Publishing PhD research paper.");
    }

    // Returns the current H-index of the PhD student
    public int calculateHIndex() {
        return hIndex;
    }

    // Getters and Setters
    public String getPhdThesisTopic() {
        return phdThesisTopic;
    }

    public void setPhdThesisTopic(String phdThesisTopic) {
        this.phdThesisTopic = phdThesisTopic;
    }

    public Researcher getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Researcher supervisor) {
        this.supervisor = supervisor;
    }

    public List<ResearchPaper> getPublishedPapers() {
        return publishedPapers;
    }

    public void setPublishedPapers(List<ResearchPaper> publishedPapers) {
        this.publishedPapers = publishedPapers;
    }

    public int getHIndex() {
        return hIndex;
    }

    public void setHIndex(int hIndex) {
        this.hIndex = hIndex;
    }

    @Override
    public String toString() {
        return "PhDStudent{" +
                "phdThesisTopic='" + phdThesisTopic + '\'' +
                ", supervisor=" + supervisor +
                ", hIndex=" + hIndex +
                '}';
    }
}
