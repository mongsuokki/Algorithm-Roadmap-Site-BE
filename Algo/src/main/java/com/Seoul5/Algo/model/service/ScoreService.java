package com.Seoul5.Algo.model.service;

import com.Seoul5.Algo.model.dto.Score;

public interface ScoreService {
	
	int addScore(Score score);

	int deleteScore(Score score);

	int updateScore(Score score);

	int scoreAverage(int pNum);
}
