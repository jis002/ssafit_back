package com.ssafy.fit.model.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.fit.model.dao.MainDao;
import com.ssafy.fit.model.dao.MainDaoImpl;
import com.ssafy.fit.model.dao.ReviewDao;
import com.ssafy.fit.model.dao.ReviewDaoImpl;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MainDao mainDao = MainDaoImpl.getInstance();
	private ReviewDao reviewDao = ReviewDaoImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// GET 요청에서는 하지 않아도 되지만, POST 요청에서는 인코딩 변경
    	if (request.getMethod().equals("POST")) {
    		request.setCharacterEncoding("UTF-8");
    	}
    	
    	// FrontController 패턴
    	String act = request.getParameter("act");
    	
    	switch (act) {
	    	case "list":
	    		doList(request, response);
	    		break;
	    	case "writeform":
	    		doWriteForm(request, response);
	    		break;
	    	case "write":
	    		doWrite(request, response);
	    		break;
	    	case "detail":
	    		doDetail(request, response);
	    		break;
	    	case "modifyform":
	    		doModifyForm(request, response);
	    		break;
	    	case "modify":
	    		doModify(request, response);
	    		break;
	    	case "remove":
	    		doRemove(request, response);
	    		break;
	    	default:
	    		break;
    	}
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int videoId = Integer.parseInt(request.getParameter("videoId"));
		
		try {
			request.setAttribute("video", mainDao.selectOne(videoId));
			request.setAttribute("reviewList", reviewDao.selectAll(videoId));
			request.getRequestDispatcher("/video/list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void doWriteForm(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void doWrite(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void doModifyForm(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void doModify(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) {
		
	}
}