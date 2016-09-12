package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;
import framework.ModelAndView;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;
import kr.co.mlec.member.MemberVO;

public class WriteController implements Controller {
	private BoardService service;

	public WriteController() {
		service = new BoardServiceImpl();
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");
		String path = req.getServletContext().getRealPath("/upload");

		int no = service.writeBoard(path, user, req);

		return new ModelAndView("redirect:/Test04/board/detail.do?no=" + no);
	}
}
