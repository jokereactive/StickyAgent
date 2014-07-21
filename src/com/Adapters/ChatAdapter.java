package com.Adapters;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Text;




import com.Datatypes.ChatMessage;
import com.example.stickyagent.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatAdapter extends ArrayAdapter<ChatMessage> {

	private final Context context;
	private final ArrayList al;
	TextView tv;
	ImageView iv;
	
	public ChatAdapter(Context context, int resource, List<ChatMessage> objects) {
		super(context, resource, objects);
		this.context=context;
		this.al=(ArrayList)objects;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		int i;
		ChatMessage cm;
		cm=(ChatMessage) al.get(position);
		if(cm.isUser())
			i=R.layout.cloudtry;
		else
			i=R.layout.cloudtry2;
		View rowView = li.inflate(i, parent, false);
		
		tv=(TextView)rowView.findViewById(R.id.tvMessage);
		tv.setText(cm.getMessage());
		
		tv=(TextView)rowView.findViewById(R.id.tvTime);
		Calendar cl=Calendar.getInstance();
		cl.setTimeInMillis(cm.getTime());
		tv.setText(cl.get(Calendar.HOUR_OF_DAY)+":"+cl.get(Calendar.MINUTE)+":"+cl.get(Calendar.SECOND));
		
		/*iv=(ImageView)rowView.findViewById(R.id.icon);
		if(position%2==0)
			iv.setImageResource(android.R.drawable.arrow_up_float);
		else
			iv.setImageResource(android.R.drawable.arrow_down_float);*/
		return rowView;
	}

}
