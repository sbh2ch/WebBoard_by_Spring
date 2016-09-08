package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.ReplyDAO;
import reply.ReplyVO;

@WebServlet("/reply/update")
public class ReplyUpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReplyDAO rDao = new ReplyDAO();
		int replyNo = Integer.parseInt(req.getParameter("replyNo"));
		int no = Integer.parseInt(req.getParameter("no"));
		String content = req.getParameter("content");
		if(!content.equals(""))
			rDao.update(new ReplyVO(replyNo, content));

		resp.sendRedirect("/Test04/board/detail.do?no=" + no);
	}

}
