package com.example.stickyagent;

import android.app.Activity;
import android.os.Bundle;

public class GroupInfo extends Activity{
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_Dialog);
		setContentView(R.layout.groupinfo);
	}
}
