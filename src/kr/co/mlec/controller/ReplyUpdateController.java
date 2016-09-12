package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;
import framework.ModelAndView;
import framework.WebUtil;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;
import kr.co.mlec.reply.ReplyVO;

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
