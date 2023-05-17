package model;

import java.util.Scanner;

public class Task {
    int Id;
    String Name;
    String TaskType;

    float Time;
    String Assignee ;
    String Reviewer;
    private int TASKTYPE;


    public void inputData(){
        Scanner input = new Scanner(System.in);
        System.out.print("Id: ");
        this.Id = input.nextInt();
        System.out.print("Requirement Name: ");
        this.Name = input.next();
        System.out.print("Take Type: ");
        this.TaskType = input.next();
        System.out.print("Time: ");
        this.Time = input.nextInt();
        System.out.print("Assignee: ");
        this.Assignee = input.next();
        System.out.print("Reviewer: ");
        this.Reviewer = input.next();
    }

    public Task(){

    }
    public Task (int Id, String Name,String TaskType,int Time,String Assignee,String Reviewer){
        this.Id = Id;
        this.Name = Name;
        this.TaskType = TaskType;
        this.Time = Time;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }

    public String toString() {return this.Id+" , "+this.Name+" , "+this.TASKTYPE+" , "+this.Time+" , "+this.Assignee+" , "+this.Reviewer;}
    public int getId(){return  this.Id;}
    public void setId(int Id){this.Id =Id;}
    public String getName(){return this.Name;}
    public void setName(String Name){this.Name=Name;}
    public String getTaskType(){return this.TaskType;}
    public void setTaskType(String TaskType){this.TaskType=TaskType;}
    public double getTime(){return this.Time;}
    public void setTime(float Time){ this.Time = Time;}
    public String getAssignee(){return this.Assignee;}
    public void setAssignee(String Assignee){this.Assignee = Assignee;}
    public String getReviewer( ){return this.Reviewer;}
    public void setReviewer(String Reviewer){this.Reviewer = Reviewer;}


}
