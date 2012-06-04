package com.technicalmediainc.weedwalk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Home extends GlobalClass {

	private int mYear;
	private int mMonth;
	private int mDay;
	private int currentYear;
	private int currentMonth;
	private int currentDay;

	static final int DATE_DIALOG_ID = 1;

	EditText fName1;
	EditText lName1;
	EditText email1;
	EditText fName2;
	EditText lName2;
	EditText email2;
	Button inspectionButton;
	private EditText today;
	private EditText compliance;
	private int curSelDateId;
	int homeCount = 0;
	File internalInputData;
	InputStream fis;
	Map<String, String> attributes;
	int findingCount = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);

		inspectionButton = (Button) findViewById(R.id.inspectionButton);
		fName1 = (EditText) findViewById(R.id.firstNameEditText1);
		lName1 = (EditText) findViewById(R.id.lastNameEditText1);
		email1 = (EditText) findViewById(R.id.emailEditText1);
		fName2 = (EditText) findViewById(R.id.firstNameEditText2);
		lName2 = (EditText) findViewById(R.id.lastNameEditText2);
		email2 = (EditText) findViewById(R.id.emailEditText2);
		today = (EditText) findViewById(R.id.dateTodayEditText);
		compliance = (EditText) findViewById(R.id.dateComplianceEditText);

		if (xmlParseSetup == false) {

			internalInputData = new File(Environment.getDataDirectory()
					.getAbsolutePath() + "/weedwalkData/input.xml");
			if (internalInputData.exists()) {
				try {
					loadPreviousData();
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					showXmlParceDataError();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					showXmlParceDataError();
				}

			} else {

			}
			if (!InspectionType.equalsIgnoreCase("")) {
				inspectionButton.setText(InspectionType);
				fName1.setText(TeamMemberOneFirst);
				lName1.setText(TeamMemberOneLast);
				email1.setText(TeamMemberOneEmail);
				fName2.setText(TeamMemberTwoFirst);
				lName2.setText(TeamMemberTwoLast);
				email2.setText(TeamMemberTwoEmail);
				today.setText(TodaysDate);
				compliance.setText(ComplianceDate);
			}

		}

		/*
		 * Here, we are checking the the Team Member Info form for completion
		 */
		fName1.addTextChangedListener(new TextWatcher() {

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				checkFirstTeamMemberInput();
			}
		});

		lName1.addTextChangedListener(new TextWatcher() {

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				checkFirstTeamMemberInput();
			}
		});

		email1.addTextChangedListener(new TextWatcher() {

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				checkFirstTeamMemberInput();
			}
		});

		fName2.addTextChangedListener(new TextWatcher() {

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				checkSecondTeamMemberInput();
			}
		});

		lName2.addTextChangedListener(new TextWatcher() {

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				checkSecondTeamMemberInput();
			}
		});

		email2.addTextChangedListener(new TextWatcher() {

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				checkSecondTeamMemberInput();
			}
		});

		// ///////////////////////////End//////////////////////////////////

		// ///////////Button Setup////////////////
		Button home = (Button) findViewById(R.id.homeButton);
		home.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Home.this, Home.class));
				Home.this.finish();
			}
		});

		Button assigned = (Button) findViewById(R.id.assignedButton);
		assigned.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Home.this, Assigned.class));
				Home.this.finish();

			}
		});

		Button form = (Button) findViewById(R.id.formButton);
		form.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Home.this, Form.class));
				Home.this.finish();

			}
		});

		Button picture = (Button) findViewById(R.id.pictureButton);
		picture.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Home.this, Picture.class));
				Home.this.finish();

			}
		});

		Button completed = (Button) findViewById(R.id.completedButton);
		completed.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Home.this, Completed.class));
				Home.this.finish();

			}
		});

		Button admin = (Button) findViewById(R.id.adminButton);
		admin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Home.this, Admin.class));
				Home.this.finish();

			}
		});

		Button help = (Button) findViewById(R.id.helpButton);
		help.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				startActivity(new Intent(Home.this, Help.class));
				Home.this.finish();

			}
		});

		home.setClickable(false);
		assigned.setClickable(false);
		form.setClickable(false);
		picture.setClickable(false);
		completed.setClickable(false);
		admin.setClickable(true);
		help.setClickable(true);

		home.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.yellowtab));
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
				R.drawable.brightyellowtab));

		// /////////////////////Button Setup End////////////

		Button inspect = (Button) findViewById(R.id.inspectionButton);
		inspect.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				openInspectionDialog();

			}
		});

		Button nextButton = (Button) findViewById(R.id.homeNextButton);
		nextButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				boolean skipAssignedScreen = false;
				if (fileDir == null) {
					if (xmlParseSetup == false) {

						saveData();

						File file = new File(
								"/sdcard/WeedWalkData/output/meadowsWeedWalkInputFile.xml");// add
																								// e
																								// to
																								// get
																								// working
						if (file.exists()) {
							try {
								fileDir = file;
								xmlActivity();
								CURRENT_TAB = 1;
							} catch (XmlPullParserException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								showXmlParceDataError();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								showXmlParceDataError();
							}

						} else {

							troubleFindingFileDialog();
							skipAssignedScreen = true;
						}
					}
				} else {
					try {
						if (fileName
								.equalsIgnoreCase("meadowsWeedWalkInputFile.xml")) {
							xmlActivity();
						} else if (fileName
								.equalsIgnoreCase("meadowsWeedWalkOutputFile.xml")) {
							loadOutputXml();
						} else {
							fileDir = null;
						}
						CURRENT_TAB = 1;
					} catch (XmlPullParserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						showXmlParceDataError();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						showXmlParceDataError();
					}

				}

				if (skipAssignedScreen == false) {
					startActivity(new Intent(Home.this, Assigned.class));
					Home.this.finish();
				}
			}
		});

		// nextButton.setEnabled(false);
		// nextButton.setFocusable(false);
		// nextButton.setFocusableInTouchMode(false);
		// nextButton.setClickable(false);

		// if (homeFixed == true) {// disable everything
		// nextButton.setEnabled(false);
		// nextButton.setFocusable(false);
		// nextButton.setFocusableInTouchMode(false);
		// nextButton.setClickable(false);
		// fName1.setFocusable(false);
		// lName1.setFocusable(false);
		// email1.setFocusable(false);
		// fName2.setFocusable(false);
		// lName2.setFocusable(false);
		// email2.setFocusable(false);
		// today.setFocusable(false);
		// compliance.setFocusable(false);
		// inspectionButton.setFocusable(false);
		//
		// }

	}

	private void setUpDateViewElements() {

		setCurrentDate();

		// capture our View elements
		today = (EditText) findViewById(R.id.dateTodayEditText);

		// add a click listener to the button
		today.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (INSPECTION_TYPE == 1) {
					curSelDateId = 0;
					showDialog(DATE_DIALOG_ID);
				}
			}
		});

		// capture our View elements
		compliance = (EditText) findViewById(R.id.dateComplianceEditText);

		// add a click listener to the button
		compliance.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (INSPECTION_TYPE == 1) {
					curSelDateId = 1;
					showDialog(DATE_DIALOG_ID);
				}
			}
		});

	}

	// updates the date in the TextView
	private void updateDisplay() {
		switch (curSelDateId) {
		case 0: {
			today.setText(new StringBuilder()
					// Month is 0 based so add 1
					.append(mMonth + 1).append("-").append(mDay).append("-")
					.append(mYear).append(" "));
			break;
		}

		case 1: {
			compliance.setText(new StringBuilder()
					// Month is 0 based so add 1
					.append(mMonth + 1).append("-").append(mDay).append("-")
					.append(mYear).append(" "));
			break;
		}

		}

	}

	public void getCurrentDate() {
		// get the current date
		currentYear = GlobalClass.c.get(Calendar.YEAR);
		currentMonth = GlobalClass.c.get(Calendar.MONTH);
		currentDay = GlobalClass.c.get(Calendar.DAY_OF_MONTH);
	}

	public void setCurrentDate() {

		getCurrentDate();
		today.setText(new StringBuilder()
				// Month is 0 based so add 1
				.append(currentMonth + 1).append("-").append(currentDay)
				.append("-").append(currentYear).append(" "));

	}

	// the callback received when the user "sets" the date in the dialog
	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			updateDisplay();
		}
	};

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, mDateSetListener, currentYear,
					currentMonth, currentDay);
		}
		return null;
	}

	protected void enableTeamMemberInput() {

		fName1.setFocusable(true);
		fName1.setFocusableInTouchMode(true);
		fName1.setClickable(true);

		lName1.setFocusable(true);
		lName1.setFocusableInTouchMode(true);
		lName1.setClickable(true);

		email1.setFocusable(true);
		email1.setFocusableInTouchMode(true);
		email1.setClickable(true);

		fName2.setFocusable(true);
		fName2.setFocusableInTouchMode(true);
		fName2.setClickable(true);

		lName2.setFocusable(true);
		lName2.setFocusableInTouchMode(true);
		lName2.setClickable(true);

		email2.setFocusable(true);
		email2.setFocusableInTouchMode(true);
		email2.setClickable(true);

		// enable the member info hints here

	}

	protected void checkFirstTeamMemberInput() {

		if (fName1.getText().toString().trim().equals("") == false) {
			if (lName1.getText().toString().trim().equals("") == false) {
				if (email1.getText().toString().trim().equals("") == false) {

					enableDateInput();

				}
			}
		} else {
			RelativeLayout rl4 = (RelativeLayout) findViewById(R.id.relativeLayout4);

			// here goes the code for relocking the dates

		}
	}

	protected void checkSecondTeamMemberInput() {

		if (fName2.getText().toString().trim().equals("") == false) {
			if (lName2.getText().toString().trim().equals("") == false) {
				if (email2.getText().toString().trim().equals("") == false) {

				}
			}
		}

	}

	protected void enableDateInput() {

		// enable the date hints here

		Button b = (Button) findViewById(R.id.homeNextButton);
		b.setClickable(true);
		b.setEnabled(true);
		b.setFocusable(true);
		b.setFocusableInTouchMode(true);

		setUpDateViewElements();

	}

	public void openInspectionDialog() {

		final CharSequence[] items = { "Annual", "Re-Walk" };

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Select One");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				// Do something with the selection
				INSPECTION_TYPE = item;

				Button button = (Button) findViewById(R.id.inspectionButton);
				button.setText(items[INSPECTION_TYPE]);

				enableTeamMemberInput();

				// Just in case the Inspection Type has been changed
				if (INSPECTION_TYPE == 0) {
					compliance.setText("");
					compliance.setFocusable(false);
					compliance.setFocusableInTouchMode(false);
					compliance.setClickable(false);
				} else {
					checkFirstTeamMemberInput();
				}

			}
		});
		AlertDialog alert = builder.create();
		alert.show();

	}

	private void saveData() {

		Button a = (Button) findViewById(R.id.inspectionButton);
		EditText b = (EditText) findViewById(R.id.firstNameEditText1);
		EditText c = (EditText) findViewById(R.id.lastNameEditText1);
		EditText d = (EditText) findViewById(R.id.emailEditText1);
		EditText f = (EditText) findViewById(R.id.firstNameEditText2);
		EditText g = (EditText) findViewById(R.id.lastNameEditText2);
		EditText h = (EditText) findViewById(R.id.emailEditText2);
		EditText j = (EditText) findViewById(R.id.dateTodayEditText);
		EditText k = (EditText) findViewById(R.id.dateComplianceEditText);

		InspectionType = a.getText().toString();
		TeamMemberOneFirst = b.getText().toString();
		TeamMemberOneLast = c.getText().toString();
		TeamMemberOneEmail = d.getText().toString();
		TeamMemberTwoFirst = f.getText().toString();
		TeamMemberTwoLast = g.getText().toString();
		TeamMemberTwoEmail = h.getText().toString();
		TodaysDate = j.getText().toString();
		ComplianceDate = k.getText().toString();

	}

	public void xmlActivity() throws XmlPullParserException, IOException {
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED) == true) {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			// InputStream is = getResources().getAssets().open(
			// "meadowsWeedWalkInputFile.xml");
			FileInputStream fis;
			fis = new FileInputStream(fileDir);
			String id = "";
			xpp.setInput(fis, null);

			int eventType = xpp.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if (eventType == XmlPullParser.START_DOCUMENT) {
				} else if (eventType == XmlPullParser.START_TAG) {

					id = xpp.getName();

				} else if (eventType == XmlPullParser.TEXT) {

					if (id.equalsIgnoreCase(XML_TAG_CARD_UID)) {
						if (xpp.getText().trim().equals("") == false)
							UidStrings.add(xpp.getText());
					} else if (id.equalsIgnoreCase(XML_TAG_CARD_DIV)) {
						if (xpp.getText().trim().equals("") == false) {
							DivStrings.add(xpp.getText());
							addOtherArraysNA();
						}
					} else if (id.equalsIgnoreCase(XML_TAG_CARD_LOT)) {
						if (xpp.getText().trim().equals("") == false)
							LotStrings.add(xpp.getText());
					} else if (id.equalsIgnoreCase(XML_TAG_CARD_ADRNUMB)) {
						if (xpp.getText().trim().equals("") == false)
							AdrNumbStrings.add(xpp.getText());
					} else if (id.equalsIgnoreCase(XML_TAG_CARD_ADRSTREET)) {
						if (xpp.getText().trim().equals("") == false)
							AdrStreetStrings.add(xpp.getText());
					} else if (id.equalsIgnoreCase(XML_TAG_CARD_PRIOR_YR_RSLT)) {
						if (xpp.getText().trim().equals("") == false)
							PrYrRsltStrings.add(xpp.getText());
					} else if (id
							.equalsIgnoreCase(XML_TAG_CARD_APRVD_ARCH_RQST)) {
						if (xpp.getText().trim().equals("") == false)
							ArchRqstStrings.add(xpp.getText());
					}

				}
				eventType = xpp.next();

			}
		} else {
			sdCardError();
		}
		totalHouseCount = homeCount;
		xmlParseSetup = true;
	}

	public void loadOutputXml() throws XmlPullParserException, IOException {
		ArrayList<String> lAl = new ArrayList<String>();
		int counter = 0;

		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser xpp = factory.newPullParser();
		// "meadowsWeedWalkInputFile.xml");
		fis = new FileInputStream(fileDir);
		String id = "";

		xpp.setInput(fis, null);

		int eventType = xpp.getEventType();

		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_DOCUMENT) {

			} else if (eventType == XmlPullParser.START_TAG) {

				id = xpp.getName();

			} else if (eventType == XmlPullParser.TEXT) {

				if (id.equalsIgnoreCase(XML_TAG_CARD_UID)) {
					if (xpp.getText().trim().equals("") == false)
						UidStrings.add(xpp.getText());
				} else if (id.equalsIgnoreCase(XML_TAG_CARD_DIV)) {
					if (xpp.getText().trim().equals("") == false) {
						// addOtherArraysNA();
						DivStrings.add(xpp.getText());
					}
				} else if (id.equalsIgnoreCase(XML_TAG_CARD_LOT)) {
					if (xpp.getText().trim().equals("") == false)
						LotStrings.add(xpp.getText());
				} else if (id.equalsIgnoreCase(XML_TAG_CARD_ADRNUMB)) {
					if (xpp.getText().trim().equals("") == false)
						AdrNumbStrings.add(xpp.getText());
				} else if (id.equalsIgnoreCase(XML_TAG_CARD_ADRSTREET)) {
					if (xpp.getText().trim().equals("") == false)
						AdrStreetStrings.add(xpp.getText());
				} else if (id.equalsIgnoreCase(XML_TAG_CARD_PRIOR_YR_RSLT)) {
					if (xpp.getText().trim().equals("") == false)
						PrYrRsltStrings.add(xpp.getText());
				} else if (id.equalsIgnoreCase(XML_TAG_CARD_APRVD_ARCH_RQST)) {
					if (xpp.getText().trim().equals("") == false)
						ArchRqstStrings.add(xpp.getText());
				} else if (id.equalsIgnoreCase(RESULT)) {
					if (xpp.getText().trim().equals("") == false)
						PassFailResult.add(xpp.getText());
				} else if (id.equalsIgnoreCase(FINDINGS)) {
					try {
						parseContent(xpp);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// try {
					// if (!attributes.get("comment").trim()
					// .equalsIgnoreCase("")) {
					// // mainFormStringArray.add(attributes.get("comment"));
					// // mainFormBitmapNameArray
					// // .add(attributes.get("image"));
					// }
					// // while (mainFormStringArray.size() % 6 != 0) {
					// // mainFormStringArray.add("");
					// // mainFormBitmapNameArray.add("");
					// // }
					// } catch (Exception e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					lAl.add(Integer.toString(counter) + " " + xpp.getText());
					counter++;

				}

			}
			eventType = xpp.next();
		}
		fillComments();
		xmlParseSetup = true;
	}
	
	public void loadPreviousData() throws XmlPullParserException, IOException {
		ArrayList<String> lAl = new ArrayList<String>();
		int counter = 0;

		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser xpp = factory.newPullParser();
		// "meadowsWeedWalkInputFile.xml");
		fis = new FileInputStream(fileDir);
		String id = "";

		xpp.setInput(fis, null);

		int eventType = xpp.getEventType();

		while (eventType != XmlPullParser.END_DOCUMENT) {
			if (eventType == XmlPullParser.START_DOCUMENT) {

			} else if (eventType == XmlPullParser.START_TAG) {

				id = xpp.getName();

			} else if (eventType == XmlPullParser.TEXT) {

				if (id.equalsIgnoreCase(XML_TAG_CARD_UID)) {
					if (xpp.getText().trim().equals("") == false)
						UidStrings.add(xpp.getText());
				} else if (id.equalsIgnoreCase(XML_TAG_CARD_DIV)) {
					if (xpp.getText().trim().equals("") == false) {
						// addOtherArraysNA();
						DivStrings.add(xpp.getText());
					}
				} else if (id.equalsIgnoreCase(XML_TAG_CARD_LOT)) {
					if (xpp.getText().trim().equals("") == false)
						LotStrings.add(xpp.getText());
				} else if (id.equalsIgnoreCase(XML_TAG_CARD_ADRNUMB)) {
					if (xpp.getText().trim().equals("") == false)
						AdrNumbStrings.add(xpp.getText());
				} else if (id.equalsIgnoreCase(XML_TAG_CARD_ADRSTREET)) {
					if (xpp.getText().trim().equals("") == false)
						AdrStreetStrings.add(xpp.getText());
				} else if (id.equalsIgnoreCase(XML_TAG_CARD_PRIOR_YR_RSLT)) {
					if (xpp.getText().trim().equals("") == false)
						PrYrRsltStrings.add(xpp.getText());
				} else if (id.equalsIgnoreCase(XML_TAG_CARD_APRVD_ARCH_RQST)) {
					if (xpp.getText().trim().equals("") == false)
						ArchRqstStrings.add(xpp.getText());
				} else if (id.equalsIgnoreCase(RESULT)) {
					if (xpp.getText().trim().equals("") == false)
						PassFailResult.add(xpp.getText());
				} else if (id.equalsIgnoreCase(FINDINGS)) {
					try {
						parseContent(xpp);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// try {
					// if (!attributes.get("comment").trim()
					// .equalsIgnoreCase("")) {
					// // mainFormStringArray.add(attributes.get("comment"));
					// // mainFormBitmapNameArray
					// // .add(attributes.get("image"));
					// }
					// // while (mainFormStringArray.size() % 6 != 0) {
					// // mainFormStringArray.add("");
					// // mainFormBitmapNameArray.add("");
					// // }
					// } catch (Exception e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					lAl.add(Integer.toString(counter) + " " + xpp.getText());
					counter++;

				}

			}
			eventType = xpp.next();
		}
		fillComments();
		xmlParseSetup = true;
	}


	private void showXmlParceDataError() {

		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Error gathering data!");
		alertDialog
				.setMessage("The XML file was tampered with. Please use the original XML input file or contact the administrator.");
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				return;
			}
		});
		alertDialog.show();
	}

	private void sdCardError() {

		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("No SD Card Found");
		alertDialog.setMessage("Please insert the sd card and try again.");
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				return;
			}
		});
		alertDialog.show();
	}

	public void addOtherArraysNA() {

		PassFailResult.add("assigned");

		for (int stringArrayCounter = 0; stringArrayCounter < MAX_FORM_PICS; stringArrayCounter++) {
			mainFormStringArray.add(stringArrayCounter, "");
			mainFormBitmapArray.add(stringArrayCounter, null);
			mainFormBitmapNameArray.add(stringArrayCounter, "");

		}

		// ASSIGNED_HOUSE_ID_ARRAY.add(homeCount);
		// FAILED_HOUSE_ID_ARRAY.add(homeCount);
		// PASSED_HOUSE_ID_ARRAY.add(homeCount);
		homeCount++;

	}

	private void troubleFindingFileDialog() {
		TextView myMsg = new TextView(this);
		myMsg.setText("Could Not Find File. Please Locate Manually");
		myMsg.setGravity(Gravity.CENTER_HORIZONTAL);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setView(myMsg).setCancelable(true)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						saveData();

						CURRENT_TAB = 1;
						startActivity(new Intent(Home.this, Admin.class));
						Home.this.finish();
						return;
					}
				});
		AlertDialog alert = builder.create();
		alert.show();

	}

	private void parseContent(XmlPullParser parser)
			throws XmlPullParserException, IOException, Exception {
		int eventType;
		while ((eventType = parser.next()) != XmlPullParser.END_TAG) {
			if (eventType == XmlPullParser.START_TAG) {
				Log.d("MY_DEBUG_TAG",
						"Parsing Attributes for [" + parser.getName() + "]");
				attributes = getAttributes(parser);
				if (!attributes.isEmpty()) {
					if (!attributes.get("comment").trim().equalsIgnoreCase("")) {
						mainFormStringArray.add(attributes.get("comment"));
						mainFormBitmapNameArray.add(attributes.get("image"));
						// get the picture file paths here
						findingCount++;
					}
				}
			}
			if (parser.getName().equalsIgnoreCase(FINDINGS_GENERAL_COMMENT)) {
				if (findingCount != MAX_FORM_PICS) {
					for (int finishFormArray = findingCount; finishFormArray < MAX_FORM_PICS; finishFormArray++) {
						mainFormStringArray.add("");
						mainFormBitmapNameArray.add("");
						mainFormBitmapArray.add(null);
					}
				}
				parser.next();
				findingCount = 0;
				// if (xpp.getText().trim().equals("") == false)

			}
		}
		while(mainFormStringArray.size()>48){
			mainFormStringArray.remove(48);
		}
		while(mainFormBitmapNameArray.size()>48){
			mainFormBitmapNameArray.remove(48);
		}

		while(mainFormBitmapArray.size()>48){
			mainFormBitmapArray.remove(48);
		}
String stop = "";
stop = "";
	}

	private Map<String, String> getAttributes(XmlPullParser parser)
			throws Exception {
		Map<String, String> attrs = null;
		int acount = parser.getAttributeCount();
		if (acount != -1) {
			Log.d("MY_DEBUG_TAG", "Attributes for [" + parser.getName() + "]");
			attrs = new HashMap<String, String>(acount);
			for (int x = 0; x < acount; x++) {
				Log.d("MY_DEBUG_TAG", "\t[" + parser.getAttributeName(x) + "]="
						+ "[" + parser.getAttributeValue(x) + "]");
				attrs.put(parser.getAttributeName(x),
						parser.getAttributeValue(x));
			}
		} else {
			throw new Exception("Required entity attributes missing");
		}
		return attrs;
	}

	public void fillComments() throws XmlPullParserException, IOException {

		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser xpp = factory.newPullParser();
		boolean print = false;
		// "meadowsWeedWalkInputFile.xml");
		fis = new FileInputStream(fileDir);

		xpp.setInput(fis, null);

		int eventType = xpp.getEventType();

		while (eventType != XmlPullParser.END_DOCUMENT) {
			String id = xpp.getName();
			if (eventType == XmlPullParser.START_DOCUMENT) {
				System.out.println("Start document");
			} else if (eventType == XmlPullParser.START_TAG) {
				System.out.println("Start tag " + xpp.getName());
				if (xpp.getName().equalsIgnoreCase(FINDINGS_GENERAL_COMMENT)) {
					print = true;
				}
			} else if (eventType == XmlPullParser.END_TAG) {
				System.out.println("End tag " + xpp.getName());
			} else if (eventType == XmlPullParser.TEXT) {
				System.out.println("Text " + xpp.getText());
				if (print == true) {
					if (Comments.size() < 8) {
						Comments.add(xpp.getText().trim());
						print = false;
					}
				}
			}
			eventType = xpp.next();
		}
		System.out.println("End document");
	}
}
