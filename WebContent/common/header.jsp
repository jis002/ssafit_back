<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setAttribute("root", request.getContextPath());
%>

    <header id="sky">
        <nav class="navbar bg-body-tertiary" style="background-color: aliceblue">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">
                <strong>SSAFIT</strong>
                </a>
                <ul class="nav justify-content-end">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">회원가입</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">로그인</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">고객센터</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>