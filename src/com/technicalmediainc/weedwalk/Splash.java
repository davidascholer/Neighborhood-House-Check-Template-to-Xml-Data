package com.technicalmediainc.weedwalk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Splash extends GlobalClass{
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
 		Button next = (Button) findViewById(R.id.nextButton);
 		next.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

				startActivity(new Intent(Splash.this, Home.class));
				Splash.this.finish();

 			}
 		});

 		Button cancel = (Button) findViewById(R.id.cancelButton);
 		cancel.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

 								Splash.this.finish();


 			}
 		});

		
	}
}
