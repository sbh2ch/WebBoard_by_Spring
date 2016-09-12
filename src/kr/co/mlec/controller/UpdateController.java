package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;
import framework.ModelAndView;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;

public class UpdateController implements Controller {
	private BoardService service;

	public UpdateController() {
		service = new BoardServiceImpl();
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String path = req.getServletContext().getRealPath("/upload");
		int no = service.updateBoard(path, req);

		return new ModelAndView("redirect:/Test04/board/detail.do?no=" + no);
	}
}
