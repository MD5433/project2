import java.util.Scanner;
import java.util.ArrayList;

public class Task {
    private String title;
    private String description;
    private int priority;
    static Scanner myIn = new Scanner(System.in);
    static ArrayList<Task> tasks = new ArrayList<>();

    public Task(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }

    public static void addTask() {
        try {
            System.out.println("Enter a title for the task: ");
            String title = myIn.nextLine();
            System.out.print("Enter a description for the task: ");
            String description = myIn.nextLine();
            System.out.print("Enter priority for the task (0-5): ");
            int priority = Integer.parseInt(myIn.nextLine());
            tasks.add(new Task(title, description, priority));
            System.out.println("Task added.");
        } catch (NumberFormatException e){
            System.out.println("Invalid input, input for priority must be an integer");
        }

    }

    public static void removeTask() {
        listTask();
        if (tasks.isEmpty()) return;
        try {
            System.out.print("Enter task number to remove: ");
            int index = Integer.parseInt(myIn.nextLine()) - 1;
            tasks.remove(index);
            System.out.println("Task removed.");
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid task number.");
        }
    }

    public static void editTask() {
        listTask();
        if (tasks.isEmpty()) return;
        try {
            System.out.print("Enter task number to edit: ");
            int index = Integer.parseInt(myIn.nextLine()) - 1;
            Task task = tasks.get(index);

            System.out.print("Enter new title, to keep the current title, leave it blank: ");
            String title = myIn.nextLine();
            if (!title.isEmpty()) task.setTitle(title);

            System.out.print("Enter new description to keep the current description, leave it blank: ");
            String description = myIn.nextLine();
            if (!description.isEmpty()) task.setDescription(description);

            System.out.print("Enter new priority (0-5), to keep the current priority, leave it blank: ");
            String priorityInput = myIn.nextLine();
            if (!priorityInput.isEmpty()) task.setPriority(Integer.parseInt(priorityInput));

            System.out.println("Task updated.");
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    public static void listTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available: ");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void listByPriority() {
        try {
            System.out.print("Enter the priority to filter (0-5): ");
            int priority = Integer.parseInt(myIn.nextLine());
            for (Task task : tasks) {
                if (task.getPriority() == priority) {
                    System.out.println(task);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, input for priority must be an integer: ");
        }
    }


}
