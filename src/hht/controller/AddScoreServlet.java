package hht.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hht.business.GolfScore;
import hht.db.DAOFactory;
import hht.db.golfscore.GolfScoreDAO;
import hht.util.StringUtil;

/**
 * Servlet implementation class AddScoreServlet
 */
@WebServlet({ "/AddScoreServlet", "/addScore" })
public class AddScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddScoreServlet() {
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

		// get parameters from the request
		String playedDate = request.getParameter("datePlayed");
		Date datePlayed = StringUtil.convertStringToSQLDate(playedDate);
		String course = request.getParameter("course");
		String sFront9Score = request.getParameter("front9Score");
		int front9Score = Integer.parseInt(sFront9Score);
		String sBack9Score = request.getParameter("back9Score");
		int back9Score = Integer.parseInt(sBack9Score);
		String sTotalScore = request.getParameter("totalScore");
		int totalScore = Integer.parseInt(sTotalScore);
		String sRating = request.getParameter("rating");
		double rating = Double.parseDouble(sRating);
		String sSlope = request.getParameter("slope");
		int slope = Integer.parseInt(sSlope);
		
		// Create a new GolfScore object
		GolfScore gs = new GolfScore(datePlayed, course, front9Score, back9Score, totalScore, rating, slope);
		
		// Calculate the differential
		gs.calculateDifferential();
		
		// Add the score to the database
		GolfScoreDAO gsDAO = DAOFactory.getGolfScoreDAO();
		if (gsDAO.addScore(gs))
		{
			// The INSERT was successful - get all scores
			// To do : get all scores
			ArrayList<GolfScore> golfScores = gsDAO.getLast20Scores();
			if (golfScores != null)
			{
				// Get the handicap
				double handicap = GolfScore.calculateHandicap(golfScores);
				// Store the handicap in the request
				request.setAttribute("handicap", handicap);
				// Store the scores in the request
				request.setAttribute("golfScores", golfScores);
			}
			
			url = "/viewScores.jsp";
		}
		else
		{
			// The INSERT was unsuccessful
			url = "/index.jsp";
		}

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
