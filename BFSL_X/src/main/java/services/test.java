package services;
import java.io.FileInputStream;
import java.util.Properties;

import com.msf.log.Logger;

public class test {

	private static Logger log = Logger.getLogger(test.class);

	public static void main(String[] args) throws Exception {

		Properties JSLogProperties = new Properties();

		String file = "C:\\Users\\aiswarya.v\\eclipse-workspace\\BFSL_X\\logfile";
		JSLogProperties.load(new FileInputStream(file));
		Logger.setLogger(JSLogProperties);
		log = Logger.getLogger(test.class);
		
		log.debug("debugging mode");
	}

}
