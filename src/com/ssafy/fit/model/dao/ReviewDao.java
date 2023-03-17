package com.ssafy.fit.model.dao;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.fit.model.dto.Review;

public interface ReviewDao {
	
	// 모든 리뷰 가져오기
	public List<Review> selectAll(int videoId);
	
	// ID에 해당하는 리뷰 하나 가져오기
	public Review selectOne(int id) throws SQLException;
	
	// 리뷰 등록
	public void insertReview(Review review) throws SQLException;
	
	// 리뷰 삭제 
	public void deleteReview(int id) throws SQLException;
	
	// 리뷰 수정
	public void updateReview(Review review) throws SQLException;
}