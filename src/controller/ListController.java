package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardVO;
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

		List<BoardVO> bList = service.list();
		mv.addAttribute("bList", bList);

		return mv;
	}
}
