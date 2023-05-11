package com.Seoul5.Algo.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Seoul5.Algo.model.dao.ReviewDao;
import com.Seoul5.Algo.model.dto.Review;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	private ReviewDao rDao;
	
	@Override
	public int insertReview(Review review) {
		return rDao.insertReview(review);
	}

	@Override
	public int updateReview(Review review) {
		return rDao.updateReview(review);
	}

	@Override
	public Review selectReview(int reviewId) {
		return rDao.selectReview(reviewId);
	}

	@Override
	public int deleteReview(int reviewId) {
		return rDao.deleteReview(reviewId);
	}

	@Override
	public List<Review> selectReviewByProblem(int pNum) {
		return rDao.selectReviewByProblem(pNum);
	}

}
