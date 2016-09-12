package framework;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import kr.co.mlec.controller.BoardController;

public class URLHandleMapping {

	private Map<String, CtrlAndMethod> mappings;

	public URLHandleMapping() {
		mappings = new HashMap<>();
	}

	public URLHandleMapping(String ctrlNames) {
		mappings = new HashMap<>();
		String[] ctrlList = ctrlNames.split(";");
		try {
			for (String ctrlName : ctrlList) {
				Class<?> clz = Class.forName(ctrlName.trim());
				Object target = clz.newInstance();
				for (Method m : clz.getMethods()) {
					RequestMapping rm = m.getDeclaredAnnotation(RequestMapping.class);
					if (rm == null)
						continue;
					this.mappings.put(rm.value(), new CtrlAndMethod(target, m));
				}
			}
		} catch (Exception e) {
			new ServletException(e);
		}
	}
	/*
	 * boolean chk = false;
	 * 
	 * for (Method m : BoardController.class.getDeclaredMethods()) {
	 * RequestMapping mapping = m.getDeclaredAnnotation(RequestMapping.class);
	 * if (mapping != null && mapping.value().equalsIgnoreCase(requestUri)) {
	 * try {
	 * mav = (ModelAndView) m.invoke(new BoardController());
	 * chk = true;
	 * break;
	 * } catch (Exception e) {
	 * e.printStackTrace();
	 * }
	 * }
	 * }
	 * 
	 */

	public CtrlAndMethod getCtrlAndMethod(String requestUri) {
		System.out.println(requestUri);
		return mappings.get(requestUri);
	}
}
