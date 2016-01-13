package todo;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Todo list program
 *
 * @author Jason D'souza student at Monash University
 */
public class Todo {

    public ArrayList<Task> tasks = new ArrayList<Task>(); // List of Tasks
    private Task getDone = new Task(); //Instance of Task

    /**
     * @param args the command line arguments
     */
    Todo() {
        loadTasks();

    }

    /**
     * addTask
     *
     * @return tasks
     */
    public ArrayList<Task> addTask() {

        // project list of existing tasks
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i).getTaskDesc() + "," + tasks.get(i).getDueDate() + "," + tasks.get(i).getPriority() + "\n");
            //String tmp = tasks.get(i).getTaskDesc() + "," + tasks.get(i).getDueDate() + "," + tasks.get(i).getPriority() + "," + tasks.get(i).getStatus() + "\n";

        }

        Scanner input = new Scanner(System.in);
        // Adding new tasks from user        
        boolean test = false;
        while (test == false) {

            System.out.println("What needs to get done?");
            String getMeDone = input.nextLine();
            System.out.println("Priority");
            String setPriority = input.nextLine();
            System.out.println("Due Date");
            String dueWhen = input.nextLine();
            this.getDone.setTaskDesc(getMeDone);
            this.getDone.setDueDate(dueWhen);
            this.getDone.setPriority(setPriority);
            this.getDone.setStatus("Not-Done");

            tasks.add(this.getDone);

            // write to file
            // get all elements from array list
            System.out.println("Do you want to continue adding more items to the list? - Y/N");
            String continueya = input.nextLine();

            // Y results in program continuing. N results in while loop stopping.
            if ((continueya.contentEquals("N")) || continueya.contentEquals("n")) {
                test = true;
                //Controller write = new Controller();
                //write.writeFile("Todo.txt");
            } else {
                continue;
            }

        }
        return tasks;
    }

    /**
     * Load tasks to memory
     */
    public void loadTasks() {
        // load up list of tasks
        //Controller reader = new Controller();
        //reader.fileReader1();// sometimes get an error here about ArrayIndexOutofBoundsException
//        addTask();
    	System.out.println("#########################");
    	System.out.println("Stuff to do");
    	

        try {
            Scanner input = new Scanner(System.in);
//            System.out.print("Enter the file name with extention : ");
            File file = new File("Todo.txt");

            input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();

        } catch (NullPointerException ex) {
            System.out.println("Todo.txt file not found " + ex);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        } 
        
     System.out.println("");  

    }

    public void saveTasks() {
        try {
            PrintWriter writer = new PrintWriter("Todo.txt", "UTF-8");
            for (int i = 0; i < tasks.size(); i++) {
                Task get = tasks.get(i);
                String info = get.getDueDate() + " " + get.getPriority() + "" + get.getStatus() + "" + get.getTaskDesc() ;
                writer.println(info);
            }
            
                        writer.close();
        } catch (Exception e) {
            
            System.out.println(e);
        }
    }

}
