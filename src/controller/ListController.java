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

@WebServlet("/board/list")
public class ListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BoardDAO bDao = new BoardDAO();
		
		List<BoardVO> bList = bDao.selectAll();
		req.setAttribute("bList", bList);
		
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/list.jsp");
		rd.forward(req, res);
	}
}
