package kr.co.mlec.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import framework.ModelAndView;
import framework.RequestMapping;
import framework.WebUtil;
import kr.co.mlec.board.BoardVO;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;
import kr.co.mlec.member.MemberDAO;
import kr.co.mlec.member.MemberVO;
import kr.co.mlec.reply.ReplyVO;

public class BoardController {
	private BoardService service;

	public BoardController() {
		service = new BoardServiceImpl();
	}

	@RequestMapping("/reply/delete.do")
	public ModelAndView replyDeleteAjax(int no, int replyNo) throws Exception {
		service.replyDelete(replyNo);

		return new ModelAndView("ajax:" + new Gson().toJson(service.listReply(no)));
	}

	@RequestMapping("/board/commentList.do")
	public ModelAndView replyListAjax(int no) throws Exception {
		return new ModelAndView("ajax:" + new Gson().toJson(service.listReply(no)));
	}

	@RequestMapping("/reply/write.do")
	public ModelAndView replyWriteAjax(int no, ReplyVO r, HttpServletRequest req) throws Exception {
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");

		r.setName(user.getName());
		r.setOwner(user.getEmail());
		service.replyWrite(r);

		return new ModelAndView("ajax:" + new Gson().toJson(service.listReply(no)));
	}

	@RequestMapping("/reply/update.do")
	public ModelAndView replyUpdateAjax(ReplyVO reply) throws Exception {
		service.updateReply(reply);

		return new ModelAndView("ajax:{}");
	}

	@RequestMapping("/board/delete.do")
	public ModelAndView boardDelete(HttpServletRequest req) throws Exception {
		service.deleteBoard(Integer.parseInt(req.getParameter("no")), req);

		return new ModelAndView("redirect:list.do");
	}

	@RequestMapping("/board/detail.do")
	public ModelAndView boardDetail(int no) throws Exception {
		ModelAndView mv = new ModelAndView("/jsp/detail.jsp");

		Map<String, Object> models = service.detail(no);
		for (String key : models.keySet())
			mv.addAttribute(key, models.get(key));

		return mv;
	}

	@RequestMapping("/board/list.do")
	public ModelAndView boardList() throws Exception {
		ModelAndView mv = new ModelAndView("/jsp/list.jsp");
		mv.addAttribute("bList", service.list());

		return mv;
	}

	@RequestMapping("/board/update.do")
	public ModelAndView boardUpdate(int no, BoardVO b) throws Exception {
		service.updateBoard(b);

		return new ModelAndView("redirect:/Test04/board/detail.do?no=" + no);
	}

	@RequestMapping("/board/updateForm.do")
	public ModelAndView boardUpdateForm(int no) throws Exception {
		ModelAndView mv = new ModelAndView("/jsp/updateForm.jsp");
		mv.addAttribute("b", service.updateForm(no));

		return mv;
	}

	@RequestMapping("/board/write.do")
	public ModelAndView boardWrite(HttpServletRequest req) throws Exception {
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");
		String path = req.getServletContext().getRealPath("/upload");

		int no = service.writeBoard(path, user, req);

		return new ModelAndView("redirect:/Test04/board/detail.do?no=" + no);
	}

	@RequestMapping("/board/writeForm.do")
	public ModelAndView boardWriteForm() throws ServletException, IOException {
		return new ModelAndView("redirect:/Test04/jsp/writeForm.jsp");
	}

}
