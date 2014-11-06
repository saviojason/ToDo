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
        ui.addTask();
    }

    /**
     * addTask
     *
     * @return tasks
     */
    public ArrayList<Task> addTask() {
        tasks = new ArrayList();
        getDone = new Task();
        // load up list of tasks
        fileReader();// sometimes get an error here about ArrayIndexOutofBoundsException
        
        // Adding new tasks from user        
        boolean test = false;
        while (test == false) {

            Scanner input = new Scanner(System.in);
            System.out.println("What needs to get done?");
            String getMeDone = input.nextLine();
            System.out.println("Priority");
            String setPriority = input.nextLine();
            System.out.println("Due Date");
            String dueWhen = input.nextLine();
            getDone.setTaskDesc(getMeDone);
            getDone.setDueDate(dueWhen);
            getDone.setPriority(setPriority);
            getDone.setStatus("Not-Done");

            tasks.add(getDone);

            // write to file
            // get all elements from array list
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(tasks.get(i).getTaskDesc() + "," + tasks.get(i).getDueDate() + "," + tasks.get(i).getPriority() + "\n");
                String tmp = tasks.get(i).getTaskDesc() + "," + tasks.get(i).getDueDate() + "," + tasks.get(i).getPriority() + tasks.get(i).getStatus() + "\n";
                writeFile(tmp);
            }

            System.out.println("Do you want to continue adding more iterms to the list? - Y/N");
            String continueya = input.nextLine();

            // Y results in program continuing. N results in while loop stopping.
            if (continueya.contentEquals("N")) {
                test = true;
            } else {
                continue;
            }

        }
        return tasks;
    }

    /**
     * writeFile
     */
    public void writeFile(String tmp) {
        File file = new File("Todo.txt");
        // creates the file

        try {
            file.createNewFile();
            // creates a FileWriter Object
            FileWriter writer = new FileWriter(file);
            // Writes the content to the file    
            writer.write(tmp);
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
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                };
            }
        }

        System.out.println("Done");

    }

}
