/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.util.Scanner;

/**
 * This class takes care of the user interface i.e it helps with displaying of
 * menus and is the entry point of the application
 *
 * @author Jason D'souza student at Monash University
 *
 */
public class UserInterface {

    private static Todo todo1 = new Todo();
    private static String exitCheck = "";

    /**
     * Program starts here
     *
     * @param args
     */
    public static void main(String[] args) {
        //UserInterface ui = new UserInterface();
//        todo1.loadTasks();
        exitCheck = "s";
        displayMenu();
        scanMenuChoice();

    }

    public static void displayMenu() {
        System.out.println("Menu for ToDo System");
        System.out.println("Option a: Add Todo");
        System.out.println("Option b: Remove Todo");
        System.out.println("Option c: Update Todo");
        System.out.println("Option d: Generate things due today");
        System.out.println("Option e: Exit System");
        System.out.println("Please enter your choice");
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
                    exitCheck = "b"; // check exitCheck to a non s value which exits the program
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
        scanMenuChoice();

    }

    /**
     * removeTodo remove item from todolist
     */
    public static void removeTodo() {

    }

    /**
     * updateTodo update todo list
     */
    public static void updateTodo() {

    }

    /**
     * generateList
     */
    public static void generateList() {

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
