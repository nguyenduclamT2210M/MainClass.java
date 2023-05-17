package AssigmentTask;

import model.Task;
import java.util.Scanner;

public class MainClass {
    public MainClass(){

    }
    public static void main(String[] args) {
        AssigmentTask assigmentTask = new AssigmentTask();
        Scanner input = new Scanner(System.in);

        try{
            while (true){
                System.out.println("\n" +
                        "========= Task program =========\n" +
                        "1. Add Task Type\n" +
                        "2. View all Task\n" +
                        "3. Get Task By Id\n" +
                        "4. Update Task \n" +
                        "5. Delete task\n"+ "6. Exit Program"
                        );
                System.out.print("Inviting you to choose: ");
                int choose = input.nextInt();
                    int id;
                switch (choose){
                    case 1:
                        Task task = new Task();
                        task.inputData();
                        AssigmentTask.addNewTask(task);
                        break;
                    case  2:
                        assigmentTask.viewAllTask();
                        break;
                    case 3:
                        System.out.print("Enter Id: ");
                        id = input.nextInt();
                        Task task1 = assigmentTask.getTaskById(id);
                        if(task1 !=null){
                            System.out.print(task1.toString());
                        }else{
                            System.out.println("Not found");
                        }
                        break;
                    case 4:
                        System.out.print("Enter Task id to update: ");
                        id = input.nextInt();
                        assigmentTask.UpdateTask(id);
                        break;
                    case 5:
                        System.out.print("Enter Task id to delete: ");
                        id = input.nextInt();
                        assigmentTask.DeleteTask(id);
                        System.out.println("Successful delete!");
                        break;
                    case 6:
                        System.out.println("Program Ended");
                        return;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
