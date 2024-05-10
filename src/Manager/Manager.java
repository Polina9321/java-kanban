package Manager;

import Tasks.*;

import java.util.HashMap;
import java.util.ArrayList;

public class Manager {
    protected int id = 0;
    public HashMap<Integer, Task> taskHashMap = new HashMap<>();
    public HashMap<Integer, Epic> epicHashMap = new HashMap<>();

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
        if (!epicHashMap.containsValue(epic)) {
            while (epicHashMap.containsKey(id)) {
                id++;
                epic.setId(id);
            }
            epicHashMap.put(id, epic);
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

    public ArrayList<Epic> getEpicArrayList() {
        return new ArrayList<>(epicHashMap.values());
    }

    public ArrayList<Subtask> getSubtaskByEpic(int id) {
        return getEpic(id).getSubtaskArrayList();
    }
    public void deleteTasks() {
        taskHashMap.clear();
        System.out.println("Все задачи в списке удалены.");
    }

    public void deleteTaskById(int index) {
        taskHashMap.remove(index);
    }

    public void deleteEpicById(int index) { epicHashMap.remove(index); }
    public void deleteSubtaskByEpic(Epic epic, int index) {
        epic.deleteSubtask(index);
    }


    public void deleteSubtaskById(int indexEpic,int indexSubtask) {
        Epic epic = (Epic)taskHashMap.get(indexEpic);
        epic.deleteSubtask(indexSubtask);
    }

    public Task getTask(int index) {
        return taskHashMap.get(index);
    }
    public Epic getEpic(int index) { return epicHashMap.get(index); }

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
