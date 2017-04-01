package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.League;

/**
 * Servlet implementation class SuccessServlet
 */

public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		generatView(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		generatView(request, response);

	}

	public void generatView(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// set page title
		String pageTitle = "Duke's Soccer League: Success";
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

		out.println("Your request to add");
		League league = (League) request.getAttribute("league");
		out.println("<i>" + league.getTitle() + "</i>");
		out.println("was successful");

		out.println("</p>");
		out.println("</body>");
		out.println("</html>");

	}

}
