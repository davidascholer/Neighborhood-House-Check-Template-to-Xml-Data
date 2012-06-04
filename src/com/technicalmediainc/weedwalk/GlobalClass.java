package com.technicalmediainc.weedwalk;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.EditText;

public class GlobalClass extends Activity {

	public static int INSPECTION_TYPE = 0;// 0 = annual 1 = rewalk
	public static int CURRENT_TAB = 0;// 0=home 1=assigned 2=form 3=picture
										// 4=completed
	public static int CURRENT_HOME = 0;
	public static final Calendar c = Calendar.getInstance();
	public static boolean xmlParseSetup = false;
	public static boolean initialAssignedClass = true;//To assign, but not reassign IDs in the Assigned Class
	public static boolean homeFixed = false;// this is to hold fix the home
											// class to a fixed state
    public static File fileDir;
    public static String fileName = "na";
    public static int fileCount = 0;
    public static final int MAX_FORM_PICS = 6;
    public static int totalHouseCount;
    public static boolean passedFormNoFurtherAction = true;

	// XML Tag Names used for reading and writing
	public static final String XML_TAG_CARD_MAIN_BLOCK = "homeList";
	public static final String XML_TAG_CARD_BLOCK = "home";
	public static final String XML_TAG_CARD_UID = "homeUID";
	public static final String XML_TAG_CARD_DIV = "homeDiv";
	public static final String XML_TAG_CARD_LOT = "homeLot";
	public static final String XML_TAG_CARD_ADRNUMB = "homeAdrNumb";
	public static final String XML_TAG_CARD_ADRSTREET = "homeAdrStreet";
	public static final String XML_TAG_CARD_PRIOR_YR_RSLT = "homePriorYrRsult1";
	public static final String XML_TAG_CARD_APRVD_ARCH_RQST = "homeAprvdArchRqst";
	
	public static File fileFinder;
	
	// XML Tag names used for only writing
	public static final String ROOT = "theMeadows";
	public static final String INSP_TYPE = "inspType";
	public static final String NAME = "teamMemberName";
	public static final String EMAIL = "teamMemberEmail";
	public static final String DATE_INSP = "dateInspection";
	public static final String DATE_COMP = "dateCompliance";
	public static final String CITY = "homeCity";
	public static final String STATE = "homeState";
	public static final String ZIP = "homeZip";
	public static final String RESULT = "currentYrRslt";
	public static final String PASSFAIL = "passNoActRqd";
	public static final String ATTRIBUTE_PASSFAIL = "type";
	public static final String FINDINGS = "findings";
	public static final String FINDING = "finding";
	public static final String FINDINGS_GENERAL_COMMENT = "findingsGeneralComment";
	public static final String ATTRIBUTE_REQUIRED = "required";
	public static final String ATTRIBUTE_LOCATION = "location";
	public static final String ATTRIBUTE_COMMENT = "comment";
	public static final String ATTRIBUTE_IMAGE = "image";

	public static final String XML_TAG_CARD_ATTRIBUTE_TEXT = "text";
	public static final String XML_TAG_CARD_ATTRIBUTE_IMAGEURL = "imageUrl";

	public static ArrayList<String> UidStrings = new ArrayList<String>();
	public static ArrayList<String> DivStrings = new ArrayList<String>();
	public static ArrayList<String> LotStrings = new ArrayList<String>();
	public static ArrayList<String> AdrNumbStrings = new ArrayList<String>();
	public static ArrayList<String> AdrStreetStrings = new ArrayList<String>();
	public static ArrayList<String> PrYrRsltStrings = new ArrayList<String>();
	public static ArrayList<String> ArchRqstStrings = new ArrayList<String>();
	public static String InspectionType = "";
	public static String TeamMemberOneFirst = "";
	public static String TeamMemberOneLast = "";;
	public static String TeamMemberOneEmail = "";
	public static String TeamMemberTwoFirst = "";
	public static String TeamMemberTwoLast = "";
	public static String TeamMemberTwoEmail = "";
	public static String TodaysDate = "";
	public static String ComplianceDate = "";
	
	//Here we keep a fixed amount of 6 as there are only 6 input fields on the form
//	public static final int formInfoLocalFormula = {"", "", "", "", "", "", ""};
	public static String[] PassFailFormStringArray = {"", "", "", "", "", ""};
	
	//We use an array list as the number of form arrays vary 
	public static ArrayList<String> mainFormStringArray = new ArrayList<String>();
	public static ArrayList<Bitmap> mainFormBitmapArray = new ArrayList<Bitmap>();
	public static ArrayList<String> mainFormBitmapNameArray = new ArrayList<String>();
	
	public static ArrayList<String> Comments = new ArrayList<String>();
	
	public static ArrayList<String> PassFailResult = new ArrayList<String>();


}
