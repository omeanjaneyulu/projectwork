package com.uber;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DBoperation;
import com.uberbooking.UberBooking;

//@webServlet("/DemoServelet")
	public class ServletDemo extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public ServletDemo() {
	super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("form submitted on GET");
	String startingpoint=request.getParameter("startingpoint");
	String endingpoint=request.getParameter( "endingpoint");
	String journeyprice=request.getParameter("journeyprice");
	 long price=0L;
	 try {
		 price=Long.parseLong(journeyprice);
		 
	 }
	catch(Exception e) {
		price=0L;
	}
	UberBooking es = new UberBooking();
	es.setStartingpoint(startingpoint);
	es.setEndingpoint(endingpoint);
	es.setJourneyprice(price);
	
	
	DBoperation we = new DBoperation();
	int result = we.insertDataWithStatement(es);
	HttpSession session = request.getSession();
	session.setAttribute("Object", es);

	RequestDispatcher empservlet = request.getRequestDispatcher("/UberServlet");
	RequestDispatcher failure = request.getRequestDispatcher("Fail.html");
	if(result>0) {
	empservlet.forward(request, response);
	} else {
	failure.forward(request, response);
	}


	}


	}


