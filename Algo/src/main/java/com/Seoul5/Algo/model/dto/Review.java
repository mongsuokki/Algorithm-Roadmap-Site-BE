package com.Seoul5.Algo.model.dto;

public class Review {
	private int pNum;
	private String userId;
	private String content;

	public Review(int pNum, String userId, String content) {
		this.pNum = pNum;
		this.userId = userId;
		this.content = content;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
