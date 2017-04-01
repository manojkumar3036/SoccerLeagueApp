package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.League;

/**
 * Servlet implementation class ListLeaguesServlet
 */
@WebServlet("/ListLeaguesServlet")
public class ListLeaguesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<League> leagueList=null;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		leagueList = new LinkedList<>();
		leagueList.add(new League(2003, "Spring", "Soccer League(Spring '03)"));
		leagueList.add(new League(2003, "Summer", "Summer Soccer League Fest 2003)"));
		leagueList.add(new League(2003, "Fall", "Fall Soccer League(2003)"));
		leagueList.add(new League(2004, "Spring", "Soccer League(Spring '04)"));
		leagueList.add(new League(2004, "Summer", "Summer Soccer League Fest 2004)"));
		leagueList.add(new League(2004, "Fall", "Fall Soccer League(2004)"));

		// set page title
		String pageTitle = "Duke's Soccer League: List Leagues";

		// specify the content type in HTML

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

		// Generate Main body
		out.println("<p>");
		out.println("The set of soccer leagues are:");
		out.println("</p>");
		out.println("<ul>");
		Iterator items = leagueList.iterator();
		while (items.hasNext()) {
			League league = (League) items.next();
			out.println("<li>" + league.getTitle() + "</li>");

		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");


	}

}
