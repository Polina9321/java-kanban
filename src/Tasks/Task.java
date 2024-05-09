package Tasks;

import java.util.Objects;

public class Task {
    protected String nameTask;
    protected String contentTask;
    protected Status statusTask;
    protected int id;

    public Task(String nameTask, String contentTask, Status status) {
        this.nameTask = nameTask;
        this.contentTask = contentTask;
        statusTask = status;
    }

    public void setStatusTask(Status statusTask) {
        if (statusTask == Status.DONE || statusTask == Status.IN_PROGRESS || statusTask == Status.NEW) {
            System.out.println("Статус не найден.");
        } else {
            this.statusTask = statusTask;
        }
    }

    @Override
    public String toString() {
        String result = "ID - " + id;
        if (nameTask == null) {
            result += "";
        } else {
            result += "\nНазвание - " + nameTask;
        }
        if (contentTask == null) {
            result += "";
        } else {
            result += "\nСодержание - " + contentTask;
        }
        result += "\nСтатус - " + statusTask;
        return result;
    }

    public String getNameTask() {
        return nameTask;
    }

    public String getContentTask() {
        return contentTask;
    }

    public int getIdTask() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(nameTask, task.nameTask) && Objects.equals(contentTask, task.contentTask) && statusTask == task.statusTask;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameTask, contentTask, id, statusTask);
    }

    public Status getStatusTask() {
        return statusTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public void setContentTask(String contentTask) {
        this.contentTask = contentTask;
    }

    public void setId(int id) {
        this.id = id;
    }
}