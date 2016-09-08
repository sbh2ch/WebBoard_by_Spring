package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;
import reply.ReplyDAO;
import reply.ReplyVO;

public class ReplyUpdateController  implements Controller {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReplyDAO rDao = new ReplyDAO();
		int replyNo = Integer.parseInt(req.getParameter("replyNo"));
		int no = Integer.parseInt(req.getParameter("no"));
		String content = req.getParameter("content");
		if(!content.equals(""))
			rDao.update(new ReplyVO(replyNo, content));

		return "redirect:/Test04/board/detail.do?no=" + no;
	}

}
