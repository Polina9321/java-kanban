package Manager;

import Tasks.*;

import java.util.HashMap;
import java.util.ArrayList;

public class Manager {
    protected int idTask = 0;
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

    public void deleteTaskById(int index) {
        taskHashMap.remove(index);
    }

    public void deleteEpicById(int index) {
        for (int key : subtaskHashMap.keySet()) {
            if (subtaskHashMap.get(key).epicId == index) {
                subtaskHashMap.remove(key);
            }
        }
        epicHashMap.remove(index);
    }

    public void deleteSubtaskById(int index) {
        Epic epic = epicHashMap.get(getSubtask(index).epicId);
        epic.deleteSubtask(getSubtask(index));
        epic.checkStatusSubtask();
    }

    public Task getTask(int index) {
        return taskHashMap.get(index);
    }
    public Epic getEpic(int index) {
        return epicHashMap.get(index);
    }

    public Subtask getSubtask(int index) {
        return subtaskHashMap.get(index);
    }

    public void updateTask(Task task) {
        int index = task.getId();
        if(taskHashMap.containsKey(index)){
            taskHashMap.put(index, task);
        }
    }

    public  void updateEpic(Epic epic) {
        int index = epic.getId();
        Epic oldEpic = epicHashMap.get(index);
        if(epicHashMap.containsKey(index)) {
            oldEpic.setNameTask(epic.getNameTask());
            oldEpic.setContentTask(epic.getContentTask());
        }
    }

    public void updateSubtask(Subtask subtask) {
        int index = subtask.getId();
        Subtask oldSubtask = subtaskHashMap.get(index);
        if (subtaskHashMap.containsValue(subtask)) {
            if (subtask.epicId == oldSubtask.epicId) {
                subtaskHashMap.put(index, subtask);
                updateTask(subtask);
                getEpic(subtask.epicId).checkStatusSubtask();
            }
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
