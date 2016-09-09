package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;
import reply.ReplyDAO;

public class ReplyDeleteController implements Controller {
	private BoardService service;

	public ReplyDeleteController() {
		service = new BoardServiceImpl();
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int no = Integer.parseInt(req.getParameter("no"));
		int replyNo = Integer.parseInt(req.getParameter("replyNo"));
		service.replyDelete(replyNo);

		return new ModelAndView("redirect:/Test04/board/detail.do?no=" + no);
	}

}
