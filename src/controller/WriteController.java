package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;
import member.MemberVO;

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
