package Manager;

import Tasks.*;

import java.util.HashMap;
import java.util.ArrayList;

public class Manager {
    protected int idTask = 1;
    private HashMap<Integer, Task> taskHashMap = new HashMap<>();
    private HashMap<Integer, Epic> epicHashMap = new HashMap<>();
    private HashMap<Integer, Subtask> subtaskHashMap = new HashMap<>();

    public int addTask(Task task) {
        task.setId(++idTask);
        taskHashMap.put(idTask, task);
        return idTask;
    }

    public int addEpic(Epic epic) {
        epic.setId(++idTask);
        epicHashMap.put(idTask, epic);
        return idTask;
    }

    public int addSubtask(Subtask subtask) {
        if (epicHashMap.containsValue(getEpic(subtask.epicId))) {
            subtask.setId(++idTask);
            subtaskHashMap.put(idTask, subtask);
            getEpic(subtask.epicId).addSubtask(subtask);
            getEpic(subtask.epicId).checkStatusSubtask();
            return idTask;
        } else {
            return -1;
        }

    }

    public ArrayList<Task> getTaskArrayList() {
        return new ArrayList<>(taskHashMap.values());
    }

    public ArrayList<Epic> getEpicArrayList() {
        return new ArrayList<>(epicHashMap.values());
    }

    public ArrayList<Task> getSubtaskArrayList() {
        return new ArrayList<>(subtaskHashMap.values());
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
        subtaskHashMap.clear();
        System.out.println("Все эпики в списке удалены.");
    }

    public void deleteAllSubtasks(){
        subtaskHashMap.clear();
        for (Epic epic : epicHashMap.values()) {
            epic.deleteAllSubtasks();
            epic.checkStatusSubtask();
        }
    }

    public void deleteAllSubtaskByEpic(int index) {
        getEpic(index).deleteAllSubtasks();
    }


    public void deleteTaskById(int index) {
        taskHashMap.remove(index);
    }

    public void deleteEpicById(int index) { epicHashMap.remove(index); }
    public void deleteSubtaskByEpic(int id, Subtask subtask) {
        getEpic(id).deleteSubtask(subtask);
    }


    public void deleteSubtaskById(int indexEpic, Subtask subtask) {
        Epic epic = (Epic)taskHashMap.get(indexEpic);
        epic.deleteSubtask(subtask);
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
        String name = subtask.getNameTask();
        ArrayList<Subtask> subtaskList = epic.getSubtaskArrayList();

        if(subtaskList.contains(name)){
            subtask.setStatusTask(Status.DONE);
            deleteSubtaskById(epic.getId(), subtask);
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
