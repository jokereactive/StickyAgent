package com.example.stickyagent;

import java.util.ArrayList;
import java.util.Calendar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.Adapters.ChatAdapter;
import com.Datatypes.ChatMessage;

public class ChatActivity extends ActionBarActivity implements OnClickListener{

	EditText et;
	ImageView iv,iv_warning,iv_call,iv_video;
	TextView tv_group_info;
	ArrayList<ChatMessage> alcm;
	ChatMessage cm;
	ChatAdapter ca;
	ListView lv;
	ActionBar actionbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);
		
		actionbar = getSupportActionBar();
		setActionBarCustomization();
		tv_group_info=(TextView)actionbar.getCustomView().findViewById(R.id.tv_group_info);
		iv_warning=(ImageView)actionbar.getCustomView().findViewById(R.id.iv_warning);
		iv_call=(ImageView)actionbar.getCustomView().findViewById(R.id.iv_call);
		iv_video=(ImageView)actionbar.getCustomView().findViewById(R.id.iv_video);
		tv_group_info.setOnClickListener(this);
		iv_call.setOnClickListener(this);
		iv_warning.setOnClickListener(this);
		iv_video.setOnClickListener(this);
		
		
		
		et=(EditText)findViewById(R.id.etMessage);
		iv=(ImageView)findViewById(R.id.ivSend);
		
		alcm=new ArrayList<ChatMessage>();
		ca = new ChatAdapter(this, android.R.layout.simple_list_item_1, alcm);
		
		lv=(ListView)findViewById(R.id.lvChat);
		lv.setAdapter(ca);
		
		iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cm=new ChatMessage(true, 0);
				cm.setMessage(et.getText().toString());
				Calendar c=Calendar.getInstance();
				cm.setTime(c.getTimeInMillis());
				alcm.add(cm);
				ca.notifyDataSetChanged();
				
				
				class DoBackgroundTask extends AsyncTask<Void, Void, Void>{

					@Override
					protected Void doInBackground(Void... params) {
						// TODO Auto-generated method stub
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						return null;
					}	
					
					@Override
					protected void onPostExecute(Void result) {
						// TODO Auto-generated method stub
						
						Handler handler=new Handler();
						
						handler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								cm=new ChatMessage(false, 0);
								cm.setMessage(et.getText().toString().toUpperCase());
								Calendar c=Calendar.getInstance();
								cm.setTime(c.getTimeInMillis());
								alcm.add(cm);
								ca.notifyDataSetChanged();
								et.setText("");
							}
						});
						
						super.onPostExecute(result);
					}
					
				};
				
				new DoBackgroundTask().execute(null,null);
				
				
			}
		});
	}

	private void setActionBarCustomization() {
		// TODO Auto-generated method stub
		actionbar.setCustomView(R.layout.custom_action_bar);
//		actionbar.setHomeButtonEnabled(true);
		actionbar.setDisplayHomeAsUpEnabled(true);
		actionbar.setDisplayShowCustomEnabled(true);
		actionbar.setIcon(0);
		actionbar.setDisplayShowHomeEnabled(false);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
		
		if(v.equals(tv_group_info))
		{
			Toast.makeText(this, "groupinfo", 0).show();
		}
		
		else if(v.equals(iv_call))
		{
			Toast.makeText(this, "call", 0).show();
		}
		
		else if(v.equals(iv_video))
		{
			Toast.makeText(this, "video", 0).show();
		}
		
		else if(v.equals(iv_warning))
		{
			Toast.makeText(this, "warning", 0).show();
		}
		
		
	}
	
}
