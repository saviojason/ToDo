/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.util.Scanner;

/**
 * To start the application click run the program through the UserInterface.java
 *
 * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 *
 *
 * This class takes care of the user interface i.e it helps with displaying of
 * menus and is the entry point of the application
 *
 * @author Jason D'souza student at Monash University
 *
 */
public class UserInterface {

    //puts an instance of Todo in a container called todo1
    private static Todo todo1 = new Todo();
    //creates a variable for us to check if its time to exit
    private static String exitCheck = "";
    private static String todonumber ="";

    /**
     * Program starts here
     *
     * @param args
     */
    public static void main(String[] args) {
        // UserInterface ui = new UserInterface();
        // todo1.loadTasks();
        exitCheck = "s"; // set a value in the register to ensure program is running
        displayMenu();
        scanMenuChoice();

    }

    public static void displayMenu() {
        System.out.println("#######################");
        System.out.println("Menu for ToDo System");
        System.out.println("Option a: Add Todo");
        System.out.println("Option b: Remove Todo");
        System.out.println("Option c: Update Todo");
        System.out.println("Option d: Generate things due today");
        System.out.println("Option e: Exit System");
        System.out.println("Please enter your choice");
        System.out.println("########################");
    }

    /**
     * Method to scan choice from the keyboard.
     */
    private static void scanMenuChoice() {

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        while (exitCheck.contains("s")) {
            switch (choice) {
                case "a":
                    addTodo();
                    break;
                case "b":
                    removeTodo();
                    break;
                case "c":
                    updateTodo();
                    break;
                case "d":
                    generateList();
                    break;
                case "e":
                    exitSystem(); // save everything
                    exitCheck = "b"; // set exitCheck to a non s value which exits the program
                    break;
                default:
                    System.out.println("Please choose the correct option");
                    displayMenu();
                    choice = input.nextLine();
                    break;
            }
        }
    }

    /**
     * add item to todolist
     */
    public static void addTodo() {
        todo1.addTask();

    }

    /**
     * removeTodo remove item from todolist
     */
    public static void removeTodo() {
        System.out.println("What would you like to remove");
        // following code can be move to a different area as it is probably being repeated
        int k = 0;
        for (int j = 0; j < todo1.tasks.size(); j++) {
            k = j;
            System.out.println("Task number = " + j);
            System.out.println(todo1.tasks.get(j).getTaskDesc());
            System.out.println(todo1.tasks.get(j).getDueDate());
            System.out.println(todo1.tasks.get(j).getPriority());
            System.out.println(todo1.tasks.get(j).getStatus());
            System.out.println("");
            System.out.println("Would you like to remove anything?");

        }

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        if (choice == "y" || choice == "Y") {
            System.out.println("What item number would you like to remove?");
            choice = input.nextLine();
            todo1.tasks.remove(k + 1);

        }

        if (choice == "n" || choice == "N") {

        }
    }

    /**
     * Remove todo item number
     */
    public static void removeTodoItem() {

        todo1.tasks.remove(todonumber);
        
    }

    /**
     * updateTodo update todo list
     */
    public static void updateTodo() {
        // Print a list of todo's with their respective numbers
        generateList();
        // Then ask which todo number I would like to update
        System.out.println("What item would you like to update?");
        Scanner input = new Scanner(System.in);
        todonumber = input.nextLine();

    }

    /**
     * Generate List of todo's. clearly need a for loop
     */
    public static void generateList() {
        int k = 0;
        // loop through Todo list and print tasks by number
        for (int j = 0; j < todo1.tasks.size(); j++) {
            k = j;
            System.out.println("Task number = " + j);
            System.out.println(todo1.tasks.get(j).getTaskDesc());
            System.out.println(todo1.tasks.get(j).getDueDate());
            System.out.println(todo1.tasks.get(j).getPriority());
            System.out.println(todo1.tasks.get(j).getStatus());
            System.out.println("");

        }
    }

    /**
     * Exit System
     */
    public static void exitSystem() {

    }

    /**
     * Load list of todo's
     */
    public static void loadList() {

    }

}
