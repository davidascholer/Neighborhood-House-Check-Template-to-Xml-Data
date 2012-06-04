package com.technicalmediainc.weedwalk;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.xmlpull.v1.XmlSerializer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Xml;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Admin extends GlobalClass {

	String errorString = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin);

		Button closeOut = (Button) findViewById(R.id.closeoutButton);
		closeOut.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				boolean notNA = true;
				for (int iter = 0; iter < PassFailResult.size(); iter++) {
					if (PassFailResult.get(iter).equalsIgnoreCase("na") == true) {
						notNA = false;
					}
				}

				if (notNA == true) {
					createCloseoutDialog();
				} else {
					createCloseoutDialogError();
				}
			}
		});

		TextView fileChoose = (TextView) findViewById(R.id.importTextView);
		fileChoose.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				loadFileChooser();
			}
		});

		Button importFileButton = (Button) findViewById(R.id.importButton);
		importFileButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// TextView fileChoose = (TextView)
				// findViewById(R.id.importTextView);
				// fileChoose.setText(fileName);
				startActivity(new Intent(Admin.this, Home.class));
				Admin.this.finish();

			}
		});

		// ///////////Button Setup////////////////
		Button home = (Button) findViewById(R.id.homeButton);
		home.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Admin.this, Home.class));
				Admin.this.finish();

			}
		});

		Button assigned = (Button) findViewById(R.id.assignedButton);
		assigned.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Admin.this, Assigned.class));
				Admin.this.finish();

			}
		});

		Button form = (Button) findViewById(R.id.formButton);
		form.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Admin.this, Form.class));
				Admin.this.finish();

			}
		});

		Button picture = (Button) findViewById(R.id.pictureButton);
		picture.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Admin.this, Picture.class));
				Admin.this.finish();

			}
		});

		Button completed = (Button) findViewById(R.id.completedButton);
		completed.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Admin.this, Completed.class));
				Admin.this.finish();

			}
		});

		Button admin = (Button) findViewById(R.id.adminButton);
		admin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Admin.this, Admin.class));
				Admin.this.finish();

			}
		});

		Button help = (Button) findViewById(R.id.helpButton);
		help.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Admin.this, Help.class));
				Admin.this.finish();

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
					R.drawable.yellowtab));
			help.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));

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
					R.drawable.yellowtab));
			help.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));

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
					R.drawable.yellowtab));
			help.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));

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
					R.drawable.yellowtab));
			help.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));

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
					R.drawable.yellowtab));
			help.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.brightyellowtab));

			break;

		default:

			break;

		}

		// /////////////////////Button Setup End///////////

	}

	@SuppressWarnings("unchecked")
	private void xmlFileCreator() {
		boolean mExternalStorageAvailable = false;
		boolean mExternalStorageWriteable = false;
		String state = Environment.getExternalStorageState();

		if (Environment.MEDIA_MOUNTED.equals(state)) {
			// We can read and write the media
			mExternalStorageAvailable = mExternalStorageWriteable = true;

			try {
				File root = Environment.getExternalStorageDirectory();
				// create a File object for the parent directory
				File filePath = new File("/sdcard/WeedWalkData/output/pictures");
				// have the object build the directory structure, if needed.
				filePath.mkdirs();
				File outputXMLPath = new File("/sdcard/WeedWalkData/output/");

				if (root.canWrite()) {
					File xmlfile = new File(outputXMLPath,
							"meadowsWeedWalkOutputFile.xml");
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

								String sStr = mainFormStringArray
										.get(formInfoLocalFormula + strImgCount).toString();
								
								String bStr = mainFormBitmapNameArray
										.get(formInfoLocalFormula + strImgCount).toString();
								
								Bitmap bBit = mainFormBitmapArray.get(formInfoLocalFormula + strImgCount);

								if (!sStr
										.equalsIgnoreCase("")) {
									serializer.startTag(null, FINDING);
									serializer
											.attribute(null,
													ATTRIBUTE_REQUIRED,
													passFailBoolean);
									serializer.attribute(null,
											ATTRIBUTE_COMMENT,
											sStr);
									serializer.attribute(null, ATTRIBUTE_IMAGE,
											bStr);
									serializer.endTag(null, FINDING);
									
									try {
										File picFile = new File(filePath,
												bStr);
									       FileOutputStream out = new FileOutputStream(picFile);
									       bBit.compress(Bitmap.CompressFormat.JPEG, 90, out);
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

						errorString = "The file has successfully been created on the SD card.";
						createDialog();

					} catch (Exception e) {
						Log.e("Exception", e.toString());
						errorString = "An error occurred while writing the xml file. Please contact the administrator.";
						createDialog();

					}

					// ////////
					BufferedWriter out = new BufferedWriter(xmlwriter);
					out.close();

				}
			} catch (IOException e) {
				Log.e("IOExceptionLogCat", e.toString());
				errorString = "An error occurred while parcing the xml file. Please contact the administrator.";
				createDialog();
			}

		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			// We can only read the media
			mExternalStorageAvailable = true;
			mExternalStorageWriteable = false;
			errorString = "Your sd card is set to read only. Unmount the sd card, set the sd card to read and write, then try again.";
			createDialog();

		} else {
			// Something else is wrong. It may be one of many other states, but
			// all we need
			// to know is we can neither read nor write
			mExternalStorageAvailable = mExternalStorageWriteable = false;
			errorString = "There is no sd card present. Please insert one and try again.";
			createDialog();

		}

	}

	private void createDialog() {
		TextView myMsg = new TextView(this);
		myMsg.setText(errorString);
		myMsg.setGravity(Gravity.CENTER_HORIZONTAL);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setView(myMsg).setCancelable(true)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						startActivity(new Intent(Admin.this, Splash.class));
						Admin.this.finish();

						return;
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	private void createCloseoutDialog() {
		TextView myMsg = new TextView(this);
		myMsg.setText("Are you sure you want to write all of the files now?");
		myMsg.setGravity(Gravity.CENTER_HORIZONTAL);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setView(myMsg)
				.setCancelable(true)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						xmlFileCreator();

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

	private void createCloseoutDialogError() {
		TextView myMsg = new TextView(this);
		myMsg.setText("Not all of the assigned houses data have been complete. Are you sure you want to close out?");
		myMsg.setGravity(Gravity.CENTER_HORIZONTAL);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setView(myMsg)
				.setCancelable(true)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						xmlFileCreator();
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

	public void loadFileChooser() {

		startActivity(new Intent(Admin.this, FileChooserActivity.class));

	}

	protected void onResume() {
		super.onResume();
		TextView fileChoose = (TextView) findViewById(R.id.importTextView);
		if (!fileName.equalsIgnoreCase("na"))
			fileChoose.setText(fileName);

	}

}
