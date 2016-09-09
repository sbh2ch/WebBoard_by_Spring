package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;
import reply.ReplyVO;

public class ReplyUpdateController implements Controller {
	private BoardService service;

	public ReplyUpdateController() {
		service = new BoardServiceImpl();
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int replyNo = Integer.parseInt(req.getParameter("replyNo"));
		String content = req.getParameter("content");

		if (!content.equals(""))
			service.updateReply(new ReplyVO(replyNo, content));

		return new ModelAndView("ajax:{}");
	}

}
