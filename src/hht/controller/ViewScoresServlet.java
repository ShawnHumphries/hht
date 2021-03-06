package hht.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hht.business.GolfScore;
import hht.db.DAOFactory;
import hht.db.golfscore.GolfScoreDAO;
import hht.util.HandicapCalculator;

/**
 * Servlet implementation class ViewScoresServlet
 */
@WebServlet({ "/ViewScoresServlet", "/viewAllScores", "/viewScores" })
public class ViewScoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewScoresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String url = "";
		ArrayList<GolfScore> golfScores = null;
		
		// get current action
		String action = request.getParameter("action");
		System.out.println("Action=" + action);
		if (action == null) {
			action = "viewAllScores";
		}

		GolfScoreDAO gsDAO = DAOFactory.getGolfScoreDAO();
		
		if (action.equals("viewAllScores"))
		{
			golfScores = gsDAO.getAllScores();
		}
		else if (action.equals("viewScores"))
		{
			golfScores = gsDAO.getLast20Scores();
		}
		
		if (golfScores != null)
		{
			// Get the handicap
			double handicap = HandicapCalculator.calculateHandicap(golfScores);
			// Store the handicap in the request
			request.setAttribute("handicap", handicap);
		}

		// store GolfScore object in request
		request.setAttribute("golfScores", golfScores);
		// forward request to viewScores.jsp
        url = "/viewScores.jsp";

        getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
