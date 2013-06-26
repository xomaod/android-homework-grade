package com.example.gradehomework;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DisplayActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);
		
		Bundle extras = getIntent().getExtras();
		String etAndroid = extras.getString("etAndroid");
		String etiPhone = extras.getString("etiPhone");
		String etWindows = extras.getString("etWindows");
		String etBB = extras.getString("etBB");
		
		String gAndroid = this.calculateGrade(etAndroid);
		String giPhone = this.calculateGrade(etiPhone);
		String gWindows = this.calculateGrade(etWindows);
		String gBB = this.calculateGrade(etBB);
		
		TextView tvAndroid = (TextView) findViewById(R.id.tvAndroid);
		TextView tviPhone = (TextView) findViewById(R.id.tviPhone);
		TextView tvWindows = (TextView) findViewById(R.id.tvWindows);
		TextView tvBB = (TextView) findViewById(R.id.tvBB);
		
		tvAndroid.setText(gAndroid);
		tviPhone.setText(giPhone);
		tvWindows.setText(gWindows);
		tvBB.setText(gBB);
		
		
		//Inflator layout
		LinearLayout mainLayout = (LinearLayout)findViewById(R.id.linearLayoutShowInflator);
		View view = getLayoutInflater().inflate(R.layout.inflator_layout, mainLayout,false);
		mainLayout.addView(view);
		
		//Inflator layout
		LinearLayout mainLayout2 = (LinearLayout)findViewById(R.id.linearLayoutShowInflator);
		View view2 = getLayoutInflater().inflate(R.layout.inflator_layout, mainLayout2,false);
		mainLayout2.addView(view2);
		
		//Inflator layout
		LinearLayout mainLayout3 = (LinearLayout)findViewById(R.id.linearLayoutShowInflator);
		View view3 = getLayoutInflater().inflate(R.layout.inflator_layout, mainLayout3,false);
		mainLayout3.addView(view3);
		
		TextView tvInflator = (TextView) view3.findViewById(R.id.tvInflator1);
		tvInflator.setText("Send text from main activity Send text from main activity Send text from main activity Send text from main activity Send text from main activity Send text from main activity Send text from main activity Send text from main activity Send text from main activity Send text from main activity Send text from main activity Send text from main activity Send text from main activity Send text from main activity Send text from main activity Send text from main activity ");
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display, menu);
		return true;
	}
	
	
	private String calculateGrade(String pointStr){
		
		String grade;
		int point;
		
		point = Integer.parseInt(pointStr);
		
		if(point < 50)grade = "F";
		else if(point < 60 && point >= 50)grade = "D";
		else if(point < 70 && point >= 60)grade = "C";
		else if(point < 80 && point >= 70)grade = "B";
		else grade = "A";
		
		return grade;
		
	}

}
