package kr.co.mlec.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.ModelAndView;
import framework.RequestMapping;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;
import kr.co.mlec.member.MemberDAO;
import kr.co.mlec.member.MemberVO;

public class LoginController {

	private BoardService service;

	public LoginController() {
		service = new BoardServiceImpl();
	}

	@RequestMapping("/login/login.do")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDAO mDao = new MemberDAO();

		String email = req.getParameter("email");
		String pw = req.getParameter("pw");

		MemberVO user = mDao.selectOne(email);

		if (user != null && user.getPw().equals(pw))
			req.getSession().setAttribute("user", user);

		return new ModelAndView("redirect:/Test04/board/list.do");
	}

	@RequestMapping("/login/logout.do")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getSession().invalidate();

		return new ModelAndView("redirect:/Test04/board/list.do");
	}
}
