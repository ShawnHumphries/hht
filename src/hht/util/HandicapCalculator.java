package hht.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import hht.business.GolfScore;

/*
 * This class uses the USGA formula to calculate the handicap based on a list of 20 scores.
 * NOTE: Lists of less than 20 scores are not supported.
 * For additional information, please go to:  http://www.usga.org/Handicapping/handicap-manual.html
 */
public class HandicapCalculator {

	public static double calculateHandicap(ArrayList<GolfScore> golfScores)
	{
		double hcp = 0.0;
		double sumDiffs = 0.0;
		ArrayList<GolfScore> scores = (ArrayList<GolfScore>) golfScores.clone();
		
		DecimalFormat df = new DecimalFormat("#.#");
		df.setRoundingMode(RoundingMode.HALF_UP);	// USGA rules for handicapping may dictate otherwise...
		
		// If the list of scores has more than 20 elements, remove the extra elements
		if (scores.size() > 20)
		{
			for (int i=scores.size()-1; i >= 20; i--)
			{
				GolfScore gs = scores.get(i);
				scores.remove(i);
			}
		}

		// Sort the list of scores by differential
		Collections.sort(scores, new Comparator<GolfScore>()
		{
			public int compare (GolfScore g1, GolfScore g2)
			{
				Double diff1 = g1.getDifferential();
				Double diff2 = g2.getDifferential();
				return diff1.compareTo(diff2);
			}
		});

		for (int i=0; i < 10; i++)
		{
			GolfScore gs = scores.get(i);
			sumDiffs += gs.getDifferential();
		}
		System.out.println("Total of lowest 10 differentials: " + sumDiffs);
		
		String avgString = df.format(sumDiffs / 10);
		double average = Double.parseDouble(avgString);
		System.out.println("Average: " + average);
		
		String hcpString = df.format(average * .96);
		hcp = Double.parseDouble(hcpString);
		return hcp;
	}

}
