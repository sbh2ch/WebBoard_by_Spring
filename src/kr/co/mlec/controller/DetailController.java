package kr.co.mlec.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Controller;
import framework.ModelAndView;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;

public class DetailController implements Controller {
	private BoardService service;

	public DetailController() {
		service = new BoardServiceImpl();
	}

	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = new ModelAndView("/jsp/detail.jsp");

		Map<String, Object> models = service.detail(Integer.parseInt(req.getParameter("no")));
		for (String key : models.keySet())
			mv.addAttribute(key, models.get(key));

		return mv;
	}
}
