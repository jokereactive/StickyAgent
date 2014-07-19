package com.example.stickyagent;

import java.util.HashMap;
import android.app.*;
import android.content.Intent;
import android.os.*;
import android.view.View;
import android.widget.RatingBar;

public class RatingScreen extends Activity{
	
	public static float ratingvalue;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ratingscreen);
		
	}
	
	public void onClick(View v){
		RatingBar mBar = (RatingBar) findViewById(R.id.ratingBar);
		ratingvalue=mBar.getRating();
		StickyAgent.GroupRating.get(getIntent().getIntExtra("GroupId",0)).Rating=ratingvalue;
		StickyAgent.UserRating.get(StickyAgent.GroupRating.get(getIntent().getIntExtra("GroupId",0)).UserId).add(ratingvalue);
		StickyAgent.EmployeeRating.get(StickyAgent.GroupRating.get(getIntent().getIntExtra("GroupId",0)).EmpId1).add(ratingvalue);
		StickyAgent.EmployeeRating.get(StickyAgent.GroupRating.get(getIntent().getIntExtra("GroupId",0)).EmpId2).add(ratingvalue);
		
		/*
		 * Code to add rating to the employee
		 */
		
	}
	
	@Override
	public void onResume(){
		
	}
	
	@Override
	public void onPause(){
		
	}
}
