package com.uber;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uberbooking.UberBooking;


public class UberServlet extends HttpServlet {
	public UberServlet() {
		super();
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		Object obj =session.getAttribute("Object");
		UberBooking ub = null;
		if(obj!=null) {
		ub = (UberBooking)obj;
		}
		
		PrintWriter pw = response.getWriter();
		pw.print("<html><body><table>");
		pw.print("<tr><th>startingpoint</th><th></th><th>endingpoint</th><th>journeyprice</th>");
					    pw.print("<tr><td>"+ub.getStartingpoint()+"</td>");
				    pw.print("<td>"+ub.getEndingpoint()+"</td>");
					    pw.print("<td>"+ub.getJourneyprice()+"</td>");
				
	     
		
	pw.print("<tr><td><button><a href='Index.html'>Homepage</a></td></tr>");

		pw.print("</table></body></html>");
		}
		
		}


