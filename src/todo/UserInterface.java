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
    
    private Todo todo1;
            
    public static void main(String[] args){
        UserInterface ui = new UserInterface();
        ui.displayMenu();
        
    }
    


    public void displayMenu() {
        System.out.println("Menu for ToDo System");
        System.out.println("Option a: Add Todo");
        System.out.println("Option b: Remove Todo");
        System.out.println("Option c: Update Todo");
        System.out.println("Option d: Generate things due today");
        System.out.println("Option e: Exit System");
        System.out.println("Please enter your choice");
        scanMenuChoice();
    }

    /**
     * Method to scan choice from the keyboard.
     */
    private void scanMenuChoice() {
        
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

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
                exitSystem();
                break;
            default:
                System.out.println("Please choose the correct option");
                displayMenu();
                scanMenuChoice();
                break;
        }
    }

    /**
     * add item to todolist
     */
    public void addTodo() {
    Todo todo1 = new Todo();   
        
    }

    /**
     * removeTodo remove item from todolist
     */
    public void removeTodo() {

    }

    /**
     * updateTodo update todo list
     */
    public void updateTodo() {

    }

    /**
     * generateList
     */
    public void generateList() {

    }

    /**
     * Exit System
     */
    public void exitSystem() {

    }

}
