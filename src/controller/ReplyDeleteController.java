package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.ReplyDAO;

@WebServlet("/reply/delete")
public class ReplyDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReplyDAO rDao = new ReplyDAO();
		int no = Integer.parseInt(req.getParameter("no"));
		int replyNo = Integer.parseInt(req.getParameter("replyNo"));
		rDao.delete(replyNo);

		resp.sendRedirect("/Test04/board/detail.do?no=" + no);
	}

}
