package AssigmentTask;

import model.Task;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class AssigmentTask {
    public AssigmentTask(){

    }
    public static void addNewTask(Task task) throws Exception {
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO TASK( ID,NAME,TASKTYPE, TIME, ASSIGNEE, REVIEWER) VALUES (?,?,?,?,?,?)");
            pstmt.setInt(1,task.getId());
            pstmt.setString(2, task.getName());
            pstmt.setString(3, task.getTaskType());
            pstmt.setInt(4, (int) task.getTime());
            pstmt.setString(5,task.getAssignee());
            pstmt.setString(6,task.getReviewer());
            int updated = pstmt.executeUpdate();
            if (updated > 0) {
                System.out.println("Insert Student success!!!");
            }

            pstmt.close();
            conn.close();
        } catch (Exception var5) {
            throw new Exception(var5.getMessage());
        }
    }
    public void viewAllTask(){
        try{
            Connection conn = DBUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID, NAME, TASKTYPE, TIME, ASSIGNEE, REVIEWER FROM TASK");

            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String taskType = rs.getString(3);
                float time = rs.getFloat(4);
                String assignee = rs.getString(5);
                String reviewer = rs.getString(6);
                Task task = new Task(id, name, taskType, (int) time, assignee, reviewer);
                System.out.println(task);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Task getTaskById(int id) throws Exception{
        Task task = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("SELECT ID, NAME, TASKTYPE, TIME, ASSIGNEE, REVIEWER FROM TASK WHERE ID =  ? ");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);
                String name = rs.getString(2);
                String taskType = rs.getString(3);
                float time = rs.getFloat(4);
                String assignee = rs.getString(5);
                String reviewer = rs.getString(6);
                task = new Task(id, name, taskType, (int) time, assignee, reviewer);
               // System.out.println(task);
            }

            return task;



        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
    public void UpdateTask(int id) throws Exception {
        try {
            Task updatingTask = this.getTaskById(id);
            if(updatingTask !=null){
                updatingTask.inputData();
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("UPDATE TASK SET NAME = ?,TASKTYPE = ?,TIME = ?,ASSIGNEE = ?,REVIEWER = ? WHERE ID = ?");
                pstmt.setString(1,updatingTask.getName());
                pstmt.setString(2,updatingTask.getTaskType());
                pstmt.setInt(3, (int) updatingTask.getTime());
                pstmt.setString(4,updatingTask.getAssignee());
                pstmt.setString(5,updatingTask.getReviewer());
                pstmt.setInt(6,updatingTask.getId());
                int updated = pstmt.executeUpdate();
                if(updated > 0){
                    System.out.println("Update Task Success!!!");
                }
                pstmt.close();
                conn.close();

            }else{
                System.out.println("Task not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    public void DeleteTask(int id) throws  Exception{
    try{
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("DELETE Task WHERE ID = ?");
        pstmt.setInt(1,id);
       // ResultSet rs = pstmt.executeQuery();
    }catch (Exception e){
        throw new Exception(e.getMessage());
    }
    }

}
