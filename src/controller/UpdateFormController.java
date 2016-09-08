package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import framework.Controller;

public class UpdateFormController implements Controller{

	@Override
		public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO bDao = new BoardDAO();
		int no = Integer.parseInt(req.getParameter("no"));
		
		req.setAttribute("b", bDao.selectOne(no));
		
		return "/jsp/updateForm.jsp";
	}
}
