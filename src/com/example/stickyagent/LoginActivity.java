package com.example.stickyagent;

import com.utils.Utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements View.OnClickListener{

	Button b_login; 
	EditText et_user_id;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Utils.context=getApplicationContext();
		Utils.setCommonVariables();
		Utils.serverQuestionsList.addAll(Utils.hardcodedQuestionItemList(10));
		if(Utils.applicationSession.getLoginStatus().equals("true")){
			Intent i=new Intent(LoginActivity.this, MainActivity.class);
			startActivity(i);
			finish();
		}else{
			
		}
		setContentView(R.layout.login_screen);
		intialiseVariable();
		
	}

	private void intialiseVariable() {
		// TODO Auto-generated method stub
		b_login=(Button)findViewById(R.id.b_login);
		et_user_id=(EditText)findViewById(R.id.et_user_id);
		b_login.setOnClickListener(this);
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
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.equals(b_login)){
			if(et_user_id.getText().toString().equals("8447642083")){
				Utils.loggedIn=true;
				Toast.makeText(getApplicationContext(), "Login successful !!", Toast.LENGTH_SHORT).show();
				Utils.applicationSession.setLoginStatus("true");
				Intent i=new Intent(LoginActivity.this, MainActivity.class);
				startActivity(i);
			}else{
				Toast.makeText(getApplicationContext(), "Please enter correct id", Toast.LENGTH_SHORT).show();
				Utils.applicationSession.setLoginStatus("false");
				Utils.loggedIn=false;
			}
		}
	}

	
	
}
