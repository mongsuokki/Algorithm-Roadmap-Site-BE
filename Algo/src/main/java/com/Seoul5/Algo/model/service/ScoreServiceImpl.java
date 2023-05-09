package com.Seoul5.Algo.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Seoul5.Algo.model.dao.ScoreDao;
import com.Seoul5.Algo.model.dto.Score;

@Service
@Transactional
public class ScoreServiceImpl implements ScoreService {

	private ScoreDao sDao;

	@Override
	public int addScore(Score score) {
		return sDao.addScore(score);
	}

	@Override
	public int deleteScore(Score score) {
		return sDao.deleteScore(score);
	}

	@Override
	public int updateScore(Score score) {
		return sDao.updateScore(score);
	}

	@Override
	public int scoreAverage(int pNum) {
		return sDao.scoreAverage(pNum);
	}

}
