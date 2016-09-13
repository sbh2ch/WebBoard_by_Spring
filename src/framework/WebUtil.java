package framework;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	public static Object getParamToVO(Class<?> clz, HttpServletRequest req) throws Exception {
		Object obj = clz.newInstance();
		Method[] methods = clz.getDeclaredMethods();

		for (String key : req.getParameterMap().keySet()) {
			for (Method m : methods) {
				if (m.getName().startsWith("set") && m.getName().substring("set".length()).equalsIgnoreCase(key)) {
					switch (m.getParameterTypes()[0].getName()) {
					case "int":
						m.invoke(obj, Integer.parseInt(req.getParameter(key)));
						break;
					default:
						m.invoke(obj, req.getParameter(key));
						break;
					}
				}
			}
		}
		return obj;
	}
}
