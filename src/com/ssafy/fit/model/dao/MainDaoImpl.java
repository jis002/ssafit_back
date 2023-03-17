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
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Video video = new Video();
				video.setId(rs.getInt("id"));
				video.setTitle(rs.getString("title"));
				video.setFitPartName(rs.getString("fitPartName"));
				video.setChannelName(rs.getString("channelName"));
				video.setViewCnt(rs.getInt("viewCnt"));
				video.setImg(rs.getString("img"));
				
				list.add(video);
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
		String sql = "SELECT * FROM videos WHERE id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Video video = new Video();
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				video.setId(rs.getInt(1));
				video.setTitle(rs.getString(2));
				video.setFitPartName(rs.getString(3));
				video.setYoutubeId(rs.getString(4));
				video.setChannelName(rs.getString(5));
				video.setViewCnt(rs.getInt(6));
				video.setImg(rs.getString(7));
			}
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return video;
	}

	@Override
	public void updateViewCnt(int id) throws SQLException {

		String sql = "UPDATE videos SET viewCnt = viewCnt + 1 WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public List<Video> selectRecent() {
		List<Video> list = new ArrayList<Video>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM videos ORDER BY viewCnt DESC";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Video video = new Video();
				video.setId(rs.getInt("id"));
				video.setTitle(rs.getString("title"));
				video.setFitPartName(rs.getString("fitPartName"));
				video.setChannelName(rs.getString("channelName"));
				video.setViewCnt(rs.getInt("viewCnt"));
				video.setImg(rs.getString("img"));
				
				list.add(video);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return list;
	}

	@Override
	public List<Video> selectCategory(String fitPartName) {
		List<Video> list = new ArrayList<Video>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM videos WHERE fitPartName=? ORDER BY viewCnt DESC";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fitPartName);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				Video video = new Video();
				video.setId(rs.getInt("id"));
				video.setTitle(rs.getString("title"));
				video.setFitPartName(rs.getString("fitPartName"));
				video.setChannelName(rs.getString("channelName"));
				video.setViewCnt(rs.getInt("viewCnt"));
				video.setImg(rs.getString("img"));
				
				list.add(video);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		return list;
	}
}