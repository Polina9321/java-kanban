package Manager;

import Tasks.*;

import java.util.HashMap;
import java.util.ArrayList;

public class Manager {
    protected int id = 0;
    public HashMap<Integer, Task> taskHashMap = new HashMap<>();

    public int addTask(Task task) {
        if (!taskHashMap.containsValue(task)) {
            while (taskHashMap.containsKey(id)) {
                id++;
                task.setId(id);
            }
            taskHashMap.put(id, task);
        }
        return id;
    }

    public int addEpic(Epic epic) {
        if (!taskHashMap.containsValue(epic)) {
            while (taskHashMap.containsKey(id)) {
                id++;
                epic.setId(id);
            }
            taskHashMap.put(id, epic);
        }
        return id;
    }

    public int addSubtask(Epic epic, Subtask subtask) {
        epic.addSubtask(subtask);
        return subtask.getSubtaskId();
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
