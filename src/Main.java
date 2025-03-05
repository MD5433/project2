//Mariah Dungey 03/02/2025
public class Main {
    public static void main(String[] args) {
        while (true) {
            taskDisplay();
            try {
                int choice = Integer.parseInt(Task.myIn.nextLine());
                switch (choice) {
                    case 1:
                        Task.taskAdd();
                        break;
                    case 2:
                        Task.taskRemove();
                        break;
                    case 3:
                        Task.taskUpdate();
                        break;
                    case 4:
                        Task.taskList();
                        break;
                    case 5:
                        Task.taskByPriority();
                        break;
                    case 0:
                        System.out.println("Exiting program.");
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }




    static void taskDisplay() {
        System.out.println("Choose an option:");
        System.out.println("(1) Add a task");
        System.out.println("(2) Remove a task");
        System.out.println("(3) update a task");
        System.out.println("(4) List all tasks");
        System.out.println("(5) List task by priority");
        System.out.println("(0) Exit");
    }
}
