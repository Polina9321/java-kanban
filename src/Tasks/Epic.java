package Tasks;

import java.util.ArrayList;
import java.util.Objects;
public class Epic extends Task {
    protected ArrayList<Subtask> subtaskArrayList = new ArrayList<>();
    public Epic(String nameEpic, String contentEpic) {
        super(nameEpic, contentEpic);
    }

    public ArrayList<Subtask> getSubtaskArrayList() {
        return subtaskArrayList;
    }
    public void addSubtask(Subtask subtask) {
        subtaskArrayList.add(subtask);
    }

    public void checkStatusSubtask() {
        int counter = 0;
        for (Subtask subtask : subtaskArrayList) {
            if (subtask.getStatusSubtask() == Status.DONE) {
                counter ++;
            }
        }

        if (counter == subtaskArrayList.size()) {
            setStatusTask(Status.DONE);
        } else if (counter > 0) {
            setStatusTask(Status.IN_PROGRESS);
        } else {
            setStatusTask(Status.NEW);
        }
    }
    @Override
    public String toString() {
        String result = "ID - " + idTask;
        if (nameTask == null) { result += ""; }
        else { result += "\nНазвание - " + nameTask; }
        if (contentTask == null) { result += ""; }
        else { result += "\nСодержание - " + contentTask; }

        result += "\nСтатус - " + statusTask;
        if (subtaskArrayList == null) { result += "\nПодзадач нет"; }
        else {
            result += "\nПодзадачи: ";
            for (int i = 0; i < subtaskArrayList.size(); i++) {
                result += "\n" + (i + 1) + subtaskArrayList.get(i);
            }
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Epic epic = (Epic) o;
        return Objects.equals(subtaskArrayList, epic.subtaskArrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subtaskArrayList);
    }
}
