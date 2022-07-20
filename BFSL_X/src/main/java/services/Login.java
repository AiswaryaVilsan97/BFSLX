package services;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.msf.log.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; 

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//public static Logger log = Logger.getLogger(Login.class);
	private static Logger log = Logger.getLogger(Login.class);
	//private static Logger log;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		
		String userName=req.getParameter("userName");
		String password= req.getParameter("password");
		
		PrintWriter out= res.getWriter();
		Validation u= new Validation();
		Connection c=null;
		// Logging l=new Logging();
		 try {
				
			 if(u.validate(userName, password)) {
				
				Class.forName("com.mysql.jdbc.Driver");
				//l.logger.debug("Login::JDBC driver class is loaded");
				log.debug("Login::JDBC driver class is loaded");
				c=DriverManager.getConnection("jdbc:mysql://dev-ws.bajajfinservsecurities.in:8444/SESSION_DATABASE", "platformwrite", "bfslwrite");
				//l.logger.info("Login::JDBC connection is established");
				log.info("Login::JDBC connection is established");
				out.println("logged in successfully");
				HttpSession session=req.getSession();  
			    session.setAttribute("username",userName);  
			    session.setAttribute("password", password);
			    //l.logger.debug("Login::HttpSession created");
			    log.debug("Login::HttpSession created");
			 }else {out.println("please enter the currect username and password");
				 }}
			 catch(Exception e) {			
					e.printStackTrace();
					//l.logger.error("Login::unknown DB problem"+e.getMessage());
					log.error("Login::unknown DB problem"+e.getMessage());
				}
				 finally{
					// l.logger.debug("Login::closing JDBC objects");
					 log.debug("Login::closing JDBC objects");
					 try {
						 if( c!= null)
						 c.close();
						// l.logger.debug("Login::connection object is closed");
						 log.debug("Login::connection object is closed");
					 }
					 catch(SQLException se) {
						 se.printStackTrace();			 
					 }}
		 //l.logger.debug("Login::end of the doPost method");
		 log.debug("Login::end of the doPost method");
		 
				 	}}

	