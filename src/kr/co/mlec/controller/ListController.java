package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;
import framework.ModelAndView;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;

public class ListController implements Controller {
	private BoardService service;

	public ListController() {
		service = new BoardServiceImpl();
	}

	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = new ModelAndView("/jsp/list.jsp");
		mv.addAttribute("bList", service.list());

		return mv;
	}
}
