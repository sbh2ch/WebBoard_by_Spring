package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;
import framework.WebUtil;
import reply.ReplyVO;

public class ReplyUpdateController implements Controller {
	private BoardService service;

	public ReplyUpdateController() {
		service = new BoardServiceImpl();
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		service.updateReply((ReplyVO) WebUtil.getParamToVO(ReplyVO.class, req));

		return new ModelAndView("ajax:{}");
	}

}
