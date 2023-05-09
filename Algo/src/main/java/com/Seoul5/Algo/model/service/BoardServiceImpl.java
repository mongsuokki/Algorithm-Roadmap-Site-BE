package com.Seoul5.Algo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Seoul5.Algo.model.dao.BoardDao;
import com.Seoul5.Algo.model.dto.Board;
import com.Seoul5.Algo.model.dto.SearchCondition;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao bDao;

	@Override
	
	public int insertBoard(Board board) {
		return bDao.insertBoard(board);
	}

	@Override
	public int deleteBoard(int bNum) {
		return bDao.deleteBoard(bNum);
	}

	@Override
	public List<Board> selectByCondition(SearchCondition searchCondition) {
		return bDao.selectByCondition(searchCondition);
	}

	@Override
	public int updateBoard(Board board) {
		return bDao.updateBoard(board);
	}

}
