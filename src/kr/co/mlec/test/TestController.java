package kr.co.mlec.test;

import framework.Controller;
import framework.ModelAndView;
import framework.RequestMapping;
import framework.RequestParam;

@Controller
public class TestController {
	@RequestMapping("/test/list.do")
	public ModelAndView test(@RequestParam("msg") String msg) {
		ModelAndView mav = new ModelAndView("/test/list.jsp");
		mav.addAttribute("msg", msg);

		return mav;
	}
}
