package com.ssafy.fit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ssafy.fit.model.dto.Review;
import com.ssafy.fit.util.DBUtil;

public class ReviewDaoImpl implements ReviewDao {

	private final DBUtil util = DBUtil.getInstance();
	
	private static ReviewDao instance = new ReviewDaoImpl();
	private ReviewDaoImpl() {}
	
	public static ReviewDao getInstance() {
		return instance;
	}
	
	@Override
	public List<Review> selectAll(int videoId) {
		
		String sql = "SELECT * FROM reviews WHERE videoId = ?;";
		
		List<Review> reviewList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 2. 데이터베이스를 연결을 해야 함
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, videoId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Review review = new Review();
				review.setId(rs.getInt("id"));
				review.setTitle(rs.getString("title"));
				review.setWriter(rs.getString("writer"));
				review.setContent(rs.getString("content"));
				review.setRegDate(rs.getString("regDate"));
				review.setVideoId(rs.getInt("videoId"));
				reviewList.add(review);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return reviewList;
	}

	@Override
	public Review selectOne(int id) throws SQLException {
		String sql = "SELECT * FROM reviews WHERE id = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Review review = new Review();
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				review.setId(rs.getInt(1));
				review.setWriter(rs.getString(2));
				review.setTitle(rs.getString(3));
				review.setContent(rs.getString(4));
				review.setRegDate(rs.getString(5));
				review.setVideoId(rs.getInt(6));
			}
			
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return review;
	}

	// videoId도 넣어야 하는 건 아닌지?? 어떻게 넘겨 받을지?? 고민
	@Override
	public void insertReview(Review review) throws SQLException {
		String sql = "INSERT INTO reviews (title, writer, content) VALUES (?, ?, ?);";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = util.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, review.getTitle());
		pstmt.setString(2, review.getWriter());
		pstmt.setString(3, review.getContent());
		
		pstmt.executeUpdate();
		
		util.close(pstmt, conn);
	}

	@Override
	public void deleteReview(int id) throws SQLException {
		String sql = "DELETE FROM reviews WHERE id = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			System.out.println(result + "개의 데이터가 지워졌습니다.");
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void updateReview(Review review) throws SQLException {
		String sql = "UPDATE reviews SET title = ?, content = ? WHERE id = ?;";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, review.getTitle());
			pstmt.setString(2, review.getContent());
			pstmt.setInt(3, review.getId());
			
			pstmt.executeUpdate();
		} finally {
			util.close(pstmt, conn);
		}
	}
}