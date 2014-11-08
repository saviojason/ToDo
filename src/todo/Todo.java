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
                writeFile("Todo.txt");
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
        fileReader1();// sometimes get an error here about ArrayIndexOutofBoundsException
        addTask();
    }

    /**
     * writeFile
     */
    public void writeFile(String filename) {
        File file = new File(filename);
        // creates the file            

        try {
            file.createNewFile();
            // creates a FileWriter Object
            FileWriter writer = new FileWriter(file);
            // Writes the content to the file    
            for (int k = 0; k < tasks.size(); k++) {
                String content = tasks.get(k).getTaskDesc() + "," + tasks.get(k).getDueDate() + "," + tasks.get(k).getPriority() + "," + tasks.get(k).getStatus() + "\n";
                //Task task = tasks.get(k);
                //System.out.println(task.getTaskDesc());
                
                
                //writer.write(content);
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * fileReader
     */
    public void fileReader() {
        //Creates a FileReader Object
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader("Todo.txt"));
        } catch (Exception e) {
            System.out.println(e);
        }

        try {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] getdone = line.split(cvsSplitBy);

                //String tmp = tasks.get(i).getTaskDesc() + "," + tasks.get(i).getDueDate() + "," + tasks.get(i).getPriority() + tasks.get(i).getStatus() +"\n";
                System.out.println("Task Description : " + getdone[0]);
                System.out.println("Due Date : " + getdone[1]);
                System.out.println("Priority : " + getdone[2]);
                System.out.println("Status : " + getdone[3]);
                getDone.setTaskDesc(getdone[0]);
                getDone.setDueDate(getdone[1]);
                getDone.setPriority(getdone[2]);
                getDone.setStatus(getdone[3]);
                tasks.add(getDone);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                };
            }
        }

        System.out.println("Done");

    }

    public void fileReader1() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Todo.txt"));
            String line = reader.readLine();
            String cvsSplitBy = ",";

            while (line != null) {

                String[] getdone = line.split(cvsSplitBy);
                System.out.println("Task Description : " + getdone[0]);
                System.out.println("Due Date : " + getdone[1]);
                System.out.println("Priority : " + getdone[2]);
                System.out.println("Status : " + getdone[3]);
                getDone.setTaskDesc(getdone[0]);
                getDone.setDueDate(getdone[1]);
                getDone.setPriority(getdone[2]);
                getDone.setStatus(getdone[3]);
                tasks.add(getDone);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            //the specified file could not be found
        } catch (IOException e) {
            //something went wrong with reading or closing
            System.out.println(e);
        }

    }

}
