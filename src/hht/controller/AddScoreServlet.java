package hht.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hht.business.GolfScore;
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
		System.out.println("Information about the round...");
		System.out.println("Date:" + "\t" + datePlayed);
		System.out.println("Course:" +"\t" + course);
		System.out.println("Score:" + "\t" + totalScore);
		System.out.println("Rating:" + "\t" + rating);
		System.out.println("Slope:" + "\t" + slope);
		System.out.println("Differential:" + "\t" + gs.getDifferential());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
