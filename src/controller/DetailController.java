package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import file.FileDAO;
import framework.Controller;
import reply.ReplyDAO;

public class DetailController implements Controller{

	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BoardDAO bDao = new BoardDAO();
		FileDAO fDao = new FileDAO();
		ReplyDAO rDao = new ReplyDAO();
		
		int no = Integer.parseInt(req.getParameter("no"));
		req.setAttribute("f", fDao.select(no));
		req.setAttribute("b", bDao.selectOne(no));
		req.setAttribute("rList", rDao.selectAll(no));
		
		return "/jsp/detail.jsp";
	}
}
