package hht.db;

import hht.db.golfscore.GolfScoreDAO;
import hht.db.golfscore.GolfScoreDB;

public class DAOFactory {

	public static GolfScoreDAO getGolfScoreDAO() {
		
		GolfScoreDAO gsDAO = new GolfScoreDB();
		return gsDAO;
	}
}
