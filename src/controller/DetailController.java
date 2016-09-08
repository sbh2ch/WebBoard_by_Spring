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
import reply.ReplyDAO;

@WebServlet("/board/detail")
public class DetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO bDao = new BoardDAO();
		FileDAO fDao = new FileDAO();
		ReplyDAO rDao = new ReplyDAO();
		
		int no = Integer.parseInt(req.getParameter("no"));
		req.setAttribute("f", fDao.select(no));
		req.setAttribute("b", bDao.selectOne(no));
		req.setAttribute("rList", rDao.selectAll(no));
		
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/detail.jsp");
		rd.forward(req, resp);
	}
}
