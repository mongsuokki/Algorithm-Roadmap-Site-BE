package com.Seoul5.Algo.model.dto;

public class User {
	private String id;
	private String name;
	private String password;
	private String BOJid;
	private String email;
	private String img;
	private int solvedCnt;
	private int week;

	public User(String id, String name, String password, String bOJid, String email, String img, int solvedCnt,
			int week) {
		this.id = id;
		this.name = name;
		this.password = password;
		BOJid = bOJid;
		this.email = email;
		this.img = img;
		this.solvedCnt = solvedCnt;
		this.week = week;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBOJid() {
		return BOJid;
	}

	public void setBOJid(String bOJid) {
		BOJid = bOJid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getSolvedCnt() {
		return solvedCnt;
	}

	public void setSolvedCnt(int solvedCnt) {
		this.solvedCnt = solvedCnt;
	}

}
