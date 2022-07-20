package listeners;
//import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

//import java.io.FileInputStream;
//import java.util.Properties;
//import org.apache.log4j.PropertyConfigurator;

import com.msf.log.Logger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
//import jakarta.servlet.annotation.WebListener;
//import org.apache.log4j.PropertyConfigurator;

//import com.msf.log.Logger;
//@WebListener("Log4jListener")
public  class Log4jListener implements ServletContextListener {
	
	/*@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		String log4jConfigFile = context.getInitParameter("log4j-config-location");
		 String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;
		 PropertyConfigurator.configure(fullPath);
		 System.out.println("log4j initiated in listenersclass");
		 
		// System.out.println("msf_log initiated in listenersclass");*/
	
	
	
		/*private static Logger log;
		 public void contextInitialized(ServletContextEvent event) {
				System.out.println("contextInitialized");
				ServletContext ctx = event.getServletContext();
				String logFile = ctx.getInitParameter("log4j-config-location");
				System.out.println(logFile); */
				
	
	//private static Logger log;
	private static Logger log = Logger.getLogger(Log4jListener.class);
	public void contextInitialized(ServletContextEvent event) {			
				ServletContext ctx = event.getServletContext();
				
 				String classFolder = ctx.getRealPath("/") + "WEB-INF" + System.getProperty("file.separator") + "classes"
						+ System.getProperty("file.separator");
				String logFile = classFolder + "log4j2.properties";
				
			 /*String classFolder = ctx.getRealPath("/") + "WEB-INF" + System.getProperty("file.separator") + "classes"
						+ System.getProperty("file.separator");
				String logFile = classFolder + "jslog.properties";*/

				
				//String logFile = ctx.getInitParameter("log4j-config-location");
				System.out.println(logFile);
				

		 try {
				setLogger(logFile);
				log = Logger.getLogger(Log4jListener.class);
			} catch (Exception e) {
				System.out.println("Not able to set Logger");
			}}
	public static void setLogger(String file) throws Exception {

		Properties properties = new Properties();
		FileInputStream _f = new FileInputStream(file);
		properties.load(_f);
		_f.close();

		Logger.setLogger(properties);
	}}