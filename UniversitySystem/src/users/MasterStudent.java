package users;

import researches.Researcher;

public class MasterStudent {
    private String researchTopic;
    private Researcher advisor;
    private boolean isResearcher;

    // Constructor to initialize the master student details
    public MasterStudent(String researchTopic, Researcher advisor, boolean isResearcher) {
        this.researchTopic = researchTopic;
        this.advisor = advisor;
        this.isResearcher = isResearcher;
    }

    // Method to conduct research on the topic
    public void conductResearch() {
        System.out.println("Conducting research on: " + researchTopic);
    }

    // Method to submit the thesis
    public void submitThesis() {
        System.out.println("Thesis submitted on: " + researchTopic);
    }

    // Method to publish research paper based on research
    public void publishPaper() {
        System.out.println("Publishing research paper on: " + researchTopic);
    }

    // Getters and Setters
    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    public Researcher getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Researcher advisor) {
        this.advisor = advisor;
    }

    public boolean isResearcher() {
        return isResearcher;
    }

    public void setResearcher(boolean researcher) {
        isResearcher = researcher;
    }

    @Override
    public String toString() {
        return "MasterStudent{" +
                "researchTopic='" + researchTopic + '\'' +
                ", advisor=" + (advisor != null ? advisor.toString() : "No Advisor") +
                ", isResearcher=" + isResearcher +
                '}';
    }
}
