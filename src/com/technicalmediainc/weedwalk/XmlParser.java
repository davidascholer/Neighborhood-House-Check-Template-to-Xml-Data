//package com.technicalmediainc.weedwalk;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//
//import org.xmlpull.v1.XmlPullParserException;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.content.SharedPreferences;
//import android.content.res.AssetManager;
//import android.content.res.XmlResourceParser;
//import android.os.Bundle;
//import android.widget.TextView;
//
//public class XmlParser extends GlobalClass {
//	/** Called when the activity is first created. */
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//
//		TextView tv = (TextView) findViewById(R.id.testTextView);
//
//		String mainString = "";
//
//		SharedPreferences mPrefs;
//
//		AssetManager assets = this.getAssets();
//
//		// TODO: Contact the server and retrieve a batch of question data,
//		// beginning at startQuestionNumber
//		XmlResourceParser questionBatch;
//
//
//		questionBatch = getResources().getXml(R.xml.weedwalk);		
//
//
//		// Parse the XML
//		int eventType = -1;
//
//		while (eventType != XmlResourceParser.END_DOCUMENT) {
//			if (eventType == XmlResourceParser.START_TAG) {
//
//				// Get the name of the tag (eg questions or question)
//				String strName = questionBatch.getName();
//
//				if (strName.equals(XML_TAG_CARD_UID)) {
//
//					UidStrings.add(questionBatch.getAttributeValue(null,
//							XML_TAG_CARD_ATTRIBUTE_TEXT));
//
//				} else if (strName.equals(XML_TAG_CARD_DIV)) {
//
//					DivStrings.add(questionBatch.getAttributeValue(null,
//							XML_TAG_CARD_ATTRIBUTE_TEXT));
//
//				}
//
//				else if (strName.equals(XML_TAG_CARD_LOT)) {
//
//					LotStrings.add(questionBatch.getAttributeValue(null,
//							XML_TAG_CARD_ATTRIBUTE_TEXT));
//
//				}
//
//				else if (strName.equals(XML_TAG_CARD_ADRNUMB)) {
//
//					AdrNumbStrings.add(questionBatch.getAttributeValue(null,
//							XML_TAG_CARD_ATTRIBUTE_TEXT));
//
//				}
//
//				else if (strName.equals(XML_TAG_CARD_ADRSTREET)) {
//
//					AdrStreetStrings.add(questionBatch.getAttributeValue(null,
//							XML_TAG_CARD_ATTRIBUTE_TEXT));
//
//				}
//
//			}
//			try {
//				eventType = questionBatch.next();
//			} catch (XmlPullParserException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		for (int z = 0; z < UidStrings.size(); z++) {
//			mainString += Integer.toString(z) + " " + UidStrings.get(z) + " "
//					+ DivStrings.get(z) + " " + LotStrings.get(z) + " "
//					+ AdrNumbStrings.get(z) + " " + AdrStreetStrings.get(z)
//					+ "\n";
//		}
//
//		tv.setText(mainString);
//
//	}
//
//	private void createDialog() {
//
//		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//		alertDialog.setTitle("Invalid File");
//		alertDialog
//				.setMessage("Could not locate the file or it is not the accurate xml structure.");
//		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
//			public void onClick(DialogInterface dialog, int which) {
//				return;
//			}
//		});
//		alertDialog.show();
//
//	}
//
//}
