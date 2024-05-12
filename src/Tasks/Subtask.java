package Tasks;

import java.util.Objects;
public class Subtask extends Task {
    public int epicId;
    public Subtask(int epicId, String nameSubtask, String contentSubtask, Status status) {
        super(nameSubtask, contentSubtask, status);
        this.epicId = epicId;
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

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }
}
