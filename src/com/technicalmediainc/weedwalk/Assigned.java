package com.technicalmediainc.weedwalk;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class Assigned extends GlobalClass {

	TableLayout tLayout;

	int tempPrevHome = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.assigned);

		TextView tv = (TextView) findViewById(R.id.textView1);
		String tvString = "Inspection Team: " + TeamMemberOneFirst + " "
				+ TeamMemberOneLast;
		if (TeamMemberTwoFirst.equals("") == false) {
			tvString += " and " + TeamMemberTwoFirst + " " + TeamMemberTwoLast;
		}
		tv.setText(tvString);
		tLayout = (TableLayout) findViewById(R.id.assigned_table_layout);

		// This is the method to get the new CURRENT_HOME, otherwise, an error
		// will occur
		for (int curHomeCounter = 0; curHomeCounter < PassFailResult.size(); curHomeCounter++) {
			if (INSPECTION_TYPE == 0) {
				if (PassFailResult.get(curHomeCounter).equalsIgnoreCase(
						"assigned")) {
					CURRENT_HOME = curHomeCounter;
					break;
				} else if (INSPECTION_TYPE == 1) {
					if (PassFailResult.get(curHomeCounter).equalsIgnoreCase(
							"fail")) {
						CURRENT_HOME = curHomeCounter;
						break;
					}
				}
			}
		}

		/* Create a new row to be added. */
		for (int x = 0; x < PassFailResult.size(); x++) {
			if (INSPECTION_TYPE == 0) {
				if (PassFailResult.get(x).equalsIgnoreCase("assigned")) {
					addTableRow(
							DivStrings.get(x),
							LotStrings.get(x),
							AdrNumbStrings.get(x) + " "
									+ AdrStreetStrings.get(x),
							PrYrRsltStrings.get(x), ArchRqstStrings.get(x), x);
				}
			}else if (INSPECTION_TYPE == 1) {
				if (PassFailResult.get(x).equalsIgnoreCase("fail")) {
					CURRENT_HOME = x;
					addTableRow(
							DivStrings.get(x),
							LotStrings.get(x),
							AdrNumbStrings.get(x) + " "
									+ AdrStreetStrings.get(x),
							PrYrRsltStrings.get(x), ArchRqstStrings.get(x), x);
				}

			}
		}
		if (UidStrings.isEmpty()) {
		for (int y = 0; y < PassFailResult.size(); y++) {
				UidStrings.add(DivStrings.get(y) + LotStrings.get(y));
			}
		}

		Button openButton = (Button) findViewById(R.id.assignedOpenButton);
		openButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				CURRENT_TAB = 2;
				initialAssignedClass = false;
				startActivity(new Intent(Assigned.this, Form.class));
				Assigned.this.finish();

			}
		});
		openButton.setEnabled(false);

		// ///////////Button Setup////////////////
		Button home = (Button) findViewById(R.id.homeButton);
		home.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Assigned.this, Home.class));
				Assigned.this.finish();

			}
		});

		Button assigned = (Button) findViewById(R.id.assignedButton);
		assigned.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Assigned.this, Assigned.class));
				Assigned.this.finish();

			}
		});

		Button form = (Button) findViewById(R.id.formButton);
		form.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Assigned.this, Form.class));
				Assigned.this.finish();

			}
		});

		Button picture = (Button) findViewById(R.id.pictureButton);
		picture.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Assigned.this, Picture.class));
				Assigned.this.finish();

			}
		});

		Button completed = (Button) findViewById(R.id.completedButton);
		completed.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Assigned.this, Completed.class));
				Assigned.this.finish();

			}
		});

		Button admin = (Button) findViewById(R.id.adminButton);
		admin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Assigned.this, Admin.class));
				Assigned.this.finish();

			}
		});

		Button help = (Button) findViewById(R.id.helpButton);
		help.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Assigned.this, Help.class));
				Assigned.this.finish();

			}
		});

		home.setClickable(true);
		assigned.setClickable(false);
		form.setClickable(false);
		picture.setClickable(false);
		completed.setClickable(true);
		admin.setClickable(true);
		help.setClickable(true);

		home.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.brightyellowtab));
		assigned.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.yellowtab));
		form.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.checkedtab));
		picture.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.checkedtab));
		completed.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.brightyellowtab));
		admin.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.brightyellowtab));
		help.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.brightyellowtab));

		// /////////////////////Button Setup End////////////

	}

	private void addTableRow(String sOne, String sTwo, String sThree,
			String sFour, String sFive, int houseCount) {

		TableRow tr = new TableRow(this);
		tr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));
		tr.setGravity(Gravity.CENTER);

		/* Create a View to be the row-content. */
		final CheckBox a = new CheckBox(this);
		a.setGravity(Gravity.CENTER_HORIZONTAL);
		a.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT, .5f));

		a.setChecked(false);

		// a.setId(ASSIGNED_HOUSE_ID_ARRAY.get(houseCount));
		a.setId(houseCount);

		houseCount++;

		a.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// check the current check box
				deleteCheckBoxCheck(a.getId());

			}
		});

		/* Add View to row. */
		/* Create a View to be the row-content. */
		TextView b = new TextView(this);
		b.setText(sOne);
		b.setGravity(Gravity.CENTER);
		b.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, .5f));
		/* Add View to row. */

		/* Create a View to be the row-content. */
		TextView c = new TextView(this);
		c.setText(sTwo);
		c.setGravity(Gravity.CENTER);
		c.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, .5f));
		/* Add View to row. */

		/* Create a View to be the row-content. */
		TextView d = new TextView(this);
		d.setText(sThree);
		d.setGravity(Gravity.CENTER);
		d.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, 1.5f));
		/* Add View to row. */

		/* Create a View to be the row-content. */
		TextView e = new TextView(this);
		e.setText(sFour);
		e.setGravity(Gravity.CENTER);
		e.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, .2f));

		/* Add View to row. */

		/* Create a View to be the row-content. */
		TextView f = new TextView(this);
		f.setText(sFive);
		f.setGravity(Gravity.CENTER);
		f.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, .2f));
		/* Add Views to row. */
		tr.addView(a);
		tr.addView(b);
		tr.addView(c);
		tr.addView(d);
		tr.addView(e);
		tr.addView(f);
		/* Add row to TableLayout. */
		tLayout.addView(tr, new TableLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

	}

	private void deleteCheckBoxCheck(int id) {

		CheckBox tempCheckBoxOne = (CheckBox) findViewById(CURRENT_HOME);
		CheckBox tempCheckBoxTwo = (CheckBox) findViewById(id);
		Button openButton = (Button) findViewById(R.id.assignedOpenButton);

		if (id != CURRENT_HOME) {
			tempCheckBoxOne.setChecked(false);
			// }else{
			// tempCheckBoxOne.toggle();
		}
		CURRENT_HOME = id;

		if (tempCheckBoxTwo.isChecked() == true) {
			openButton.setClickable(true);
			openButton.setFocusable(true);
			openButton.setFocusableInTouchMode(true);
			openButton.setEnabled(true);
		} else {
			openButton.setClickable(false);
			openButton.setFocusable(false);
			openButton.setFocusableInTouchMode(false);
			openButton.setEnabled(false);

		}
	}

}
