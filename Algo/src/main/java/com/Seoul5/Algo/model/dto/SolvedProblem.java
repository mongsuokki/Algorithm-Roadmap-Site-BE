package com.Seoul5.Algo.model.dto;

import java.util.Date;

public class SolvedProblem {
	private int pNum;
	private String userId;
	private Date solvedDate;
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
	public Date getSolvedDate() {
		return solvedDate;
	}
	public void setSolvedDate(Date solvedDate) {
		this.solvedDate = solvedDate;
	}
	
	
}
