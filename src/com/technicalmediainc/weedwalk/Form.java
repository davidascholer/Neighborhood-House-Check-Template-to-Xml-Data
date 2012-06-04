package com.technicalmediainc.weedwalk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Form extends GlobalClass{
	
	Button passButton;
	Button failButton;
	Button cancelButton;
	Button home;
	Button assigned;
	Button form;
	Button picture;
	Button completed;
	Button admin;
	Button help;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form);
		

		TextView divText = (TextView) findViewById(R.id.formHomeDivLotTextView);
		divText.setText(DivStrings.get(CURRENT_HOME) + " / " + LotStrings.get(CURRENT_HOME));
		TextView addressText = (TextView) findViewById(R.id.formHomeAddressTextView);
		addressText.setText(AdrNumbStrings.get(CURRENT_HOME) + " " + AdrStreetStrings.get(CURRENT_HOME));

		passButton = (Button) findViewById(R.id.passButton);
		passButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				saveData();
				startActivity(new Intent(Form.this, Passed.class));
				Form.this.finish();

			}
		});

		failButton = (Button) findViewById(R.id.failButton);
		failButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				saveData();
				startActivity(new Intent(Form.this, Failed.class));
				Form.this.finish();

			}
		});

		
		cancelButton = (Button) findViewById(R.id.formCancelButton);
		cancelButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				CURRENT_TAB = 1;
				startActivity(new Intent(Form.this, Assigned.class));
				Form.this.finish();

			}
		});
		/////////////Button Setup////////////////
 		home = (Button) findViewById(R.id.homeButton);
 		home.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

 				CURRENT_TAB = 0;
				startActivity(new Intent(Form.this, Home.class));
				Form.this.finish();

 			}
 		});

 		assigned = (Button) findViewById(R.id.assignedButton);
 		assigned.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

 				CURRENT_TAB = 1;
				startActivity(new Intent(Form.this, Assigned.class));
				Form.this.finish();


 			}
 		});

 		form = (Button) findViewById(R.id.formButton);
 		form.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

				startActivity(new Intent(Form.this, Form.class));
				Form.this.finish();

 			}
 		});

 		picture = (Button) findViewById(R.id.pictureButton);
 		picture.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

				startActivity(new Intent(Form.this, Picture.class));
				Form.this.finish();


 			}
 		});

 		completed = (Button) findViewById(R.id.completedButton);
 		completed.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

				startActivity(new Intent(Form.this, Completed.class));
				Form.this.finish();

 			}
 		});

 		admin = (Button) findViewById(R.id.adminButton);
 		admin.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

				startActivity(new Intent(Form.this, Admin.class));
				Form.this.finish();


 			}
 		});

 		help = (Button) findViewById(R.id.helpButton);
 		help.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

				startActivity(new Intent(Form.this, Help.class));
				Form.this.finish();

 			}
 		});

		home.setClickable(true);
		assigned.setClickable(true);
		form.setClickable(false);
		picture.setClickable(false);
		completed.setClickable(false);
		admin.setClickable(true);
		help.setClickable(true);
		
		home.setBackgroundDrawable(getResources().getDrawable(R.drawable.brightyellowtab));
		assigned.setBackgroundDrawable(getResources().getDrawable(R.drawable.brightyellowtab));
		form.setBackgroundDrawable(getResources().getDrawable(R.drawable.yellowtab));
		picture.setBackgroundDrawable(getResources().getDrawable(R.drawable.checkedtab));
		completed.setBackgroundDrawable(getResources().getDrawable(R.drawable.checkedtab));
		admin.setBackgroundDrawable(getResources().getDrawable(R.drawable.brightyellowtab));
		help.setBackgroundDrawable(getResources().getDrawable(R.drawable.brightyellowtab));

 		///////////////////////Button Setup End////////////

	}
	
	private void saveData(){
		
		
		
	}
}
