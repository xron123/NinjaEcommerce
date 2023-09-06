package com.tutorialsninja.utils;

import java.util.Date;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME = 25;  //final blocks cannot be updated from othr place, still static coz helps to call without method creation
	public static final int PAGE_LOAD_TIME = 10;//both are called from base class
	
	public static String generateTimeStamp() { // to create fake email id (new one)

		Date date = new Date();
		String finalDate = date.toString().replace(" ", "_").replace(":", "_") + "customer@gmail.com"; // time had : and
																										// spaces so we
																										// r
																										// removing
		// with _
		return finalDate; // returning to calling method wherever we have to enter wrong email id to
							// prevent blocking.

	}


}
