package com.ssafy.fit.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.fit.model.dto.Video;

public interface MainDao {
	
	// 모든 영상 가져오기
	public List<Video> selectAll();
	
	// ID에 해당하는 영상 하나 가져오기
	public Video selectOne(int id) throws SQLException;
	
	// ID에 해당하는 영상 조회수 증가
	public void updateViewCnt(int id) throws SQLException;
	
}
