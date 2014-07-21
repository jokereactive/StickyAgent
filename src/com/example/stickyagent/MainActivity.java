package com.example.stickyagent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.Adapters.QuestionsListAdapter;
import com.utils.Utils;

public class MainActivity extends ActionBarActivity implements View.OnClickListener,OnItemClickListener,OnItemSelectedListener{

	private Button add_query,search_button,button1,button2,button3;
	private ImageView iv_search;
	private EditText et_search;
	private Spinner sp_category;
	private ListView lv_questions;
	private QuestionsListAdapter questionsListAdapter;
	private QuestionsListAdapter serverListAdapter;
	private QuestionsListAdapter tempListAdapter;
	private TextView tv_no_questions;
	private LinearLayout ll_search;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.activity_slide_out, R.anim.activity_slide_in);
        initialiseVariable();
        sp_category.setOnItemSelectedListener(this);
        Utils.context=getApplicationContext();
//        search_button.setOnClickListener(this);
        iv_search.setOnClickListener(this);
        add_query.setOnClickListener(this);
//        ll_search.setOnClickListener(this);
        et_search.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				Log.d("", "text change listener");
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
        
    }

    
    

    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(Utils.questionsList.size()!=0){
			lv_questions.setVisibility(View.VISIBLE);
			tv_no_questions.setVisibility(View.GONE);
		questionsListAdapter=new QuestionsListAdapter(getApplicationContext(),"user");
		
		lv_questions.setAdapter(questionsListAdapter);
		lv_questions.setOnItemClickListener(this);
		}else{
			lv_questions.setVisibility(View.GONE);
			tv_no_questions.setVisibility(View.VISIBLE);
		}
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,
				getResources().getStringArray(R.array.Categories));
		sp_category.setAdapter(adapter);
		sp_category.setBackgroundColor(getResources().getColor(android.R.color.black));
		//		questionsListAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.sim)
	}




	private void initialiseVariable() {
		// TODO Auto-generated method stub
		add_query=(Button)findViewById(R.id.b_add);
//		search_button=(Button)findViewById(R.id.b_search);
		iv_search=(ImageView)findViewById(R.id.iv_search);
		button1=(Button)findViewById(R.id.button1);
		button2=(Button)findViewById(R.id.button2);
		button3=(Button)findViewById(R.id.button3);
		et_search=(EditText)findViewById(R.id.et_search);
		sp_category=(Spinner)findViewById(R.id.sp_category);
		lv_questions=(ListView)findViewById(R.id.lv_questions_list);
		tv_no_questions=(TextView)findViewById(R.id.tv_no_queries);
//		ll_search=(LinearLayout)findViewById(R.id.ll_search);
	}


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.equals(add_query)){
			Log.d("", "add query clicked");
			Intent i=new Intent(MainActivity.this, AddQuery.class);
			startActivity(i);
		}
		
		if(v.equals(iv_search)){
			Log.d("", "search clicked");
			Log.d("","server lists size: "+Utils.serverQuestionsList.size());
			lv_questions.setVisibility(View.VISIBLE);
			tv_no_questions.setVisibility(View.GONE);
			serverListAdapter=new QuestionsListAdapter(getApplicationContext(), "server");
			lv_questions.setAdapter(serverListAdapter);
			lv_questions.setOnItemClickListener(this);
//			Handler handler=new Handler();
//			handler.post(new Runnable() {
//				
//				@Override
//				public void run() {
//					serverListAdapter=new QuestionsListAdapter(getApplicationContext(), "server");
//					lv_questions.setAdapter(serverListAdapter);
//					
//				}
//			});
//			lv_questions=null;
//			lv_questions=(ListView)findViewById(R.id.lv_questions_list);
			
		}
		
	}


public void searchButtonClick(){
	Log.d("","search click");
	questionsListAdapter=new QuestionsListAdapter(getApplicationContext(),"server");
	lv_questions.setAdapter(questionsListAdapter);
}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Utils.applicationSession.setLoginStatus("false");
	}




	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Log.d("", "on item click");
		Utils.itemSelected=position;
		Intent i=new Intent(MainActivity.this, ChatActivity.class);
		startActivity(i);
	}

	
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		for(int i=0;i<Utils.serverQuestionsList.size();i++){
			String temp=(Utils.serverQuestionsList.get(i).getCategory());
			if(temp.compareTo(getResources().getStringArray(R.array.Categories)[arg2])==0){
				Utils.tempQuestionList.add(Utils.serverQuestionsList.get(i));
			}
		}
		tempListAdapter = new QuestionsListAdapter(getApplicationContext(), "temp");
		lv_questions.setAdapter(tempListAdapter);
	}




	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

 

}
