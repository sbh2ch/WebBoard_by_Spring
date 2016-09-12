package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import framework.Controller;
import framework.ModelAndView;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;

public class CommentListController implements Controller {
	private BoardService service;

	public CommentListController() {
		service = new BoardServiceImpl();
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return new ModelAndView("ajax:" + new Gson().toJson(service.listReply(Integer.parseInt(req.getParameter("no")))));
	}
}
