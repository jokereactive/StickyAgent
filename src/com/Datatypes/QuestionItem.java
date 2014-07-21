package com.Datatypes;

import java.util.Calendar;


public class QuestionItem {

	private int uid;
	private String category;
	private String title;
	private String details;
	private Long time;
	private Boolean resolved;
	private String message;
	
	public QuestionItem() {
		this.resolved=false;
		// TODO Auto-generated constructor stub
	}
	
	
	//get commands
	public int getUid()
	{
		return uid;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public String getTitle()
	{
		return title;
	}

	public String getDetails()
	{
		return title;
	}
	
	public Long getTime()
	{
		return time;
	}
	
	public Boolean isResolved(){
		return resolved;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	
	
	//set commands
	public void setUid(int uid)
	{
		this.uid=uid;
	}
	
	public void setCategory(String category)
	{
		this.category=category;
	}
	
	public void setTitle(String title)
	{
		this.title=title;
	}

	public void setDetails(String details)
	{
		this.details=details;
	}
	
	public void setTime(Long time)
	{
		this.time=time;
	}
	
	public void setResolved(Boolean resolved){
		this.resolved=resolved;
	}
	public void setResolved(int resolved){
		if (resolved==1)
			this.resolved=true;
		else
			this.resolved=false;
	}
	
	public void setMessage(String message)
	{
		this.message=message;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("uid: "+uid+"\n");
		sb.append("category: "+category+"\n");
		sb.append("title: "+title+"\n");
		sb.append("details: "+details+"\n");
		sb.append("time: "+time+"\n");
		sb.append("resolved: "+resolved);
		return sb.toString();
	}
	
	
}
