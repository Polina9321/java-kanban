import Manager.Manager;
import Tasks.Epic;
import Tasks.Status;
import Tasks.Subtask;
import Tasks.Task;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Task task1 = new Task("Приготовить ужин.", "Пожарить котлетки и сделать пюре.", Status.NEW);
        Task task2 = new Task("Сходить в магазин.", "Купить хлеб и молоко.", Status.NEW);
        Task task3 = new Task("Пропылесосить", "Взять пылесос", Status.NEW);
        Epic epic1  = new Epic("Постирать", "Закинуть стирку, подождать, развесить белье");
        Subtask epic1Subtask1 = new Subtask(4, "Закинуть стирку", "Положить белье в машинку", Status.NEW);
        Subtask epic1Subtask2 = new Subtask(4, "Подождать", "Заняться своими делами", Status.NEW);
        Subtask epic1Subtask3 = new Subtask(4, "Развесить белье", "Достать белье и повесить на сушилку", Status.NEW);
        Epic epic2 = new Epic("Собрать отряд", "Найти людей");
        Subtask epic2Subtask1 = new Subtask(9, "Создать форму для набора", "Провести отбор", Status.NEW);
        Subtask epic2Subtask2 = new Subtask(9, "Выбрать комнадира", "Провести выборы", Status.NEW);


        System.out.println("Id добавленной задачи: " + manager.addTask(task1));
        System.out.println("Id добавленной задачи: " + manager.addTask(task2));
        System.out.println("Id добавленной задачи: " + manager.addTask(task3));
        System.out.println("Id добавленного эпика: " + manager.addEpic(epic1));
        System.out.println("Id добавленной подзадачи: " + manager.addSubtask(epic1Subtask1) +
                " для эпика: " + manager.getEpic(4));
        System.out.println("Id добавленной подзадачи: " + manager.addSubtask(epic1Subtask2) +
                " для эпика: " + manager.getEpic(4));
        System.out.println("Id добавленной подзадачи: " + manager.addSubtask(epic1Subtask3) +
                " для эпика: " + manager.getEpic(4));
        System.out.println("Id добавленного эпика: " + manager.addEpic(epic2));
        System.out.println("Id добавленной подзадачи: " + manager.addSubtask(epic2Subtask1) +
                " для эпика: " + manager.getEpic(8));
        System.out.println("Id добавленной подзадачи: " + manager.addSubtask(epic2Subtask2) +
                " для эпика: " + manager.getEpic(8));

        System.out.println(manager);
        System.out.println("\nУдаление задач");
        manager.deleteTaskById(1);
        manager.deleteTaskById(3);
        manager.deleteEpicById(8);

        System.out.println(manager);

        System.out.println("\nОбновить статусы");
        manager.updateEpic(epic1);
        manager.updateSubtask(epic1Subtask1);
        manager.updateTask(task2);

        System.out.println(manager);

        System.out.println("\nДобавить задачу");
        manager.addTask(task3);
        manager.addTask(task1);
        manager.addEpic(epic2);

        System.out.println(manager);

        System.out.println("\nСписок задач: " + manager.getTaskArrayList());
        System.out.println("\nСписок эпиков: " + manager.getEpicArrayList());
        System.out.println("\nСписок всех подзадач: " + manager.getSubtaskArrayList());
        System.out.println("\nСписок подзадач эпика: " + epic1.getId() + ": \n" + manager.getSubtaskByEpic(4));
        System.out.println("\nЗадача по индексу: " + manager.getTask(3));
        System.out.println("\nЭпик по индексу: " + manager.getEpic(4));
        System.out.println("\nПодзадачи: " + manager.getSubtaskByEpic(4));

        System.out.println(manager);

        manager.deleteTasks();
        manager.deleteAllSubtasks();

        System.out.println(manager);

        manager.deleteEpics();

        System.out.println(manager);

    }
}
