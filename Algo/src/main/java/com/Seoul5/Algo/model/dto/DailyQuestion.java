package com.Seoul5.Algo.model.dto;

import java.util.List;

public class DailyQuestion {
	private int difficulty;
	// 1 브론즈까지 2 실버까지 3 골드까지 ...
	// 따로 Problem 에 난이도 추가할 필요 없이 백준 API로 검색한다음 매칭시키면 되지 않을까?
	private List<String> Algo;
	private boolean again;

	// 풀었던 문제 다시 추천할지
	public DailyQuestion() {
		// TODO Auto-generated constructor stub
	}
	public DailyQuestion(int difficulty, List<String> algo, boolean again) {
		super();
		this.difficulty = difficulty;
		Algo = algo;
		this.again = again;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public List<String> getAlgo() {
		return Algo;
	}
	
	public boolean isAgain() {
		return again;
	}
}
