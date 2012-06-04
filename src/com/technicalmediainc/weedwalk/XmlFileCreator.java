//package com.technicalmediainc.weedwalk;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//
//import org.xmlpull.v1.XmlSerializer;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.os.Environment;
//import android.util.Log;
//import android.util.Xml;
//import android.view.Gravity;
//import android.widget.TextView;
//
//public class XmlFileCreator extends GlobalClass {
//
//	String errorString = "";
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//
//boolean mExternalStorageAvailable = false;
//boolean mExternalStorageWriteable = false;
//String state = Environment.getExternalStorageState();
//
//if (Environment.MEDIA_MOUNTED.equals(state)) {
//	// We can read and write the media
//	mExternalStorageAvailable = mExternalStorageWriteable = true;
//
//	try {
//		File root = Environment.getExternalStorageDirectory();
//		// create a File object for the parent directory
//		File rootB = new File("/sdcard/texts/");
//		// have the object build the directory structure, if needed.
//		rootB.mkdirs();
//
//		if (root.canWrite()) {
//			File xmlfile = new File(rootB, "meadowsWeedWalkOutputFile.xml");
//			FileWriter xmlwriter = new FileWriter(xmlfile);
//
//			// ////////
//			// we create a XmlSerializer in order to write xml data
//			XmlSerializer serializer = Xml.newSerializer();
//			try {
//				// we set the FileOutputStream as output for the
//				// serializer, using UTF-8 encoding
//				serializer.setOutput(xmlwriter);
//				// Write <?xml declaration with encoding (if encoding
//				// not null) and standalone flag (if standalone not
//				// null)
//				serializer.startDocument(null, Boolean.valueOf(true));
//				// set indentation option
//				serializer
//						.setFeature(
//								"http://xmlpull.org/v1/doc/features.html#indent-output",
//								true);
//				serializer.comment("This file contains all the homes (pass or fail) the weedwalk inspection. This file was exported from the android application. This file and software are property of Docent IMS wglover@docentims.com version date: March 14, 2012");
//				// start a tag called "root"
//				serializer.startTag(null, ROOT);
//				serializer.comment("Note: the inspection type defines the type of letter send out.  The type of document associated with the inspection type will be defined in the Word macro");
//				// i indent code just to have a view similar to xml-tree
//				serializer.startTag(null, INSP_TYPE);
//				serializer.text(InspectionType);
//				serializer.endTag(null, INSP_TYPE);
//
//				serializer.startTag(null, NAME);
//				serializer.text(TeamMemberOneFirst + " "
//						+ TeamMemberOneLast);
//				serializer.endTag(null, NAME);
//
//				serializer.startTag(null, EMAIL);
//				serializer.text(TeamMemberOneEmail);
//				serializer.endTag(null, EMAIL);
//
//				if (TeamMemberTwoFirst.equalsIgnoreCase("") == false) {
//					serializer.startTag(null, NAME);
//					serializer.text(TeamMemberTwoFirst + " "
//							+ TeamMemberTwoLast);
//					serializer.endTag(null, NAME);
//
//					serializer.startTag(null, EMAIL);
//					serializer.text(TeamMemberTwoEmail);
//					serializer.endTag(null, EMAIL);
//				}
//
//				serializer.startTag(null, DATE_INSP);
//				serializer.text(TodaysDate);
//				serializer.endTag(null, DATE_INSP);
//
//				serializer.startTag(null, DATE_COMP);
//				serializer.text(ComplianceDate);
//				serializer.endTag(null, DATE_COMP);
//
//				for (int x = 0; x < PassFailResult.size(); x++) {
//
//					serializer.startTag(null, XML_TAG_CARD_UID);
//
//					serializer.startTag(null, XML_TAG_CARD_DIV);
//					serializer.text(DivStrings.get(x));
//					serializer.endTag(null, XML_TAG_CARD_DIV);
//
//					serializer.startTag(null, XML_TAG_CARD_LOT);
//					serializer.text(LotStrings.get(x));
//					serializer.endTag(null, XML_TAG_CARD_LOT);
//
//					serializer.startTag(null, XML_TAG_CARD_ADRNUMB);
//					serializer.text(AdrNumbStrings.get(x));
//					serializer.endTag(null, XML_TAG_CARD_ADRNUMB);
//
//					serializer.startTag(null, XML_TAG_CARD_ADRSTREET);
//					serializer.text(AdrStreetStrings.get(x));
//					serializer.endTag(null, XML_TAG_CARD_ADRSTREET);
//
//					serializer.startTag(null, CITY);
//					serializer.text("City");
//					serializer.endTag(null, CITY);
//
//					serializer.startTag(null, STATE);
//					serializer.text("State");
//					serializer.endTag(null, STATE);
//
//					serializer.startTag(null, ZIP);
//					serializer.text("Zip");
//					serializer.endTag(null, ZIP);
//
//					serializer.startTag(null,
//							XML_TAG_CARD_PRIOR_YR_RSLT);
//					serializer.text(PrYrRsltStrings.get(x));
//					serializer.endTag(null, XML_TAG_CARD_PRIOR_YR_RSLT);
//
//					serializer.startTag(null,
//							XML_TAG_CARD_APRVD_ARCH_RQST);
//					serializer.text(ArchRqstStrings.get(x));
//					serializer.endTag(null,
//							XML_TAG_CARD_APRVD_ARCH_RQST);
//
//					serializer.startTag(null, RESULT);
//					serializer.text(PassFailResult.get(x));
//					serializer.endTag(null, RESULT);
//
//					String passFailBoolean = "";
//					if (PassFailResult.get(x).equalsIgnoreCase("pass")) {
//						passFailBoolean = "true";
//					}
//					if (PassFailResult.get(x).equalsIgnoreCase("fail")) {
//						passFailBoolean = "false";
//					}
//
//					serializer.startTag(null, PASSFAIL);
//					serializer.attribute(null, ATTRIBUTE_PASSFAIL,
//							passFailBoolean);
//					serializer.endTag(null, PASSFAIL);
//					
//					if (PassFailResult.get(x).equalsIgnoreCase("pass")) {
//						passFailBoolean = "false";
//					}
//					if (PassFailResult.get(x).equalsIgnoreCase("fail")) {
//						passFailBoolean = "true";
//					}
//
//					serializer.startTag(null, FINDINGS);
//
//					// HERE, WRITE A LIST TO ITERATE FOR EACH OF THE
//					// FORM
//					// DATA COMMENTS
//					serializer.startTag(null, FINDING);
//					serializer.attribute(null, ATTRIBUTE_REQUIRED,
//							passFailBoolean);
//					serializer.attribute(null, ATTRIBUTE_COMMENT,
//							FlowerbedDisc.get(x));
////					serializer.attribute(null, ATTRIBUTE_LOCATION,
////							FlowerbedLoc.get(x));
//					serializer.attribute(null, ATTRIBUTE_IMAGE, "");
//					serializer.endTag(null, FINDING);
//
//					serializer.startTag(null, FINDING);
//					serializer.attribute(null, ATTRIBUTE_REQUIRED,
//							passFailBoolean);
//					serializer.attribute(null, ATTRIBUTE_COMMENT,
//							StepsDisc.get(x));
////					serializer.attribute(null, ATTRIBUTE_LOCATION,
////							StepsLoc.get(x));
//					serializer.attribute(null, ATTRIBUTE_IMAGE, "");
//					serializer.endTag(null, FINDING);
//
//					serializer.startTag(null, FINDINGS_GENERAL_COMMENT);
//					serializer.text(Comments.get(x));
//					serializer.endTag(null, FINDINGS_GENERAL_COMMENT);
//
//					serializer.endTag(null, FINDINGS);
//
//					serializer.endTag(null, XML_TAG_CARD_UID);
//				}
//				serializer.endTag(null, ROOT);
//				serializer.endDocument();
//				// write xml data into the FileOutputStream
//				serializer.flush();
//				// finally we close the file stream
//				xmlwriter.close();
//
//				errorString = "The file has successfully been created on the SD card.";
//				createDialog();
//
//			} catch (Exception e) {
//				Log.e("Exception",
//						"An error has occurred while creating the xml file.");
//				errorString = "An error occurred while writing the xml file. Please contact the administrator.";
//				createDialog();
//
//			}
//
//			// ////////
//			BufferedWriter out = new BufferedWriter(xmlwriter);
//			out.close();
//
//		}
//	} catch (IOException e) {
//		Log.e("IOException", "exception");
//		errorString = "An error occurred while parcing the xml file. Please contact the administrator.";
//		createDialog();
//	}
//
//} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
//	// We can only read the media
//	mExternalStorageAvailable = true;
//	mExternalStorageWriteable = false;
//	errorString = "Your sd card is set to read only. Unmount the sd card, set the sd card to read and write, then try again.";
//	createDialog();
//
//} else {
//	// Something else is wrong. It may be one of many other states, but
//	// all we need
//	// to know is we can neither read nor write
//	mExternalStorageAvailable = mExternalStorageWriteable = false;
//	errorString = "There is no sd card present. Please insert one and try again.";
//	createDialog();
//
//}
//}
//
//private void createDialog() {
//TextView myMsg = new TextView(this);
//myMsg.setText(errorString);
//myMsg.setGravity(Gravity.CENTER_HORIZONTAL);
//
//AlertDialog.Builder builder = new AlertDialog.Builder(this);
//builder.setView(myMsg).setCancelable(true)
//		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//			public void onClick(DialogInterface dialog, int id) {
//				// XmlFileCreator.this.finish();
//
//				return;
//			}
//		});
//AlertDialog alert = builder.create();
//alert.show();
//}
//}
