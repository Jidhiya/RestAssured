package LMS_API;

import org.apache.commons.lang3.RandomStringUtils;

public class LMS_Utils {
	
	public static String getProgramName() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return ("SDET" + generatedString );
	
		
	}
	
	public static String getProgramDesc() {
		String generatedString = RandomStringUtils.randomAlphabetic(7);
		return ("Software" + generatedString );
		
	}
}
	
	

