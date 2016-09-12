package kr.co.mlec.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;
import framework.ModelAndView;
import kr.co.mlec.member.MemberDAO;
import kr.co.mlec.member.MemberVO;

public class Login implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDAO mDao = new MemberDAO();

		String email = req.getParameter("email");
		String pw = req.getParameter("pw");

		MemberVO user = mDao.selectOne(email);

		if (user != null && user.getPw().equals(pw))
			req.getSession().setAttribute("user", user);

		return new ModelAndView("redirect:/Test04/board/list.do");
	}
}