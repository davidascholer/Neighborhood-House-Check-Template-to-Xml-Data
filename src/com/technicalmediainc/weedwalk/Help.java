package com.technicalmediainc.weedwalk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Help extends GlobalClass{
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		
		/////////////Button Setup////////////////
 		Button home = (Button) findViewById(R.id.homeButton);
 		home.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

				startActivity(new Intent(Help.this, Home.class));
				Help.this.finish();

 			}
 		});

 		Button assigned = (Button) findViewById(R.id.assignedButton);
 		assigned.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

				startActivity(new Intent(Help.this, Assigned.class));
				Help.this.finish();


 			}
 		});

 		Button form = (Button) findViewById(R.id.formButton);
 		form.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

				startActivity(new Intent(Help.this, Form.class));
				Help.this.finish();

 			}
 		});

 		Button picture = (Button) findViewById(R.id.pictureButton);
 		picture.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

				startActivity(new Intent(Help.this, Picture.class));
				Help.this.finish();


 			}
 		});

 		Button completed = (Button) findViewById(R.id.completedButton);
 		completed.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

				startActivity(new Intent(Help.this, Completed.class));
				Help.this.finish();

 			}
 		});

 		Button admin = (Button) findViewById(R.id.adminButton);
 		admin.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

				startActivity(new Intent(Help.this, Admin.class));
				Help.this.finish();


 			}
 		});

 		Button help = (Button) findViewById(R.id.helpButton);
 		help.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

				startActivity(new Intent(Help.this, Help.class));
				Help.this.finish();

 			}
 		});

		switch (CURRENT_TAB) {
		case 0:
			home.setClickable(true);
			assigned.setClickable(false);
			form.setClickable(false);
			picture.setClickable(false);
			completed.setClickable(false);
			admin.setClickable(true);
			help.setClickable(true);

			home.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			assigned.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.checkedtab));
			form.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.checkedtab));
			picture.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.checkedtab));
			completed.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.checkedtab));
			admin.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			help.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.yellowtab));

			break;
			
		case 1:
			home.setClickable(true);
			assigned.setClickable(true);
			form.setClickable(false);
			picture.setClickable(false);
			completed.setClickable(false);
			admin.setClickable(true);
			help.setClickable(true);

			home.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			assigned.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			form.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.checkedtab));
			picture.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.checkedtab));
			completed.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.checkedtab));
			admin.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			help.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.yellowtab));

			break;

		case 2:
			home.setClickable(true);
			assigned.setClickable(true);
			form.setClickable(true);
			picture.setClickable(false);
			completed.setClickable(false);
			admin.setClickable(true);
			help.setClickable(true);

			home.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			assigned.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			form.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			picture.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.checkedtab));
			completed.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.checkedtab));
			admin.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			help.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.yellowtab));

			break;

		case 3:
			home.setClickable(true);
			assigned.setClickable(true);
			form.setClickable(true);
			picture.setClickable(true);
			completed.setClickable(false);
			admin.setClickable(true);
			help.setClickable(true);

			home.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			assigned.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			form.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			picture.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			completed.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.checkedtab));
			admin.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			help.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.yellowtab));

			break;

		case 4:
			home.setClickable(true);
			assigned.setClickable(true);
			form.setClickable(true);
			picture.setClickable(true);
			completed.setClickable(true);
			admin.setClickable(true);
			help.setClickable(true);

			home.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			assigned.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			form.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			picture.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			completed.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			admin.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));
			help.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.yellowtab));

			break;

		default:

			break;

		}

 		///////////////////////Button Setup End////////////
	}
}
