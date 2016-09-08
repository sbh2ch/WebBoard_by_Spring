package framework;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author son
 * 
 *         예전방식(url패턴)
 *         /board/list.do -> BoardListController
 *         /board/write.do -> BoardWriteController
 * 
 *         command패턴
 *         /board.do?type=list -> BoardListController
 *         /board.do?type=write -> BoardWriteController
 * 
 *         우선은 URL패턴으로 연습하고자 함.
 * 
 * 
 *         사용자의 요청을 받고,
 *         요청에 해당하는 작업 컨트롤러 클래스를 호출하고
 *         작업클래스에서 실행한 결과를
 *         사용자 화면 페이지를 호춣하여 사용할 수 있게 한다.
 * 
 *         이후 자동 파라미터 처리, 사용자 요청 작업 클래스를 검색하는 부분을 효율적으로 변경
 */
public class DispatcherServlet extends HttpServlet {
	private URLHandleMapping mappings = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		mappings = new URLHandleMapping();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String requestUri = req.getRequestURI().substring(req.getContextPath().length());
		String view = null;
		Controller controller = null;

		controller = mappings.getController(requestUri);

		if (controller == null)
			throw new ServletException("요청한 URL이 없음.");

		ModelAndView mav = controller.execute(req, res);
		view = mav.getView();
		if (view.startsWith("redirect:")) {
			res.sendRedirect(view.substring("redirect:".length()));
		} else {
			Map<String, Object> model = mav.getModel();
			Set<String> keys = model.keySet();

			for(String key : keys)
				req.setAttribute(key, model.get(key));
			
			RequestDispatcher rd = req.getRequestDispatcher(view);
			rd.forward(req, res);
		}
	}
}
