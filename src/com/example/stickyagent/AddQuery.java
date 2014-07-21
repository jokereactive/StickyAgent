package com.example.stickyagent;

import java.util.ArrayList;
import java.util.Calendar;

import com.Datatypes.QuestionItem;
import com.utils.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddQuery extends Activity implements OnClickListener {
	
	Button btn;
	EditText et;
	Spinner sp;
	ArrayAdapter<String> adapter;
	ArrayList<String> al;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addquery);
		
		
		btn=(Button)findViewById(R.id.btnPost);
		btn.setOnClickListener(this);
		sp=(Spinner)findViewById(R.id.spnCategory);
		adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Categories));
		sp.setAdapter(adapter);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		QuestionItem qItem=new QuestionItem();
		
		SharedPreferences spref = getSharedPreferences("com.example.stickyagent_preferences", MODE_PRIVATE);
		qItem.setUid(spref.getInt("userId", 0));
		
		qItem.setCategory((String) sp.getSelectedItem());
		
		et=(EditText)findViewById(R.id.etTitle);
		qItem.setTitle(et.getText().toString());
		et=(EditText)findViewById(R.id.etDetails);
		qItem.setDetails(et.getText().toString());
		
		Calendar c = Calendar.getInstance();
		qItem.setTime(c.getTimeInMillis());
		
		Utils.questionsList.add(qItem);
		Toast.makeText(getApplicationContext(), "Post created success!", Toast.LENGTH_SHORT).show();
		InputMethodManager inputManager = (InputMethodManager) 
				getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		inputManager.hideSoftInputFromWindow(et.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		finish();
		Log.d("asd", Utils.questionsList.toString());
	}
}
