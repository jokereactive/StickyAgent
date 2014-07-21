package com.Adapters;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.Datatypes.QuestionItem;
import com.example.stickyagent.R;
import com.utils.Utils;

public class QuestionsListAdapter extends BaseAdapter{

	private LayoutInflater inflater;
	private TextView tv_question;
	private Button b_delete;
	private String listName;
//	private ArrayList<QuestionItem> questionsList;
	
	public QuestionsListAdapter(Context context,String listName) {
		Log.d("", "constructor");
		inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.listName=listName;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(listName.equals("server")){
			return Utils.serverQuestionsList.size();
		}
		else if(listName.equals("temp")){
			return Utils.tempQuestionList.size();
		}
		else
		return Utils.questionsList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			convertView=(View)inflater.inflate(R.layout.questions_list_item, null);
			tv_question=(TextView)convertView.findViewById(R.id.tv_questions_list_item);
			b_delete=(Button)convertView.findViewById(R.id.b_delete_questions_list_item);
		}
		Log.d("", "get view");
		if(listName.equals("server"))
		tv_question.setText(Utils.serverQuestionsList.get(position).getTitle());
		else if(listName.equals("temp")){
			tv_question.setText(Utils.tempQuestionList.get(position).getTitle());
		}
		else
			tv_question.setText(Utils.questionsList.get(position).getTitle());
		
		b_delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(listName.equals("server")){
					Utils.serverQuestionsList.remove(position);
				}
				else if(listName.equals("temp")){
					Utils.tempQuestionList.remove(position);
				}
			}
		});
		return convertView;
	}

}
