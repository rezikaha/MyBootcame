package com.ninja.qa.utils;

import java.util.Date;

public class Utilities {
	public static String generateEmailWithTimeStamp() {
Date date =new Date();
String timeStamp= date.toString().replace(" ","_").replace(":","_");
return "rezikahachour"+ timeStamp +"@gmail.com";
}
	
	
	public static final int implicitlyWait = 10;
	public static final int pageloadTimeout = 10;
	public static final int scriptTimeout = 100;
}