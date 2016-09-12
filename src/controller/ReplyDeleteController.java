package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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
		service.replyDelete(Integer.parseInt(req.getParameter("replyNo")));

		return new ModelAndView("ajax:" + new Gson().toJson(service.listReply(Integer.parseInt(req.getParameter("no")))));
	}

}
