package com.example.wxb_07.Helper;


public class Task {

	private static  int taskID;
	private static int taskProgress;
	
	
	//public static List<Task> T = new ArrayList<Task>();  
	public static final String dialog1 = "tittle";
	public static final String dialog2 = "content";
	public static final String reg  = "register";
	
	

	
	public static int getTaskID() {
		return taskID;
	}
	public static void setTaskID(int taskID) {
		Task.taskID = taskID;
	}
	public static int getTaskProgress() {
		return taskProgress;
	}
	public static void setTaskProgress(int taskProgress) {
		Task.taskProgress = taskProgress;
	}
	

	
}
