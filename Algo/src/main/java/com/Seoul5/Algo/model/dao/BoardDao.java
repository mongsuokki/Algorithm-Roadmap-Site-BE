package com.Seoul5.Algo.model.dao;

import java.util.List;

import com.Seoul5.Algo.model.dto.Board;
import com.Seoul5.Algo.model.dto.SearchCondition;

public interface BoardDao {
	
	int insertBoard(Board board);

	int deleteBoard(int bNum);

	List<Board> selectByCondition(SearchCondition searchCondition);

	int updateBoard(Board board);
}
