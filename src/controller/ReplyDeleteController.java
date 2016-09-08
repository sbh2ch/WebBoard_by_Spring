package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;
import reply.ReplyDAO;


public class ReplyDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReplyDAO rDao = new ReplyDAO();
		int no = Integer.parseInt(req.getParameter("no"));
		int replyNo = Integer.parseInt(req.getParameter("replyNo"));
		rDao.delete(replyNo);

		return "redirect:/Test04/board/detail.do?no=" + no;
	}

}
