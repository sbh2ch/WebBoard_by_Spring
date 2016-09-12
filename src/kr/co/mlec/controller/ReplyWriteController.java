package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import framework.Controller;
import framework.ModelAndView;
import framework.WebUtil;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;
import kr.co.mlec.member.MemberVO;
import kr.co.mlec.reply.ReplyVO;

public class ReplyWriteController implements Controller {
	private BoardService service;

	public ReplyWriteController() {
		service = new BoardServiceImpl();
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");
		
		int no = Integer.parseInt(req.getParameter("no"));
		ReplyVO r = (ReplyVO) WebUtil.getParamToVO(ReplyVO.class, req);
		r.setName(user.getName());
		r.setOwner(user.getEmail());
		service.replyWrite(r);

		return new ModelAndView("ajax:" + new Gson().toJson(service.listReply(no)));
	}
}
