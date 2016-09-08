package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;

@WebServlet("/board/updateForm")
public class UpdateFormController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO bDao = new BoardDAO();
		int no = Integer.parseInt(req.getParameter("no"));
		
		req.setAttribute("b", bDao.selectOne(no));
		
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/updateForm.jsp");
		rd.forward(req, resp);
	}
}
