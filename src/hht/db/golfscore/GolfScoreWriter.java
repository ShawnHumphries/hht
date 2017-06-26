package hht.db.golfscore;

import hht.business.GolfScore;

public interface GolfScoreWriter {

	boolean addScore(GolfScore score);
	boolean updateCounted(int id, boolean isCounted);
}
