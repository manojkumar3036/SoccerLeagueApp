package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.League;

/**
 * Servlet implementation class AddLeagueServlet
 */
public class AddLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// keeping record of errors
		List errorMsgs = new LinkedList();

		// Storing the set in the request scope, in case we need to send the
		// error in ErrorPage view

		request.setAttribute("errorMsgs", errorMsgs);
		try {
			// Retrieve the form parameters
			String yearStr=request.getParameter("year").trim();
			String season=request.getParameter("season").trim();
			String title=request.getParameter("title").trim();
			
			// perform data conversion
			
			int year=-1;
			try{
				year=Integer.parseInt(yearStr);
			}catch(NumberFormatException nfe)
			{
				errorMsgs.add("The year field must be a positive integer");
			}
			
			// verfiying form parameters
			
			if((year!=-1) && ((year<2000) || (year>2017)))
			{
				errorMsgs.add("The year field must be within 2000 to 2017");
			}

			if(season.equals("UNKNOWN"))
			{
				errorMsgs.add("Please select a league season.");
			}
			if(title.length()==0)
			{
				errorMsgs.add("Please enter the title of the language");
			}
			
			// send the error messages if there are errors
			
			if(!errorMsgs.isEmpty())
			{
				RequestDispatcher view=request.getRequestDispatcher("AddLeagueFormServlet");
				view.forward(request, response);
			}
			
			// perform business logic
			// if everything is fine (no errors) then display the Success Servlet
			
			League league=new League(year,season,title);
			// store the league in the request view to display it in the success page
			request.setAttribute("league", league);
			
			RequestDispatcher view=request.getRequestDispatcher("SuccessServlet");
			view.forward(request, response);
			
			// Let's Handle any unexpected exceptions
		} catch (Exception e) {
			errorMsgs.add(e.getMessage());
			RequestDispatcher view=request.getRequestDispatcher("AddLeagueFormServlet");
			view.forward(request, response);
			
			// Log stack trace
			
			e.printStackTrace(System.err);
			
		} // End of try catch block

	}// End of doPost method

} // End of AddLeagueServlet
