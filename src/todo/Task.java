/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

/**
 * Task
 *
 * @author Jason D'souza student at Monash University
 */
public class Task {

    private String taskDescription; // Description of task
    private String dueDate; // Due date of the task
    private String priority; // Priority of the task
    private String status; // done or not-done


    /**
     * Constructor initalises the program
     * This is a change
     */
    Task() {
        taskDescription = "";
        dueDate = "";
        priority = "";
    }

    /**
     * set task description
     */
    public void setTaskDesc(String taskdesc) {
        this.taskDescription = taskdesc;
    }

    /**
     * 
     *  @return 
     */
    public String getTaskDesc() {
        return taskDescription;
    }

    /**
     *  setDueDate
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     *  getDueDate
     */
    public String getDueDate() {
        return this.dueDate;
    }

    /**
     *  setPriority
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     *  getPriority
     */
    public String getPriority() {
        return this.priority;
    }
    
    /**
     * setStatus
     */
    public void setStatus(String status){
        this.status = status;
    }
    
    /**
     * getStatus
     */
    public String getStatus()
    {
        return this.status;
    }
}
