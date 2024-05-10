package Manager;

import Tasks.*;

import java.util.HashMap;
import java.util.ArrayList;

public class Manager {
    protected int idTask = 1;
    protected int idEpic = 1;
    public HashMap<Integer, Task> taskHashMap = new HashMap<>();
    public HashMap<Integer, Epic> epicHashMap = new HashMap<>();

    public int addTask(Task task) {
        if (!taskHashMap.containsValue(task)) {
            while (taskHashMap.containsKey(idTask)) {
                idTask++;
                task.setId(idTask);
            }
            taskHashMap.put(idTask, task);
        }
        return idTask;
    }

    public int addEpic(Epic epic) {
        if (!epicHashMap.containsValue(epic)) {
            while (epicHashMap.containsKey(idEpic)) {
                idEpic++;
                epic.setId(idEpic);
            }
            epicHashMap.put(idEpic, epic);
        }
        return idEpic;
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

    public void deleteEpics() {
        epicHashMap.clear();
        System.out.println("Все эпики в списке удалены.");
    }

    public void deleteAllSubtaskByEpic(int index) {
        getEpic(index).deleteAllSubtasks();
    }


    public void deleteTaskById(int index) {
        taskHashMap.remove(index);
    }

    public void deleteEpicById(int index) { epicHashMap.remove(index); }
    public void deleteSubtaskByEpic(int id, int index) {
        getEpic(id).deleteSubtask(index);
    }


    public void deleteSubtaskById(int indexEpic,int indexSubtask) {
        Epic epic = (Epic)taskHashMap.get(indexEpic);
        epic.deleteSubtask(indexSubtask);
    }

    public Task getTask(int index) {
        return taskHashMap.get(index);
    }
    public Epic getEpic(int index) { return epicHashMap.get(index); }

    public  void updateTask(Task task) {
        int index = task.getId();
        if(taskHashMap.containsKey(index)){
            task.setStatusTask(Status.DONE);
            deleteTaskById(index);
            taskHashMap.put(index, task);
        }

    }

    public  void updateEpic(Epic epic) {
        int index = epic.getId();
        if(epicHashMap.containsKey(index)){
            epic.checkStatusSubtask();
            deleteTaskById(index);
            epicHashMap.put(index, epic);
        }
    }

    public  void updateSubtask(Epic epic, Subtask subtask) {
        String name = subtask.getNameSubtask();
        ArrayList<Subtask> subtaskList = epic.getSubtaskArrayList();

        if(subtaskList.contains(name)){
            subtask.setStatusSubtask(Status.DONE);
            deleteSubtaskById(epic.getId(), subtask.getSubtaskId());
            subtaskList.add(subtask);
            epic.checkStatusSubtask();
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

    public HashMap<Integer, Task> getTaskHashMap() {
        return taskHashMap;
    }

    public void setTaskHashMap(HashMap<Integer, Task> taskHashMap) {
        this.taskHashMap = taskHashMap;
    }

    public HashMap<Integer, Epic> getEpicHashMap() {
        return epicHashMap;
    }

    public void setEpicHashMap(HashMap<Integer, Epic> epicHashMap) {
        this.epicHashMap = epicHashMap;
    }
}
