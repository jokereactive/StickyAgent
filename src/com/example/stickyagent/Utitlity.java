package com.example.stickyagent;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Application;

class Group{
		public static int GroupId;
		public static int UserId;
		public static int EmpId1;
		public static int EmpId2;
		public static float Rating;
}

class StickyAgent extends Application {
		public static HashMap<Integer,Group> GroupRating = new HashMap();
		public static HashMap<Integer,ArrayList> UserRating = new HashMap();
		public static HashMap<Integer,ArrayList> EmployeeRating = new HashMap();
		
	    private static StickyAgent singleton;
	    public static StickyAgent getInstance() {
	        return singleton;
	    }
	    @Override
	    public void onCreate() {
	        super.onCreate();
	        singleton = this;
	    }
	  
	    public HashMap getUser(){
	    	return UserRating;
	    }
	    
	    public HashMap getEmployee(){
	    	return EmployeeRating;
	    }
	    
	    public void setUser(HashMap s){
	    	UserRating = s;
	    }
	    
	    public void setEmployee(HashMap e){
	    	EmployeeRating = e;
	    }
	    
	}

public class Utitlity {

}
