package com.Datatypes;

public class ChatMessage {

	private String message;
	private Boolean user;
	private int id;
	private Long time;
	
	// gets
	
	public ChatMessage(Boolean user, int id) {
		// TODO Auto-generated constructor stub
		this.user=user;
		this.id=id;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public int getid()
	{
		return id;
	}
	
	public Long getTime()
	{
		return time;
	}
	
	public Boolean isUser()
	{
		return this.user;
	}
	

	
	// puts
	
	public void setMessage(String message)
	{
		this.message=message;
	}
	
	public void setid(int id)
	{
		this.id=id;
	}

	public void setTime(Long time)
	{
		this.time=time;
	}
	
}
