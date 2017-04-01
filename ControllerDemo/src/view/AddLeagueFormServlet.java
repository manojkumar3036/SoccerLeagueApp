package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddLeagueFormServlet
 */

public class AddLeagueFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/* There are default seasons for US */
	private static final String DEFAULT_SEASONS = "Spring, Summer,Fall,Winter";

	/*
	 * This variable holds the set of seasons
	 * 
	 */
	private String[] SEASONS;

	/*
	 * The init method configures the set of seasons
	 */
	public void init() {
		String seasons_list = getInitParameter("seasons-list");
		if (seasons_list == null) {
			seasons_list = DEFAULT_SEASONS;
		}
		SEASONS = seasons_list.split(",");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		generateView(request, response);

	}

	private void generateView(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

		// Report if any errors
		if (errorMsgs != null) {
			out.println("<p>");
			out.println("<font color='red'> Please Correct the following errors:");
			out.println("<ul>");
			Iterator items = errorMsgs.iterator();
			while (items.hasNext()) {
				String message = (String) items.next();
				out.println("<li>" + message + "</li>");
			}
			out.println("</ul>");
			out.println("</font>");
			out.println("</p>");
		}
		// Generating main body(add a league form)
		out.println("<p>");
		out.println("This form allows you to create a new soccer league");
		out.println("</p>");
		out.println("<form action='AddLeagueServlet' method='POST'>");
		// Repopulate the year field
		String year=request.getParameter("year");
		
		if(year==null)
		{
			year="";
		}
		out.println("Year: <input type='text' name='year'/>");
		out.println("<br/><br/>");
		
		// Repopulate the season drop down menu
		String season=request.getParameter("season");
		out.println("Season: <select name='season'> ");
		if((season==null) || season.equals("UNKNOWN"))
		{
			out.println("<option value='UNKNOWN'> Select...</option>");
		}
		for (int i = 0; i < SEASONS.length; i++) {
			out.println("<option value='" + SEASONS[i] + "'");
			if(SEASONS[i].equals(season))
			{
				out.println("selected");
			}
			out.println(">" + SEASONS[i] + "</option>");
		}
		out.println("</select> ");
		out.println("<br/><br/>");
		String title = request.getParameter("title");
        if ( title == null ) {
            title = "";
        }
		out.println("Title: <input type='text' name='title'/>");
		out.println("<br/><br/>");
		out.println("<input type='submit' value='Add League'/>");

		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		generateView(request, response);
	}

}
