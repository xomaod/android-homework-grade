package com.example.gradehomework;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText etAndroid = (EditText) findViewById(R.id.etAndroid);
		final EditText etiPhone = (EditText) findViewById(R.id.etiPhone);
		final EditText etWindows = (EditText) findViewById(R.id.etWindows);
		final EditText etBB = (EditText) findViewById(R.id.etBB);
		
		etAndroid.requestFocus();
		
		final ImageView imgButton = (ImageView) findViewById(R.id.imageView1);
        imgButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	//Toast.makeText(getApplicationContext(), "Let's check the grades", 5).show();
				
				//Check empty value
				if(etAndroid.getText().toString().matches("")){
					etAndroid.requestFocus();
					Toast.makeText(getApplicationContext(), "Please enter Android points", 10).show();
				}else if(etiPhone.getText().toString().matches("")){
					etiPhone.requestFocus();
					Toast.makeText(getApplicationContext(), "Please enter iPhone points", 10).show();
				}else if(etWindows.getText().toString().matches("")){
					etWindows.requestFocus();
					Toast.makeText(getApplicationContext(), "Please enter Windows points", 10).show();
				}else if(etBB.getText().toString().matches("")){
					etBB.requestFocus();
					Toast.makeText(getApplicationContext(), "Please enter BlackBerry points", 10).show();
				}else{
					
					//To display the grade on next screen after Alert box
					final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
    				alert.setTitle("To be calculated..");
    				alert.setMessage("Are you sure to display all grades ?");
    				alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    						public void onClick(DialogInterface dialog, int whichButton) {
    							
    							//Change activity and send data to the next activity
    							Intent i = new Intent(MainActivity.this, DisplayActivity.class);
    							i.putExtra("etAndroid", etAndroid.getText().toString());
    							i.putExtra("etiPhone", etiPhone.getText().toString());
    							i.putExtra("etWindows", etWindows.getText().toString());
    							i.putExtra("etBB", etBB.getText().toString());
    							startActivity(i);
    							
    						}
    				});

    				alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    						public void onClick(DialogInterface dialog, int whichButton) {
    							
    							Toast.makeText(getApplicationContext(), "Edit point each subject again", 10).show();
    						
    						}
    				});
    				alert.show();

    		
       
					
				}
            }
            
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
