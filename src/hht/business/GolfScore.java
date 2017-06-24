package hht.business;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class GolfScore implements Serializable {

	private int id;
	private Date datePlayed;
	private String course;
	private int front9Score;
	private int back9Score;
	private int totalScore;
	private double rating;
	private int slope;
	private double differential;
	
	// Default constructor
	public GolfScore()
	{
		id = 0;
		datePlayed = null;
		course = "";
		front9Score = 0;
		back9Score = 0;
		totalScore = 0;
		rating = 0.0;
		slope = 0;
		differential = 0.0;
	}
	
	public GolfScore(Date datePlayed, String course, int front9Score, int back9Score, int totalScore, double rating, int slope)
	{
		this.datePlayed = datePlayed;
		this.course = course;
		this.front9Score = front9Score;
		this.back9Score = back9Score;
		this.totalScore = totalScore;
		this.rating = rating;
		this.slope = slope;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatePlayed() {
		return datePlayed;
	}

	public void setDatePlayed(Date datePlayed) {
		this.datePlayed = datePlayed;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getFront9Score() {
		return front9Score;
	}

	public void setFront9Score(int front9Score) {
		this.front9Score = front9Score;
	}

	public int getBack9Score() {
		return back9Score;
	}

	public void setBack9Score(int back9Score) {
		this.back9Score = back9Score;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getSlope() {
		return slope;
	}

	public void setSlope(int slope) {
		this.slope = slope;
	}

	public double getDifferential() {
		return differential;
	}

	public void setDifferential(double differential) {
		this.differential = differential;
	}
	
	public double calculateDifferential()
	{
		double diff = 0.0;
		
		DecimalFormat df = new DecimalFormat("#.#");
		df.setRoundingMode(RoundingMode.HALF_UP);
		double d = (getTotalScore() - getRating()) * 113 / getSlope();
		String diffString = df.format(d);
		diff = Double.parseDouble(diffString);
		setDifferential(diff);
		return diff;
	}
	
	public static double calculateHandicap(ArrayList<GolfScore> scores)
	{
		double hcp = 0.0;
		double sumDiffs = 0.0;
		
		DecimalFormat df = new DecimalFormat("#.#");
		df.setRoundingMode(RoundingMode.HALF_UP);	// USGA rules for handicapping may dicate otherwise...

		for (GolfScore gs : scores)
		{
			sumDiffs += gs.getDifferential();
		}
		System.out.println("Total of lowest differentials: " + sumDiffs);
		
		String avgString = df.format(sumDiffs / scores.size());
		double average = Double.parseDouble(avgString);
		System.out.println("Average: " + average);
		
		String hcpString = df.format(average * .96);
		hcp = Double.parseDouble(hcpString);
		return hcp;
	}
}
