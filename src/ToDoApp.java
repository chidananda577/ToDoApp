import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Task {
    String name;
    String deadline;
    int priority;

    Task(String name, String deadline, int priority) {
        this.name = name;
        this.deadline = deadline;
        this.priority = priority;
    }  
    @Override
    public String toString() {
        return "Task: " + name + " | Deadline: " + deadline + " | Priority: " + priority;
    }
}

public class ToDoApp {

    private static List<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while(true){
        System.out.println("\n==TODO LIST==");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Sort by Priority");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        switch(choice){
            case  1 -> addTask();
            case  2 -> viewTasks();
            case  3 -> removeTask();
            case 4 -> sortTaskByPriority();
            case 5 -> {
                System.out.println("Exiting...");
                return;
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
        }
    }

    private static void addTask() {
        System.out.println("Enter the task name:");
        String name = scanner.nextLine();
        System.out.println("Enter the dealine for the task (YYYY-MM-DD):");
        String deadline = scanner.nextLine();
        System.out.println("Enter the priority for the task (1-High, 2-Medium , 3-Low ):");
        int priority = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        tasks.add(new Task(name,deadline,priority));
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        if(tasks.isEmpty()){
            System.out.println("No task found.");
        }else{
            System.out.println("Tasks");
            for(int i=0;i<tasks.size();i++){
                System.out.println((i+1)+". "+tasks.get(i));
            }
        }
    }

    private static void removeTask() {
        viewTasks();
        if(!tasks.isEmpty()){
            System.out.println("Enter the task number to remove:");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            if(taskNumber > 0 && taskNumber <= tasks.size()){
                tasks.remove(taskNumber - 1);
                System.out.println("Task removed successfully.");
            }else{
                System.out.println("Invalid task number.");
            }
        }
    }

    private static void sortTaskByPriority(){
        if(tasks.isEmpty()){
            System.out.println("No task found.");
        }else{
            tasks.sort(Comparator.comparingInt(task->task.priority));
            System.out.println("Tasks sorted by priority:");
        }
    }
}
