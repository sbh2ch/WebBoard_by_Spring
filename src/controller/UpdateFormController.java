package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;

public class UpdateFormController implements Controller {
	private BoardService service;

	public UpdateFormController() {
		service = new BoardServiceImpl();
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = new ModelAndView("/jsp/updateForm.jsp");
		mv.addAttribute("b", service.updateForm(Integer.parseInt(req.getParameter("no"))));

		return mv;
	}
}