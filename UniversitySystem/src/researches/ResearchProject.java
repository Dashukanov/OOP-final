package researches;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий исследовательский проект.
 */
public class ResearchProject {

    private String projectTitle;        // Название проекта
    private String projectDescription; // Описание проекта
    private String projectLeader;      // Руководитель проекта
    private List<String> teamMembers;  // Список участников команды
    private Researcher researcher;     // Ведущий исследователь

    /**
     * Конструктор для создания исследовательского проекта.
     *
     * @param projectTitle       Название проекта.
     * @param projectDescription Описание проекта.
     * @param projectLeader      Имя руководителя проекта.
     * @param researcher         Ведущий исследователь.
     */
    public ResearchProject(String projectTitle, String projectDescription, String projectLeader, Researcher researcher) {
        this.projectTitle = projectTitle;
        this.projectDescription = projectDescription;
        this.projectLeader = projectLeader;
        this.teamMembers = new ArrayList<>();
        this.researcher = researcher;
    }

    // Getters and Setters

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }

    public List<String> getTeamMembers() {
        return teamMembers;
    }

    public Researcher getResearcher() {
        return researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }

    // Operations

    /**
     * Добавляет участника команды в проект.
     *
     * @param member Имя участника для добавления.
     */
    public void addTeamMember(String member) {
        if (!teamMembers.contains(member)) {
            teamMembers.add(member);
            System.out.println("Участник добавлен: " + member);
        } else {
            System.out.println("Участник уже существует: " + member);
        }
    }

    /**
     * Удаляет участника команды из проекта.
     *
     * @param member Имя участника для удаления.
     */
    public void removeTeamMember(String member) {
        if (teamMembers.contains(member)) {
            teamMembers.remove(member);
            System.out.println("Участник удалён: " + member);
        } else {
            System.out.println("Участник не найден: " + member);
        }
    }

    /**
     * Возвращает подробности исследовательского проекта.
     *
     * @return Строка с информацией о проекте.
     */
    public String getProjectDetails() {
        return "Детали исследовательского проекта:\n" +
                "Название: " + projectTitle + "\n" +
                "Описание: " + projectDescription + "\n" +
                "Руководитель: " + projectLeader + "\n" +
                "Участники команды: " + (teamMembers.isEmpty() ? "Нет участников" : String.join(", ", teamMembers)) + "\n" +
                "Исследователь: " + (researcher != null ? researcher.getName() : "Не назначен");
    }
}
