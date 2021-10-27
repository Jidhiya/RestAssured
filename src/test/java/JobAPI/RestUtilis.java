package JobAPI;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtilis {
	
		public static String get_JobId() {
			String generatedJobId = RandomStringUtils.randomNumeric(5);
			return (generatedJobId);
		}
		public static String get_JobTitle() {
			String generatedJobTitle = RandomStringUtils.randomAlphabetic(3);
			return ("SDET"+generatedJobTitle);			
		}
		public static String get_JobLocation() {
			String generatedJobLocation = RandomStringUtils.randomAlphabetic(3);
			return ("US"+generatedJobLocation);	
		}
		public static String get_JobCompName() {
			String generatedJobCompName = RandomStringUtils.randomAlphabetic(3);
			return ("ABC"+generatedJobCompName);	
		}
		public static String get_JobType() {
			String generatedJobType = RandomStringUtils.randomAlphabetic(3);
			return ("Full Time"+generatedJobType);	
		}
		public static String get_JobPostedTime() {
			String generatedJobPostedTime = RandomStringUtils.randomNumeric(3);
			return (generatedJobPostedTime+ "minutes");	
		}
		public static String get_JobDesc() {
			String generatedJobDesc = RandomStringUtils.randomAlphabetic(3);
			return ("Remote"+generatedJobDesc);	
		}
		
	}




