package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberVO;
import reply.ReplyDAO;
import reply.ReplyVO;

@WebServlet("/reply/write")
public class ReplyWriteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");
		ReplyDAO rDao = new ReplyDAO();
		int no = Integer.parseInt(req.getParameter("no"));
		rDao.insert(new ReplyVO(no, user.getName(), req.getParameter("content"), user.getEmail()));

		resp.sendRedirect("/Test04/board/detail?no=" + no);
	}

}
