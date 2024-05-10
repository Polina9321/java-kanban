package Manager;

import Tasks.*;

import java.util.HashMap;
import java.util.ArrayList;

public class Manager {
    protected int id = 0;
    public HashMap<Integer, Task> taskHashMap = new HashMap<>();

    public void addTask(Task o) {
        if (!taskHashMap.containsValue(o)) {
            while (taskHashMap.containsKey(id)) {
                id++;
                o.setId(id);
            }
            taskHashMap.put(id, o);
        }
    }

    public void addTask(Epic epic, Subtask... subtasks) {
        for (Subtask subtask : subtasks) {
            if (!epic.getSubtaskArrayList().contains(subtask)) {
                subtask.setSubtaskId(epic.getIdTask());
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

    public void deleteTaskById(int index) {
        taskHashMap.remove(index);
    }



    public void deleteSubtaskById(int indexEpic,int indexSubtask) {
        Epic epic = (Epic)taskHashMap.get(indexEpic);
        epic.deleteSubtask(indexSubtask);
    }

    public Task getTask(int index) {
        return taskHashMap.get(index);
    }

    public ArrayList<Subtask> getEpicSubtasks(Epic epic) {
        return new ArrayList<>(epic.getSubtaskArrayList());
    }

    public  void updateTask(int index, Task task) {
        deleteTaskById(index);
        taskHashMap.put(index, task);
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
