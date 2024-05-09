import Manager.Manager;
import Tasks.Epic;
import Tasks.Subtask;
import Tasks.Task;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Task task1 = new Task("Приготовить ужин.", "Пожарить котлетки и сделать пюре.");
        Task task2 = new Task("Сходить в магазин.", "Купить хлеб и молоко.");
        Task task3 = new Task("Пропылесосить", "Взять пылесос");
        Epic epic1  = new Epic("Постирать", "Закинуть стирку, подождать, развесить белье");
        Subtask epic1Subtask1 = new Subtask("Закинуть стирку", "Положить белье в машинку");
        Subtask epic1Subtask2 = new Subtask("Подождать", "Заняться своими делами");
        Subtask epic1Subtask3 = new Subtask("Развесить белье", "Достать белье и повесить на сушилку");
        Epic epic2 = new Epic("Собрать отряд", "Найти людей");
        Subtask epic2Subtask1 = new Subtask("Создать форму для набора", "Провести отбор");
        Subtask epic2Subtask2 = new Subtask("Выбрать комнадира", "Провести выборы");

        manager.addTask(task1);
        manager.addTask(task2);
        manager.addTask(task3);
        manager.addTask(task3);
        manager.addTask(epic1);
        manager.addTask(epic1, epic1Subtask1);
        manager.addTask(epic1, epic1Subtask1, epic1Subtask2);
        manager.addTask(epic1, epic1Subtask1, epic1Subtask2, epic1Subtask3);
        manager.addTask(epic2);
        manager.addTask(epic2, epic2Subtask1);
        manager.addTask(epic2, epic2Subtask1, epic2Subtask2);

        System.out.println(manager);
        System.out.println("\nУдаление задач");
        manager.deleteTastById(1, 3);

        System.out.println(manager);

        System.out.println("\nОбновить статусы");
        manager.updateStatus(epic1);
        manager.updateStatus(epic1Subtask1);
        manager.updateStatus(task2);

        System.out.println(manager);

        System.out.println("\nДобавить задачу");
        manager.addTask(task3);
        manager.addTask(task1);
        manager.addTask(epic2);

        System.out.println(manager);

        System.out.println("\nСписок задач: " + manager.getTaskArrayList());
        System.out.println("\nЗадача по индексу: " + manager.getTask(3));
        System.out.println("\nПодзадачи: " + manager.getEpicSubtasks(epic2));
        System.out.println("\nОбновляем задачу: ");
        manager.updateTask(2, manager.updateInfo(manager.getTask(2), "name", "Вкусно и точка"));

        System.out.println(manager);

        manager.deleteTasks();

        System.out.println(manager);

    }
}
