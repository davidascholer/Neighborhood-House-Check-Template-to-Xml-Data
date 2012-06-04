package com.technicalmediainc.weedwalk;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.xmlpull.v1.XmlSerializer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Xml;
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

public class Completed extends GlobalClass {

	TableLayout passTLayout;
	TableLayout failTLayout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.completed);

		passTLayout = (TableLayout) findViewById(R.id.completed_table_layout2);
		failTLayout = (TableLayout) findViewById(R.id.completed_table_layout1);

		/* Create a new row to be added. */
		for (int x = 0; x < PassFailResult.size(); x++) {
			if (PassFailResult.get(x).equalsIgnoreCase("pass")) {
				addPassTableRow(DivStrings.get(x), LotStrings.get(x),
						AdrNumbStrings.get(x) + " " + AdrStreetStrings.get(x),
						PrYrRsltStrings.get(x), ArchRqstStrings.get(x), x);
			}
			if (PassFailResult.get(x).equalsIgnoreCase("fail")) {
				addFailTableRow(DivStrings.get(x), LotStrings.get(x),
						AdrNumbStrings.get(x) + " " + AdrStreetStrings.get(x),
						PrYrRsltStrings.get(x), ArchRqstStrings.get(x), x);
			}

		}

		Button chooser = (Button) findViewById(R.id.completedButton);
		chooser.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Completed.this, Form.class));
				Completed.this.finish();

			}
		});

		// ///////////Button Setup////////////////
		Button home = (Button) findViewById(R.id.homeButton);
		home.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Completed.this, Home.class));
				Completed.this.finish();

			}
		});

		Button assigned = (Button) findViewById(R.id.assignedButton);
		assigned.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Completed.this, Assigned.class));
				Completed.this.finish();

			}
		});

		Button form = (Button) findViewById(R.id.formButton);
		form.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Completed.this, Form.class));
				Completed.this.finish();

			}
		});

		Button picture = (Button) findViewById(R.id.pictureButton);
		picture.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Completed.this, Picture.class));
				Completed.this.finish();

			}
		});

		Button completed = (Button) findViewById(R.id.completedButton);
		completed.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Completed.this, Completed.class));
				Completed.this.finish();

			}
		});

		Button admin = (Button) findViewById(R.id.adminButton);
		admin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Completed.this, Admin.class));
				Completed.this.finish();

			}
		});

		Button help = (Button) findViewById(R.id.helpButton);
		help.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Completed.this, Help.class));
				Completed.this.finish();

			}
		});

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
				R.drawable.yellowtab));
		admin.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.brightyellowtab));
		help.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.brightyellowtab));

		// /////////////////////Button Setup End////////////
