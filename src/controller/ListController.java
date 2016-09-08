package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;
import framework.Controller;

public class ListController implements Controller{
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BoardDAO bDao = new BoardDAO();

		List<BoardVO> bList = bDao.selectAll();
		req.setAttribute("bList", bList);

		return "/jsp/list.jsp";
	}
}
