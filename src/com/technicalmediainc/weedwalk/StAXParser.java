package com.technicalmediainc.weedwalk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.os.Environment;

public class StAXParser extends GlobalClass{
    public static void main (String args[])
            throws XmlPullParserException, IOException
        {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
    		File file = new File(Environment.getExternalStorageDirectory()
			+ "/digital_lounge/xmltest2.xml");
			FileInputStream fis;

			fis = new FileInputStream(file);
            xpp.setInput(fis, null);
            
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
             if(eventType == XmlPullParser.START_DOCUMENT) {
                 System.out.println("Start document");
             } else if(eventType == XmlPullParser.START_TAG) {
                 System.out.println("Start tag "+xpp.getName());
             } else if(eventType == XmlPullParser.END_TAG) {
                 System.out.println("End tag "+xpp.getName());
             } else if(eventType == XmlPullParser.TEXT) {
                 System.out.println("Text "+xpp.getText());
             }
             eventType = xpp.next();
            }
            System.out.println("End document");
        }
}
