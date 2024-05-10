package Tasks;

import java.util.Objects;
public class Subtask extends Task {

    public int subtaskId;
    public Subtask(String nameSubtask, String contentSubtask, Status status) {
        super(nameSubtask, contentSubtask, status);
    }

    @Override
    public String toString() {
        String result = "";
        if (nameTask == null) { result += ""; }
        else { result += "\tНазвание - " + nameTask; }
        if (contentTask == null) { result += ""; }
        else { result += "\nСодержание - " + contentTask; }
        result += "\nСтатус - " + statusTask;
        return result;
    }

    public int getSubtaskId() {
        return subtaskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subtask subtask = (Subtask) o;
        return Objects.equals(nameTask, subtask.nameTask) &&
                statusTask == subtask.statusTask && Objects.equals(contentTask, subtask.contentTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameTask, statusTask, contentTask);
    }

    public String getNameSubtask() {
        return nameTask;
    }

    public void setNameSubtask(String nameSubtask) {
        this.nameTask = nameSubtask;
    }

    public Status getStatusSubtask() {
        return statusTask;
    }

    public void setStatusSubtask(Status statusSubtask) {
        this.statusTask = statusSubtask;
    }

    public String getContentSubtask() {
        return contentTask;
    }

    public void setContentSubtask(String contentSubtask) {
        this.contentTask = contentSubtask;
    }

    public void setSubtaskId(int subtaskId) {
        this.subtaskId = subtaskId;
    }
}
