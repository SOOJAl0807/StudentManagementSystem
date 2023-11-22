package studentmanagementsystem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/display")
public class Studentdisplaycontroller extends HttpServlet {
	
	String username = null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		
		//Cookies
//		Cookie[] cookies = req.getCookies();
//		
//		for (Cookie cookie : cookies) {
//			if (cookie.getName().equals("username")) {
//				username = cookie.getValue();
//			}
//		}
//		printWriter.print("<h1> Welcome </h1>");
		
		//HTTP SESSION 
		HttpSession httpSession =req.getSession();
		String username =(String) httpSession.getAttribute("username");
		
		if (username!=null) {
			printWriter.print("<h1>WELCOME</h1>");
		} else {
			printWriter.print("Login with proper credential");
		}
	}
}
