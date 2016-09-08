package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import file.FileDAO;
import file.FileVO;
import framework.Controller;
import reply.ReplyDAO;

public class DeleteController implements Controller {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO bDao = new BoardDAO();
		FileDAO fDao = new FileDAO();
		ReplyDAO rDao = new ReplyDAO();
		int no = Integer.parseInt(req.getParameter("no"));

		bDao.delete(no);
		rDao.delete(no);

		FileVO f = fDao.select(no);
		if (f != null)
			fDao.delete(f, req.getServletContext());

		return "redirect:list.do";
	}

}
