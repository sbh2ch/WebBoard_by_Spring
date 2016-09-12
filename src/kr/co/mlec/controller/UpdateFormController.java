package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;
import framework.ModelAndView;
import kr.co.mlec.board.BoardVO;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;

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