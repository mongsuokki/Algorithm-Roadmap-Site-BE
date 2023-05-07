package com.Seoul5.Algo.model.dto;

import java.util.List;

public class UserSetting {
	private String id;
	private int difficulty;
	// 1 브론즈까지 2 실버까지 3 골드까지 ...
	// 따로 Problem 에 난이도 추가할 필요 없이 백준 API로 검색한다음 매칭시키면 되지 않을까?
	private List<String> Algo;
	private boolean again;
	private int solvedCnt;
	// 총 푼 문제수 -> 이걸 주 단위로 갱신해서 주간 랭킹 볼 수 있게?
	private int week;
	// 주간 목표 설정
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public List<String> getAlgo() {
		return Algo;
	}
	public void setAlgo(List<String> algo) {
		Algo = algo;
	}
	public boolean isAgain() {
		return again;
	}
	public void setAgain(boolean again) {
		this.again = again;
	}

	
}
