package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;

public class DeleteController implements Controller {
	private BoardService service;

	public DeleteController() {
		service = new BoardServiceImpl();
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		service.deleteBoard(Integer.parseInt(req.getParameter("no")), req);

		return new ModelAndView("redirect:list.do");
	}

}
