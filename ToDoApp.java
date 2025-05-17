import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {

    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while(true){
        System.out.println("==TODO LIST==");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        switch(choice){
            case  1 -> addTask();
            case  2 -> viewTasks();
            case  3 -> removeTask();
            case 4 -> {
                System.out.println("Exiting...");
                return;
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
        }
    }

    private static void addTask() {
        System.out.println("Enter the task to add:");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added: " + task);
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
        System.out.println("Enter the task number to remove:");
        int taskNumber = scanner.nextInt();
        if(taskNumber < 1 || taskNumber > tasks.size()){
            System.out.println("Invalid task number.");
        }else{
            String removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Removed task: " + removedTask);
        }
    }
}
