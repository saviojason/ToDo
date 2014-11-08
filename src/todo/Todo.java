/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Todo list program
 *
 * @author Jason D'souza student at Monash University
 */
public class Todo {

    private ArrayList<Task> tasks; // List of Tasks
    private Task getDone; //Instance of Task

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Todo ui = new Todo();
        //ui.addTask();
    }

    Todo() {
        tasks = new ArrayList();
        getDone = new Task();
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
                Controller write = new Controller();
                write.writeFile("Todo.txt");
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
        Controller reader = new Controller();
        reader.fileReader1();// sometimes get an error here about ArrayIndexOutofBoundsException
        addTask();
    }



}
