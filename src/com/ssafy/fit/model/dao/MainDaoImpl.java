package com.ssafy.fit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.fit.model.dto.Video;
import com.ssafy.fit.util.DBUtil;

public class MainDaoImpl implements MainDao {

	// DBUtil 가져와야함.
	private final DBUtil util = DBUtil.getInstance();
	
	// 싱글턴 만들기
	private static MainDaoImpl instance = new MainDaoImpl();
	
	private MainDaoImpl() {
	};
	
	public static MainDaoImpl getInstance() {
		return instance;
	}
	
	
	
	@Override
	public List<Video> selectAll() {
		List<Video> list = new ArrayList<Video>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM videos";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		
		
		
		
		return list;
	}

	@Override
	public Video selectOne(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateViewCnt(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
