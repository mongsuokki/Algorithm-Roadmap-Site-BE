package com.Seoul5.Algo.model.dao;

import java.util.List;

import com.Seoul5.Algo.model.dto.Review;

public interface ReviewDao {
	
	int insertReview(Review review);

	int updateReview(Review review);

	Review selectReview(int reviewId);

	int deleteReview(int reviewId);

	List<Review> selectReviewByProblem(int pNum);
}
