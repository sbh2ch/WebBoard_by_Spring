package kr.co.mlec.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import framework.Controller;
import framework.ModelAndView;
import framework.RequestMapping;
import kr.co.mlec.board.BoardVO;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.service.BoardServiceImpl;
import kr.co.mlec.member.MemberVO;
import kr.co.mlec.reply.ReplyVO;

@Controller
public class BoardController {
	private BoardService service;

	public BoardController() {
		service = new BoardServiceImpl();
	}

	@RequestMapping("/reply/delete.do")
	public String replyDeleteAjax(int no, int replyNo) throws Exception {
		service.replyDelete(replyNo);

		return "ajax:" + new Gson().toJson(service.listReply(no));
	}

	@RequestMapping("/board/commentList.do")
	public String replyListAjax(int no) throws Exception {
		return "ajax:" + new Gson().toJson(service.listReply(no));
	}

	@RequestMapping("/reply/write.do")
	public String replyWriteAjax(int no, ReplyVO r, HttpServletRequest req) throws Exception {
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");

		r.setName(user.getName());
		r.setOwner(user.getEmail());
		service.replyWrite(r);

		return "ajax:" + new Gson().toJson(service.listReply(no));
	}

	@RequestMapping("/reply/update.do")
	public String replyUpdateAjax(ReplyVO reply) throws Exception {
		service.updateReply(reply);

		return "ajax:{}";
	}

	@RequestMapping("/board/delete.do")
	public String boardDelete(HttpServletRequest req) throws Exception {
		service.deleteBoard(Integer.parseInt(req.getParameter("no")), req);

		return "redirect:list.do";
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
	public String boardUpdate(int no, BoardVO b) throws Exception {
		service.updateBoard(b);

		return "redirect:/Test04/board/detail.do?no=" + no;
	}

	@RequestMapping("/board/updateForm.do")
	public ModelAndView boardUpdateForm(int no) throws Exception {
		ModelAndView mv = new ModelAndView("/jsp/updateForm.jsp");
		mv.addAttribute("b", service.updateForm(no));

		return mv;
	}

	@RequestMapping("/board/write.do")
	public String boardWrite(HttpServletRequest req) throws Exception {
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");
		String path = req.getServletContext().getRealPath("/upload");

		int no = service.writeBoard(path, user, req);

		return "redirect:/Test04/board/detail.do?no=" + no;
	}

	@RequestMapping("/board/writeForm.do")
	public String boardWriteForm() throws ServletException, IOException {
		return "redirect:/Test04/jsp/writeForm.jsp";
	}

}
