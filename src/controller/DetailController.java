package controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import framework.Controller;
import framework.ModelAndView;

public class DetailController implements Controller {
	private BoardService service;

	public DetailController() {
		service = new BoardServiceImpl();
	}

	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = new ModelAndView("/jsp/detail.jsp");
		int no = Integer.parseInt(req.getParameter("no"));

		Map<String, Object> models = service.detail(no);
		for (String key : models.keySet())
			mv.addAttribute(key, models.get(key));

		return mv;
	}
}
