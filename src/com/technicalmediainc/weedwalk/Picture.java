package com.technicalmediainc.weedwalk;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Picture extends GlobalClass {
 
	private static final int CAMERA_PIC_REQUEST = 1337;
	private int totalPics = 0;
	int formInfoLocalFormula;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.picture);


		TextView divText = (TextView) findViewById(R.id.formHomeDivLotTextView);
		divText.setText(DivStrings.get(0) + " / " + LotStrings.get(0));
		TextView addressText = (TextView) findViewById(R.id.formHomeAddressTextView);
		addressText.setText(AdrNumbStrings.get(0) + " "
				+ AdrStreetStrings.get(0));

		Button button = (Button) findViewById(R.id.takePictureButton);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				takePicture();
			}
		});

		Button doneButton = (Button) findViewById(R.id.alldoneButton);
		doneButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				CURRENT_TAB = 4;
				PassFailFormStringArray[1] = "";
				PassFailFormStringArray[2] = "";
				PassFailFormStringArray[3] = "";
				PassFailFormStringArray[4] = "";
				PassFailFormStringArray[5] = "";
				PassFailFormStringArray[6] = "";

				 startActivity(new Intent(Picture.this, Completed.class));
				saveStrings();
				Picture.this.finish();

			}
		});

		// ///////////Button Setup////////////////
		Button home = (Button) findViewById(R.id.homeButton);
		home.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Picture.this, Home.class));
				Picture.this.finish();

			}
		});

		Button assigned = (Button) findViewById(R.id.assignedButton);
		assigned.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Picture.this, Assigned.class));
				Picture.this.finish();

			}
		});

		Button form = (Button) findViewById(R.id.formButton);
		form.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Picture.this, Form.class));
				Picture.this.finish();

			}
		});

		Button picture = (Button) findViewById(R.id.pictureButton);
		picture.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Picture.this, Picture.class));
				Picture.this.finish();

			}
		});

		Button completed = (Button) findViewById(R.id.completedButton);
		completed.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Picture.this, Completed.class));
				Picture.this.finish();

			}
		});

		Button admin = (Button) findViewById(R.id.adminButton);
		admin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Picture.this, Admin.class));
				Picture.this.finish();

			}
		});

		Button help = (Button) findViewById(R.id.helpButton);
		help.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Picture.this, Help.class));
				Picture.this.finish();

			}
		});

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
				R.drawable.yellowtab));
		completed.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.checkedtab));
		admin.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.brightyellowtab));
		help.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.brightyellowtab));

		// /////////////////////Button Setup End////////////

	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			if (requestCode == CAMERA_PIC_REQUEST) {
				// do something
				Bitmap thumbnail = (Bitmap) data.getExtras().get("data");

				totalPics++;

				ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
				ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
				ImageView iv3 = (ImageView) findViewById(R.id.imageView3);
				ImageView iv4 = (ImageView) findViewById(R.id.imageView4);
				ImageView iv5 = (ImageView) findViewById(R.id.imageView5);
				ImageView iv6 = (ImageView) findViewById(R.id.imageView6);

				EditText et1 = (EditText) findViewById(R.id.editText1);
				EditText et2 = (EditText) findViewById(R.id.editText2);
				EditText et3 = (EditText) findViewById(R.id.editText3);
				EditText et4 = (EditText) findViewById(R.id.editText4);
				EditText et5 = (EditText) findViewById(R.id.editText5);
				EditText et6 = (EditText) findViewById(R.id.editText6);

				if (totalPics == 1) {
					iv1.setImageBitmap(thumbnail);
					mainFormBitmapArray.remove(formInfoLocalFormula + 0);
					mainFormBitmapArray
							.add(formInfoLocalFormula + 0, thumbnail);
					Date cal = Calendar.getInstance().getTime();
					mainFormBitmapNameArray.add(
							formInfoLocalFormula + 0,
							cal.getDate() + "_" + cal.getMonth() + "_"
									+ cal.getYear() + "_" + cal.getHours()
									+ "_" + cal.getMinutes() + "_"
									+ cal.getSeconds() + ".jpeg");
					iv2.setVisibility(View.VISIBLE);
					et2.setVisibility(View.VISIBLE);
				}
				if (totalPics == 2) {
					iv2.setImageBitmap(thumbnail);
					mainFormBitmapArray.remove(formInfoLocalFormula + 1);
					mainFormBitmapArray
							.add(formInfoLocalFormula + 1, thumbnail);
					Date cal = Calendar.getInstance().getTime();
					mainFormBitmapNameArray.add(
							formInfoLocalFormula + 1,
							cal.getDate() + "_" + cal.getMonth() + "_"
									+ cal.getYear() + "_" + cal.getHours()
									+ "_" + cal.getMinutes() + "_"
									+ cal.getSeconds() + ".jpeg");
					iv3.setVisibility(View.VISIBLE);
					et3.setVisibility(View.VISIBLE);
				}
				if (totalPics == 3) {
					iv3.setImageBitmap(thumbnail);
					mainFormBitmapArray.remove(formInfoLocalFormula + 2);
					mainFormBitmapArray
							.add(formInfoLocalFormula + 2, thumbnail);
					Date cal = Calendar.getInstance().getTime();
					mainFormBitmapNameArray.add(
							formInfoLocalFormula + 2,
							cal.getDate() + "_" + cal.getMonth() + "_"
									+ cal.getYear() + "_" + cal.getHours()
									+ "_" + cal.getMinutes() + "_"
									+ cal.getSeconds() + ".jpeg");
					iv4.setVisibility(View.VISIBLE);
					et4.setVisibility(View.VISIBLE);
				}
				if (totalPics == 4) {
					iv4.setImageBitmap(thumbnail);
					mainFormBitmapArray.remove(formInfoLocalFormula + 3);
					mainFormBitmapArray
							.add(formInfoLocalFormula + 3, thumbnail);
					Date cal = Calendar.getInstance().getTime();
					mainFormBitmapNameArray.add(
							formInfoLocalFormula + 3,
							cal.getDate() + "_" + cal.getMonth() + "_"
									+ cal.getYear() + "_" + cal.getHours()
									+ "_" + cal.getMinutes() + "_"
									+ cal.getSeconds() + ".jpeg");
					iv5.setVisibility(View.VISIBLE);
					et5.setVisibility(View.VISIBLE);
				}
				if (totalPics == 5) {
					iv5.setImageBitmap(thumbnail);
					mainFormBitmapArray.remove(formInfoLocalFormula + 4);
					mainFormBitmapArray
							.add(formInfoLocalFormula + 4, thumbnail);
					Date cal = Calendar.getInstance().getTime();
					mainFormBitmapNameArray.add(
							formInfoLocalFormula + 4,
							cal.getDate() + "_" + cal.getMonth() + "_"
									+ cal.getYear() + "_" + cal.getHours()
									+ "_" + cal.getMinutes() + "_"
									+ cal.getSeconds() + ".jpeg");
					iv6.setVisibility(View.VISIBLE);
					et6.setVisibility(View.VISIBLE);
				}
				if (totalPics == 6) {
					iv6.setImageBitmap(thumbnail);
					mainFormBitmapArray.remove(formInfoLocalFormula + 5);
					mainFormBitmapArray
							.add(formInfoLocalFormula + 5, thumbnail);
					Date cal = Calendar.getInstance().getTime();
					mainFormBitmapNameArray.add(
							formInfoLocalFormula + 5,
							cal.getDate() + "_" + cal.getMonth() + "_"
									+ cal.getYear() + "_" + cal.getHours()
									+ "_" + cal.getMinutes() + "_"
									+ cal.getSeconds() + ".jpeg");
					Button button = (Button) findViewById(R.id.pictureButton);
					button.setEnabled(false);
					button.setClickable(false);
				}
			}

		}
	}

	private void takePicture() {

		Intent cameraIntent = new Intent(
				android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

		try {
			startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
		} catch (RuntimeException e) {
			createDialog();
		}

	}

	public void createDialog() {
		TextView myMsg = new TextView(this);
		myMsg.setText("A problem occured with the camera application.");
		myMsg.setGravity(Gravity.CENTER_HORIZONTAL);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setView(myMsg).setCancelable(true)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						return;
					}
				});
		AlertDialog alert = builder.create();
		alert.show();

	}

	private void saveStrings() {

		EditText et1 = (EditText) findViewById(R.id.editText1);
		EditText et2 = (EditText) findViewById(R.id.editText2);
		EditText et3 = (EditText) findViewById(R.id.editText3);
		EditText et4 = (EditText) findViewById(R.id.editText4);
		EditText et5 = (EditText) findViewById(R.id.editText5);
		EditText et6 = (EditText) findViewById(R.id.editText6);

		formInfoLocalFormula = (CURRENT_HOME * MAX_FORM_PICS);

		mainFormStringArray.remove(formInfoLocalFormula);
		mainFormStringArray.add(formInfoLocalFormula, et1.getText().toString().replaceAll("\"",
				 "'")
				 .replaceAll("&", "&amp;").replaceAll("<", "&lt;"));
		mainFormStringArray.remove(formInfoLocalFormula + 1);
		mainFormStringArray.add(formInfoLocalFormula + 1, et2.getText().toString().replaceAll("\"",
				 "'")
				 .replaceAll("&", "&amp;").replaceAll("<", "&lt;"));
		mainFormStringArray.remove(formInfoLocalFormula + 2);
		mainFormStringArray.add(formInfoLocalFormula + 2, et3.getText().toString().replaceAll("\"",
				 "'")
				 .replaceAll("&", "&amp;").replaceAll("<", "&lt;"));
		mainFormStringArray.remove(formInfoLocalFormula + 3);
		mainFormStringArray.add(formInfoLocalFormula + 3, et4.getText().toString().replaceAll("\"",
				 "'")
				 .replaceAll("&", "&amp;").replaceAll("<", "&lt;"));
		mainFormStringArray.remove(formInfoLocalFormula + 4);
		mainFormStringArray.add(formInfoLocalFormula + 4, et5.getText().toString().replaceAll("\"",
				 "'")
				 .replaceAll("&", "&amp;").replaceAll("<", "&lt;"));
		mainFormStringArray.remove(formInfoLocalFormula + 5);
		mainFormStringArray.add(formInfoLocalFormula + 5, et6.getText().toString().replaceAll("\"",
				 "'")
				 .replaceAll("&", "&amp;").replaceAll("<", "&lt;"));
	}
	private void fillPics(){
		ArrayList<String> text = new ArrayList<String>();
		ArrayList<Bitmap> bName = new ArrayList<Bitmap>();

		formInfoLocalFormula = (CURRENT_HOME * MAX_FORM_PICS);
		for(int c = 0; c < 6; c++){
			if(!mainFormStringArray.get(formInfoLocalFormula + c).trim().equalsIgnoreCase("")){
				text.add(mainFormStringArray.get(formInfoLocalFormula + c));
				bName.add(mainFormBitmapArray.get(formInfoLocalFormula + c));
			}
		}
		ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
		ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
		ImageView iv3 = (ImageView) findViewById(R.id.imageView3);
		ImageView iv4 = (ImageView) findViewById(R.id.imageView4);
		ImageView iv5 = (ImageView) findViewById(R.id.imageView5);
		ImageView iv6 = (ImageView) findViewById(R.id.imageView6);

		EditText et1 = (EditText) findViewById(R.id.editText1);
		EditText et2 = (EditText) findViewById(R.id.editText2);
		EditText et3 = (EditText) findViewById(R.id.editText3);
		EditText et4 = (EditText) findViewById(R.id.editText4);
		EditText et5 = (EditText) findViewById(R.id.editText5);
		EditText et6 = (EditText) findViewById(R.id.editText6);

		for(int z = 0; z < text.size(); z++){
			if(z == 0){
				iv1.setImageBitmap(bName.get(0));
				et1.setText(text.get(0));
			}else if(z == 1){
				iv2.setImageBitmap(bName.get(1));
				et2.setText(text.get(1));
			}else if(z == 2){
				iv3.setImageBitmap(bName.get(2));
				et3.setText(text.get(2));
			}else if(z == 3){ 
				iv4.setImageBitmap(bName.get(3));
				et4.setText(text.get(3));
			}else if(z == 4){
				iv5.setImageBitmap(bName.get(4));
				et5.setText(text.get(4));
			}else if(z == 5){
				iv6.setImageBitmap(bName.get(5));
				et6.setText(text.get(5));
			}
			totalPics++;
		}

	}
}
