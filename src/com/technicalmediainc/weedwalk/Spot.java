package com.technicalmediainc.weedwalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Spot extends Activity{

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spot);

	Button admin = (Button) findViewById(R.id.adminButton);
	admin.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {

			startActivity(new Intent(Spot.this, Home.class));
			Spot.this.finish();

		}
	});


}
}
