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
		
		GolfScoreDAO gsDAO = DAOFactory.getGolfScoreDAO();
		ArrayList<GolfScore> golfScores = gsDAO.getAllScores();
		// store GolfScore object in request
		request.setAttribute("golfScores", golfScores);

		// Get the handicap
		double handicap = GolfScore.calculateHandicap(golfScores);
		// Store the handicap in the request
		request.setAttribute("handicap", handicap);
		
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
