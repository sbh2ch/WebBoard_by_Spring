package kr.co.mlec.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;
import framework.ModelAndView;
import framework.RequestMapping;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;
import kr.co.mlec.member.MemberDAO;
import kr.co.mlec.member.MemberVO;

@Controller
public class LoginController {
	@RequestMapping("/login/login.do")
	public String login(HttpServletRequest req) throws ServletException, IOException {
		MemberDAO mDao = new MemberDAO();

		String email = req.getParameter("email");
		String pw = req.getParameter("pw");

		MemberVO user = mDao.selectOne(email);

		if (user != null && user.getPw().equals(pw))
			req.getSession().setAttribute("user", user);

		return "redirect:/Test04/board/list.do";
	}

	@RequestMapping("/login/logout.do")
	public String logout(HttpServletRequest req) throws ServletException, IOException {
		req.getSession().invalidate();

		return "redirect:/Test04/board/list.do";
	}
}
