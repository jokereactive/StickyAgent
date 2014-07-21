package com.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class ApplicationSession {
	   private SharedPreferences prefs;

	    public ApplicationSession(Context cntx) {
	        // TODO Auto-generated constructor stub
	        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
	        
	    }

	    public void setClient(String client) {
	        prefs.edit().putString("client", client).commit();
	       
	    }

	    public String getClient() {
	        String login_status = prefs.getString("client","");
	        return login_status;
	    }
	    
	    public void setLoginStatus(String status) {
	        prefs.edit().putString("login_status", status).commit();
	       
	    }

	    public String getLoginStatus() {
	        String login_status = prefs.getString("login_status","");
	        return login_status;
	    }
	    
	    public void setusername(String username) {
	        prefs.edit().putString("username", username).commit();
	       
	    }

	    public String getusername() {
	        String username = prefs.getString("username","");
	        return username;
	    }
	    public void setPassword(String password) {
	        prefs.edit().putString("password", password).commit();
	       
	    }

	    public String getPassword() {
	        String password = prefs.getString("password","");
	        return password;
	    }
}
