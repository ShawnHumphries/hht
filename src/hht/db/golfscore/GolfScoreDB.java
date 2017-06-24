package hht.db.golfscore;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hht.business.GolfScore;
import hht.util.DBUtil;

public class GolfScoreDB implements GolfScoreDAO {

	private ArrayList<GolfScore> golfScores = null;

	@Override
	public boolean addScore(GolfScore score) {

		String sql = "INSERT INTO golf_scores (Date, Course, Front9Score, Back9Score, TotalScore, Rating, Slope, Differential) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql))
		{
			ps.setDate(1, (Date) score.getDatePlayed());
			ps.setString(2, score.getCourse());
			ps.setInt(3, score.getFront9Score());	
			ps.setInt(4, score.getBack9Score());
			ps.setInt(5, score.getTotalScore());
			ps.setDouble(6, score.getRating());
			ps.setInt(7, score.getSlope());
			ps.setDouble(8, score.getDifferential());
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println(e);
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<GolfScore> getAllScores() {

		golfScores = new ArrayList<>();
		String sql = "SELECT ID, Date, Course, Front9Score, Back9Score, TotalScore, Rating, Slope, Differential " 
				+ "from golf_scores "
				+ "order by ID DESC";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery())
        {
        	while (rs.next())
        	{
        		GolfScore gs = getGolfScoreFromRow(rs);
        		golfScores.add(gs);
        	}
        }
        catch (SQLException e)
        {
        	System.out.println(e);
        	return null;
        }
		return golfScores;
	}
	
	@Override
	public ArrayList<GolfScore> getLast20Scores() {

		golfScores = new ArrayList<>();
		String sql = "SELECT ID, Date, Course, Front9Score, Back9Score, TotalScore, Rating, Slope, Differential " 
				+ "from golf_scores "
				+ "order by Date DESC "
				+ "limit 20";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery())
        {
        	while (rs.next())
        	{
        		GolfScore gs = getGolfScoreFromRow(rs);
        		golfScores.add(gs);
        	}
        }
        catch (SQLException e)
        {
        	System.out.println(e);
        	return null;
        }
		return golfScores;
	}

	private static GolfScore getGolfScoreFromRow(ResultSet rs) throws SQLException
	{
		GolfScore gs = new GolfScore();
		
		gs.setId(rs.getInt("ID"));
		gs.setDatePlayed(rs.getDate("Date"));
		gs.setCourse(rs.getString("Course"));
		gs.setFront9Score(rs.getInt("Front9Score"));
		gs.setBack9Score(rs.getInt("Back9Score"));
		gs.setTotalScore(rs.getInt("TotalScore"));
		gs.setRating(rs.getDouble("Rating"));
		gs.setSlope(rs.getInt("Slope"));
		gs.setDifferential(rs.getDouble("Differential"));
		
		return gs;
	}

}
