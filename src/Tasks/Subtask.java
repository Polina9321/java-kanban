package Tasks;

import java.util.Objects;
public class Subtask extends Task {
    protected String nameSubtask;
    protected Status statusSubtask;
    protected String contentSubtask;

    public Subtask(String nameSubtask, String contentSubtask) {
        super("", "");
        this.nameSubtask = nameSubtask;
        this.contentSubtask = contentSubtask;
        statusSubtask = Status.NEW;
    }

    @Override
    public String toString() {
        String result = "";
        if (nameSubtask == null) { result += ""; }
        else { result += "\tНазвание - " + nameSubtask; }
        if (contentSubtask == null) { result += ""; }
        else { result += "\nСодержание - " + contentSubtask; }
        result += "\nСтатус - " + statusSubtask;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subtask subtask = (Subtask) o;
        return Objects.equals(nameSubtask, subtask.nameSubtask) &&
                statusSubtask == subtask.statusSubtask && Objects.equals(contentSubtask, subtask.contentSubtask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameSubtask, statusSubtask, contentSubtask);
    }

    public String getNameSubtask() {
        return nameSubtask;
    }

    public void setNameSubtask(String nameSubtask) {
        this.nameSubtask = nameSubtask;
    }

    public Status getStatusSubtask() {
        return statusSubtask;
    }

    public void setStatusSubtask(Status statusSubtask) {
        this.statusSubtask = statusSubtask;
    }

    public String getContentSubtask() {
        return contentSubtask;
    }

    public void setContentSubtask(String contentSubtask) {
        this.contentSubtask = contentSubtask;
    }
}
