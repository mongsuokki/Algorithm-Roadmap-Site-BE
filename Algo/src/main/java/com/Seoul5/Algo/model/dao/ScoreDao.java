package com.Seoul5.Algo.model.dao;

import com.Seoul5.Algo.model.dto.Score;

public interface ScoreDao {
	
	int addScore(Score score);

	int deleteScore(Score score);

	int updateScore(Score score);

	int scoreAverage(int pNum);
}
