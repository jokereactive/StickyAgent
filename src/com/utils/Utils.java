package com.utils;

import java.util.ArrayList;
import java.util.Calendar;

import android.content.Context;
import android.util.Log;

import com.Datatypes.QuestionItem;
import com.example.stickyagent.R;

public class Utils {

	public static boolean loggedIn=false;
	public static Context context;
	public static int itemSelected;

	public static ArrayList<QuestionItem> questionsList;
	public static ArrayList<QuestionItem> serverQuestionsList;
	public static ArrayList<QuestionItem> tempQuestionList;
	
	//session
		public static ApplicationSession applicationSession;
	
	public static void setCommonVariables() {
		// TODO Auto-generated constructor stub
		if (questionsList==null)
			questionsList = new ArrayList<QuestionItem>();
		if(applicationSession==null){
			applicationSession=new ApplicationSession(context);
		}
		if(serverQuestionsList==null){
			serverQuestionsList=new ArrayList<QuestionItem>();
		}
	}
	
	public static ArrayList<QuestionItem> hardcodedQuestionItemList(int n)
	{
		ArrayList<QuestionItem> alqi=new ArrayList<QuestionItem>();
		QuestionItem qItem;
		
		int i;
		//Random rand=new Random();
		String[] cat=context.getResources().getStringArray(R.array.Categories);
		Calendar c = Calendar.getInstance();
		for(i=0;i<n;i++)
		{
			qItem=new QuestionItem();
			qItem.setUid(i);
			qItem.setCategory(cat[i%cat.length]);
			qItem.setTitle("t"+String.valueOf(i+100));
			qItem.setDetails("d"+String.valueOf(i+1000));
			qItem.setTime(c.getTimeInMillis()+10*i);
			qItem.setMessage("messagemessage"+i);
			qItem.setResolved(i%2);
			alqi.add(qItem);
		}
		
		Log.d("asd", alqi.toString());
		
		return alqi;
		
	}
}
