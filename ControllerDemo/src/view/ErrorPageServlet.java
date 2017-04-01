/*package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*//**
 * Servlet implementation class ErrorPageServlet
 *//*

public class ErrorPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		generateView(request, response);
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		generateView(request, response);
	}

	public void generateView(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// set page title
		String pageTitle = "Duke's Soccer League: Error Page";

		// Retrieve the errorMsgs from the request scope

		List errorMsgs = (List) request.getAttribute("errorMsgs");

		// specify the set content type

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Generate HTML response
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + pageTitle + "</title>");
		out.println("</head>");
		out.println("<body bgcolor='white'>");

		// Generating pageHeading
		out.println("<!--Page Heading-->");
		out.println("<table border='1' cellpadding='5' cellspacing='0' width='400'>");
		out.println("<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>");
		out.println("<td><h3>" + pageTitle + "</h3></td>");
		out.println("</tr>");
		out.println("</table>");

		// Generate main body
		out.println("<p>");
		out.println("<font color='red'> Please Correct the following errors:");
		out.println("<ul>");
		Iterator items = errorMsgs.iterator();
		while (items.hasNext()) {
			String message = (String) items.next();
			out.println("<li>" + message + "</li>");
		}
		out.println("</ul>");
		out.println("Back up and try again");
		out.println("</font>");
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");

	}

}
*/