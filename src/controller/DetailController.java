package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import file.FileDAO;
import framework.Controller;
import framework.ModelAndView;
import reply.ReplyDAO;

public class DetailController implements Controller{

	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ModelAndView mv = new ModelAndView();
		BoardDAO bDao = new BoardDAO();
		FileDAO fDao = new FileDAO();
		ReplyDAO rDao = new ReplyDAO();
		
		int no = Integer.parseInt(req.getParameter("no"));
		
		mv.setView("/jsp/detail.jsp");
		mv.addAttribute("f", fDao.select(no));
		mv.addAttribute("b", bDao.selectOne(no));
		mv.addAttribute("rList", rDao.selectAll(no));
		
		return mv;
	}
}
