package Tasks;

import java.util.ArrayList;
import java.util.Objects;
public class Epic extends Task {
    protected ArrayList<Subtask> subtaskArrayList = new ArrayList<>();


    public Epic(String nameEpic, String contentEpic, Status status) {
        super(nameEpic, contentEpic, status);
    }

    public void deleteSubtask(int... indexes) {
        for (int index : indexes) {
            if (id > 1) {
                id--;
            }
            subtaskArrayList.remove(index);
        }
    }

    public void deleteAllTasks() {
        subtaskArrayList.clear();
        System.out.println("Все задачи в списке удалены.");
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
                counter++;
            } else if (subtask.getStatusSubtask() == Status.IN_PROGRESS) {
                counter = -3;
                break;
            }
        }

        if (counter == subtaskArrayList.size()) {
            setStatusTask(Status.DONE);
        } else if (counter < 0) {
            setStatusTask(Status.IN_PROGRESS);
        }
    }
    @Override
    public String toString() {
        String result = "ID - " + id;
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
