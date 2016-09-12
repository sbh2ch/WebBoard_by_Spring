package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;

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
