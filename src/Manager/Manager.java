package Manager;

import Tasks.*;

import java.util.HashMap;
import java.util.ArrayList;

public class Manager {
    protected int id = 1;
    public HashMap<Integer, Task> taskHashMap = new HashMap<>();

    public void addTask(Task o) {
        if (!taskHashMap.containsValue(o)) {
            while (taskHashMap.containsKey(id)) {
                id++;
            }
            taskHashMap.put(id, o);
        }
    }

    public void addTask(Epic epic, Subtask... subtasks) {
        for (Subtask subtask : subtasks) {
            if (!epic.getSubtaskArrayList().contains(subtask)) {
                epic.addSubtask(subtask);
            }
        }
    }

    public ArrayList<Task> getTaskArrayList() {
        return new ArrayList<>(taskHashMap.values());
    }

    public void deleteTasks() {
        taskHashMap.clear();
        System.out.println("Все задачи в списке удалены.");
    }

    public void deleteTastById(int... indexes) {
        for (int index : indexes) {
            if (id > 1) {
                id--;
            }
            taskHashMap.remove(index);
        }
    }

    public Task getTask(int index) {
        return taskHashMap.get(index);
    }

    public ArrayList<Subtask> getEpicSubtasks(Epic epic) {
        return new ArrayList<>(epic.getSubtaskArrayList());
    }

    public  void updateTask(int index, Task task) {
        deleteTastById(index);
        taskHashMap.put(index, task);
    }

    public Task updateInfo(Task task, String nameOrContent, String info) {
        if (task.getClass() == Task.class) {
            if (nameOrContent.equals("name")) {
                task.setNameTask(info);
            } else if (nameOrContent.equals("content")) {
                task.setContentTask(info);
            }
        } else if (task.getClass() == Subtask.class) {
            if (nameOrContent.equals("name")) {
                ((Subtask)task).setNameSubtask(info);
            } else if (nameOrContent.equals("content")) {
                ((Subtask) task).setContentSubtask(info);
            }
        }
        return task;
    }

    public void updateStatus(Task task) {
        if (task.getClass() == Task.class && task.getStatusTask() == Status.NEW) {
            task.setStatusTask(Status.DONE);
        } else if (task.getClass() == Subtask.class && ((Subtask)task).getStatusSubtask() == Status.NEW) {
            ((Subtask)task).setStatusSubtask(Status.DONE);
        } else if (task.getClass() == Epic.class) {
            ((Epic) task).checkStatusSubtask();
        } else {
            System.out.println("Такого статуса не существует");
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i : taskHashMap.keySet()) {
            result += "\n\n" + i + "\n" + taskHashMap.get(i);
        }
        return result;
    }
}
