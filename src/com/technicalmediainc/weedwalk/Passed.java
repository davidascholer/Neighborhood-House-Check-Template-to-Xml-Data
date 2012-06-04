package com.technicalmediainc.weedwalk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Passed extends GlobalClass {

	CheckBox top;
	CheckBox bottom;
	LinearLayout linLayout;
	Bitmap[] tempFormBitmap;
	EditText etOne;
	EditText etTwo;
	EditText etThree;
	EditText etFour;
	EditText etFive;
	EditText etSix;
	EditText etSeven;
	EditText etComments;
	int formInfoLocalFormula;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.passed);

		etOne = (EditText) findViewById(R.id.flowerDiscEditText);
		etTwo = (EditText) findViewById(R.id.paintDiscEditText);
		etThree = (EditText) findViewById(R.id.sidewalksDiscEditText);
		etFour = (EditText) findViewById(R.id.stepsDiscEditText);
		etFive = (EditText) findViewById(R.id.decksDiscEditText);
		etSix = (EditText) findViewById(R.id.maintDiscEditText);
		etComments = (EditText) findViewById(R.id.commentsEditText);

		etOne.setText(PassFailFormStringArray[1]);
		etTwo.setText(PassFailFormStringArray[2]);
		etThree.setText(PassFailFormStringArray[3]);
		etFour.setText(PassFailFormStringArray[4]);
		etFive.setText(PassFailFormStringArray[5]);
		etSix.setText(PassFailFormStringArray[6]);
//		etComments.setText(Comments.get(CURRENT_HOME));

		TextView divText = (TextView) findViewById(R.id.formHomeDivLotTextView);
		divText.setText(DivStrings.get(CURRENT_HOME) + " / "
				+ LotStrings.get(CURRENT_HOME));
		TextView addressText = (TextView) findViewById(R.id.formHomeAddressTextView);
		addressText.setText(AdrNumbStrings.get(CURRENT_HOME) + " "
				+ AdrStreetStrings.get(CURRENT_HOME));

		top = (CheckBox) findViewById(R.id.noFurtherActionCheckBox);
		bottom = (CheckBox) findViewById(R.id.recomCheckBox);
		linLayout = (LinearLayout) findViewById(R.id.passedLinLayout);

		if (passedFormNoFurtherAction == true) {
			top.setChecked(true);
			bottom.setChecked(false);
		} else {
			linLayout.setVisibility(View.VISIBLE);
			top.setChecked(false);
			bottom.setChecked(true);
		}

		top.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (top.isChecked() == true) {
					passedFormNoFurtherAction = true;
					if (bottom.isChecked() == true) {
						bottom.setChecked(false);
						linLayout.setVisibility(View.INVISIBLE);
					} else {
						top.setChecked(true);
					}
				} else {
					passedFormNoFurtherAction = false;
					if (bottom.isChecked() == false) {
						top.setChecked(true);
					}
				}

			}
		});

		bottom.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (bottom.isChecked() == true) {
					if (top.isChecked() == true) {
						top.setChecked(false);
						linLayout.setVisibility(View.VISIBLE);
					} else {
						bottom.setChecked(true);
					}
				} else {
					if (top.isChecked() == false) {
						bottom.setChecked(true);
					}
				}

			}
		});

		Button completeButton = (Button) findViewById(R.id.completeButton);
		completeButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				saveData();
				if (top.isChecked() == true) {
					CURRENT_TAB = 4;
					startActivity(new Intent(Passed.this, Completed.class));
				} else {
					CURRENT_TAB = 3;
					startActivity(new Intent(Passed.this, Picture.class));
				}
				Passed.this.finish();

			}
		});

		Button cancelButton = (Button) findViewById(R.id.cancelButton);
		cancelButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				createDialog();
			}
		});
		ImageButton iv1 = (ImageButton) findViewById(R.id.pPictureImageView1);
		iv1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				CURRENT_TAB = 4;
				startActivity(new Intent(Passed.this, Picture.class));

			}
		});
		ImageButton iv2 = (ImageButton) findViewById(R.id.pPictureImageView2);
		iv2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				CURRENT_TAB = 4;
				startActivity(new Intent(Passed.this, Picture.class));

			}
		});
		ImageButton iv3 = (ImageButton) findViewById(R.id.pPictureImageView3);
		iv3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				CURRENT_TAB = 4;
				startActivity(new Intent(Passed.this, Picture.class));

			}
		});
		ImageButton iv4 = (ImageButton) findViewById(R.id.pPictureImageView4);
		iv4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				CURRENT_TAB = 4;
				startActivity(new Intent(Passed.this, Picture.class));

			}
		});
		ImageButton iv5 = (ImageButton) findViewById(R.id.pPictureImageView5);
		iv5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				CURRENT_TAB = 4;
				startActivity(new Intent(Passed.this, Picture.class));

			}
		});
		ImageButton iv6 = (ImageButton) findViewById(R.id.pPictureImageView6);
		iv6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				CURRENT_TAB = 4;
				startActivity(new Intent(Passed.this, Picture.class));

			}
		});

	}

	private void createDialog() {
		TextView myMsg = new TextView(this);
		myMsg.setText("Are you sure you want to exit?");
		myMsg.setGravity(Gravity.CENTER_HORIZONTAL);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setView(myMsg)
				.setCancelable(true)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						startActivity(new Intent(Passed.this, Form.class));
						Passed.this.finish();

						return;
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								return;
							}
						});
		AlertDialog alert = builder.create();
		alert.show();

	}

	private void saveData(){
		
		PassFailResult.remove(CURRENT_HOME);
		PassFailResult.add(CURRENT_HOME, "pass");

//		ASSIGNED_HOUSE_ID_ARRAY.remove(CURRENT_HOME);
//		FAILED_HOUSE_ID_ARRAY.add(CURRENT_HOME);
		
			
		PassFailFormStringArray[1] = etOne.getText().toString();
		PassFailFormStringArray[2] = etTwo.getText().toString();
		PassFailFormStringArray[3] = etThree.getText().toString();
		PassFailFormStringArray[4] = etFour.getText().toString();
		PassFailFormStringArray[5] = etFive.getText().toString();
		PassFailFormStringArray[6] = etSix.getText().toString();
		

//			mainFormBitmapArray.remove(formInfoLocalFormula);
//			mainFormBitmapArray.add(CURRENT_HOME, null);
//			mainFormBitmapNameArray.remove(formInfoLocalFormula);
//			mainFormBitmapNameArray.add(CURRENT_HOME, "");
		
		
		Comments.remove(CURRENT_HOME);
		Comments.add(CURRENT_HOME,
				etComments.getText().toString().replaceAll("\"", "'").replaceAll("&", "&amp;").replaceAll("<", "&lt;"));
			
		}

}