//		xmlFileCreator();

	}

	private void addPassTableRow(String sOne, String sTwo, String sThree,
			String sFour, String sFive, int id) {

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
		a.setId(id);

		a.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// check the current check box
				// deleteCheckBoxCheck(a.getId());//

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
		passTLayout.addView(tr, new TableLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

	}

	private void addFailTableRow(String sOne, String sTwo, String sThree,
			String sFour, String sFive, int id) {

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
		a.setId(id);
		//
		a.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// check the current check box
				// deleteCheckBoxCheck(a.getId());

			}
		});

		/* Add View to row. */
		/* Create a View to be the row-content. */
		TextView b = new TextView(this);
		b.setText(sOne);
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
		failTLayout.addView(tr, new TableLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

	}

	private void xmlFileCreator() {
		boolean mExternalStorageAvailable = false;
		boolean mExternalStorageWriteable = false;
		String state = Environment.getExternalStorageState();

		if (Environment.MEDIA_MOUNTED.equals(state)) {
			// We can read and write the media
			mExternalStorageAvailable = mExternalStorageWriteable = true;

			try {
				File root = Environment.getDataDirectory();
				// create a File object for the parent directory
				File filePath = new File(root + "/WeedWalkData/");
				// have the object build the directory structure, if needed.
				filePath.mkdirs();
				File outputXMLPath = new File(root + "/WeedWalkData/");

				if (root.canWrite()) {
					File xmlfile = new File(outputXMLPath,
							"input.xml");
					FileWriter xmlwriter = new FileWriter(xmlfile);

					// ///////////
					// we create a XmlSerializer in order to write xml data
					XmlSerializer serializer = Xml.newSerializer();
					try {
						// we set the FileOutputStream as output for the
						// serializer, using UTF-8 encoding
						serializer.setOutput(xmlwriter);
						// Write <?xml declaration with encoding (if encoding
						// not null) and standalone flag (if standalone not
						// null)
						serializer.startDocument(null, Boolean.valueOf(true));
						// set indentation option
						serializer
								.setFeature(
										"http://xmlpull.org/v1/doc/features.html#indent-output",
										true);
						// start a tag called "root"
						serializer.startTag(null, ROOT);
						// i indent code just to have a view similar to xml-tree
						serializer.startTag(null, INSP_TYPE);
						serializer.text(InspectionType);
						serializer.endTag(null, INSP_TYPE);

						serializer.startTag(null, NAME);
						serializer.text(TeamMemberOneFirst + " "
								+ TeamMemberOneLast);
						serializer.endTag(null, NAME);

						serializer.startTag(null, EMAIL);
						serializer.text(TeamMemberOneEmail);
						serializer.endTag(null, EMAIL);

						if (TeamMemberTwoFirst.equalsIgnoreCase("") == false) {
							serializer.startTag(null, NAME);
							serializer.text(TeamMemberTwoFirst + " "
									+ TeamMemberTwoLast);
							serializer.endTag(null, NAME);

							serializer.startTag(null, EMAIL);
							serializer.text(TeamMemberTwoEmail);
							serializer.endTag(null, EMAIL);
						}

						serializer.startTag(null, DATE_INSP);
						serializer.text(TodaysDate);
						serializer.endTag(null, DATE_INSP);

						serializer.startTag(null, DATE_COMP);
						serializer.text(ComplianceDate);
						serializer.endTag(null, DATE_COMP);

						for (int x = 0; x < PassFailResult.size(); x++) {

							serializer.startTag(null, XML_TAG_CARD_UID);

							serializer.startTag(null, XML_TAG_CARD_DIV);
							serializer.text(DivStrings.get(x));
							serializer.endTag(null, XML_TAG_CARD_DIV);

							serializer.startTag(null, XML_TAG_CARD_LOT);
							serializer.text(LotStrings.get(x));
							serializer.endTag(null, XML_TAG_CARD_LOT);

							serializer.startTag(null, XML_TAG_CARD_ADRNUMB);
							serializer.text(AdrNumbStrings.get(x));
							serializer.endTag(null, XML_TAG_CARD_ADRNUMB);

							serializer.startTag(null, XML_TAG_CARD_ADRSTREET);
							serializer.text(AdrStreetStrings.get(x));
							serializer.endTag(null, XML_TAG_CARD_ADRSTREET);

							serializer.startTag(null, CITY);
							serializer.text("City");
							serializer.endTag(null, CITY);

							serializer.startTag(null, STATE);
							serializer.text("State");
							serializer.endTag(null, STATE);

							serializer.startTag(null, ZIP);
							serializer.text("Zip");
							serializer.endTag(null, ZIP);

							serializer.startTag(null,
									XML_TAG_CARD_PRIOR_YR_RSLT);
							serializer.text(PrYrRsltStrings.get(x));
							serializer.endTag(null, XML_TAG_CARD_PRIOR_YR_RSLT);

							serializer.startTag(null,
									XML_TAG_CARD_APRVD_ARCH_RQST);
							serializer.text(ArchRqstStrings.get(x));
							serializer.endTag(null,
									XML_TAG_CARD_APRVD_ARCH_RQST);

							serializer.startTag(null, RESULT);
							serializer.text(PassFailResult.get(x));
							serializer.endTag(null, RESULT);

							String passFailBoolean = "";
							if (PassFailResult.get(x).equalsIgnoreCase("pass")) {
								passFailBoolean = "true";
							}
							if (PassFailResult.get(x).equalsIgnoreCase("fail")) {
								passFailBoolean = "false";
							}

							serializer.startTag(null, PASSFAIL);
							serializer.attribute(null, ATTRIBUTE_PASSFAIL,
									passFailBoolean);
							serializer.endTag(null, PASSFAIL);

							serializer.startTag(null, FINDINGS);

							// HERE, WRITE A LIST TO ITERATE FOR EACH OF THE
							// FORM DATA COMMENTS

							for (int strImgCount = 0; strImgCount < MAX_FORM_PICS; strImgCount++) {

								int formInfoLocalFormula = (x * MAX_FORM_PICS);

								String sStr = mainFormStringArray.get(
										formInfoLocalFormula + strImgCount)
										.toString();

								String bStr = mainFormBitmapNameArray.get(
										formInfoLocalFormula + strImgCount)
										.toString();

								Bitmap bBit = mainFormBitmapArray
										.get(formInfoLocalFormula + strImgCount);

								if (!sStr.equalsIgnoreCase("")) {
									serializer.startTag(null, FINDING);
									serializer
											.attribute(null,
													ATTRIBUTE_REQUIRED,
													passFailBoolean);
									serializer.attribute(null,
											ATTRIBUTE_COMMENT, sStr);
									serializer.attribute(null, ATTRIBUTE_IMAGE,
											bStr);
									serializer.endTag(null, FINDING);

									try {
										File picFile = new File(filePath, bStr);
										FileOutputStream out = new FileOutputStream(
												picFile);
										bBit.compress(
												Bitmap.CompressFormat.JPEG, 90,
												out);
									} catch (Exception e) {
										e.printStackTrace();
										Log.e("picSave", e.toString());
									}

								}
							}

							// ///////////////////////////////////////
							serializer.startTag(null, FINDINGS_GENERAL_COMMENT);
							serializer.text(Comments.get(x));
							serializer.endTag(null, FINDINGS_GENERAL_COMMENT);

							serializer.endTag(null, FINDINGS);

							serializer.endTag(null, XML_TAG_CARD_UID);
						}
						serializer.endTag(null, ROOT);
						serializer.endDocument();
						// write xml data into the FileOutputStream
						serializer.flush();
						// finally we close the file stream
						xmlwriter.close();

					} catch (Exception e) {
						Log.e("Exception", e.toString());
					}

					// ////////
					BufferedWriter out = new BufferedWriter(xmlwriter);
					out.close();

				}
			} catch (IOException e) {
				Log.e("IOExceptionLogCat", e.toString());
			}

		}
	}

}
