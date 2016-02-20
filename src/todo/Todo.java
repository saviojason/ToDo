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

	public static ArrayList<Task> tasks = new ArrayList<Task>(); // List of Tasks
	private Task getDone = new Task(); // Instance of Task

	Todo() {
		loadTasksOnScreen();

	}

	/**
	 * addTask
	 *
	 * @return tasks
	 */
	public ArrayList<Task> addTask() {

		// project list of existing tasks
		for (int i = 0; i < tasks.size(); i++) {
			System.out.println(tasks.get(i).getTaskDesc() + "," + tasks.get(i).getDueDate() + ","
					+ tasks.get(i).getPriority() + "\n");

			Scanner input = new Scanner(System.in);
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
		}

		return tasks;

	}

	public void addTaskCsvLine(String setTaskDesc, String setDueDate, String setPriority, String setStatus) {
		getDone.setTaskDesc(setTaskDesc);
		getDone.setDueDate(setDueDate);
		getDone.setPriority(setPriority);
		getDone.setStatus(setStatus);
	}

	/**
	 * removeTodo remove item from todolist
	 */
	public static void removeTodo() {
		System.out.println("What would you like to remove");
		// following code can be move to a different area as it is probably
		// being repeated
		int k = 0;
		for (int j = 0; j < tasks.size(); j++) {
			k = j;
			System.out.println("Task number = " + j);
			System.out.println(tasks.get(j).getTaskDesc());
			System.out.println(tasks.get(j).getDueDate());
			System.out.println(tasks.get(j).getPriority());
			System.out.println(tasks.get(j).getStatus());
			System.out.println("");
			System.out.println("Would you like to remove anything?");

		}

		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();

		if (choice == "y" || choice == "Y") {
			System.out.println("What item number would you like to remove?");
			choice = input.nextLine();
			tasks.remove(k + 1);

		}

		if (choice == "n" || choice == "N") {

		}

	}

	/**
	 * Load tasks to memory
	 */
	public void loadTasksOnScreen() {
		// load up list of tasks
		// Controller reader = new Controller();
		// reader.fileReader1();// sometimes get an error here about
		// ArrayIndexOutofBoundsException
		// addTask();
		System.out.println("#########################");
		System.out.println("Stuff to do");

		try {
			Scanner input = new Scanner(System.in);
			// System.out.print("Enter the file name with extention : ");
			File file = new File("Todo.txt");

			input = new Scanner(file);

			while (input.hasNextLine()) {
				String line = input.nextLine();
				System.out.println(line);
			}
			input.close();

		} catch (NullPointerException ex) {
			System.out.println("Todo.txt file not found " + ex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("");

	}

	/**
	 * 
	 */
	public void loadTasksInMemory() {

		try {
			Scanner input = new Scanner(System.in);
			// System.out.print("Enter the file name with extention : ");
			File file = new File("Todo.txt");

			input = new Scanner(file);

			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] splitLine = line.split(",");
				addTaskCsvLine(splitLine[0], splitLine[1], splitLine[2], splitLine[3]);
				System.out.println(line);
			}
			input.close();

		} catch (NullPointerException ex) {
			System.out.println("Todo.txt file not found " + ex);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	/**
	 * 
	 */

	public void saveTasks() {
		try {
			PrintWriter writer = new PrintWriter("Todo.txt", "UTF-8");
			for (int i = 0; i < tasks.size(); i++) {
				Task get = tasks.get(i);
				String info = get.getDueDate() + " " + get.getPriority() + "" + get.getStatus() + ""
						+ get.getTaskDesc();
				writer.println(info);
			}

			writer.close();
		} catch (Exception e) {

			System.out.println(e);
		}
	}

	/**
	 * removeTodo remove item from todolist
	 */
	public static void removeTodo2() {
		System.out.println("What would you like to remove");
		// following code can be move to a different area as it is probably
		// being repeated
		int k = 0;
		for (int j = 0; j < tasks.size(); j++) {
			k = j;
			System.out.println("Task number = " + j);
			System.out.println(tasks.get(j).getTaskDesc());
			System.out.println(tasks.get(j).getDueDate());
			System.out.println(tasks.get(j).getPriority());
			System.out.println(tasks.get(j).getStatus());
			System.out.println("");
			System.out.println("Would you like to remove anything?");

		}

		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();

		if (choice == "y" || choice == "Y") {
			System.out.println("What item number would you like to remove?");
			choice = input.nextLine();
			tasks.remove(k + 1);

		}

		if (choice == "n" || choice == "N") {

		}
	}

	/**
	 * Remove todo item number
	 */
	public static void removeTodoItem() {

		tasks.remove(todonumber);

	}

	/**
	 * Generate List of todo's. clearly need a for loop
	 */
	public static void generateList() {
		// loop through Todo list and print tasks by number

		for (int j = 0; j < tasks.size(); j++) {
			System.out.println("Task number = " + j);
			System.out.println(tasks.get(j).getTaskDesc());
			System.out.println(tasks.get(j).getDueDate());
			System.out.println(tasks.get(j).getPriority());
			System.out.println(tasks.get(j).getStatus());
			System.out.println("");

		}
	}

}
