package framework;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	public static Object getParamToVO(Class<?> clz, HttpServletRequest req) throws Exception {
		Object obj = clz.newInstance();
		Method[] methods = clz.getMethods();

		for (String key : req.getParameterMap().keySet()) {
			for (Method m : methods) {
				if (m.getName().startsWith("set") && m.getName().substring(3).equalsIgnoreCase(key)) {
					if (m.getParameterTypes()[0].getName().equals("int"))
						m.invoke(obj, Integer.parseInt(req.getParameter(key)));
					else
						m.invoke(obj, req.getParameter(key));
				}
			}
		}

		return obj;
	}
}
