package framework;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

public class PreParameterProcess {

	/**
	 * @param method
	 *            : URI에 해당하는 기능 처리 메서드 객체
	 * @param req
	 *            : 파라미터 정보를 담고있는 객체
	 * @return
	 */
	public Object[] process(Method method, HttpServletRequest req) throws Exception{
		//메소드에서 파라미터 타입정보를 추출한다.
		int index = 0;

		Parameter[] pArr = method.getParameters();
		Object[] rArr = new Object[pArr.length];
		//파라미터 배열에 담긴 정보를 추출하기 위해서 반복을 실행함.
		for (Parameter param : pArr) {
			Class<?> tClz = param.getType();
			
			String tName = tClz.getSimpleName();
			
			String name = param.getName();
			
			//RequestParam 어노테이션의 value 속성에 함
//			RequestParam rp = param.getAnnotation(RequelstParam.cass);
//			if(rp!= null){
//				name= rp.value();
//			}
			
			switch (tName) {
			case "int":
				rArr[index++] = Integer.parseInt(req.getParameter(name));
				break;
			case "HttpServletRequest":
				rArr[index++] = req;
				break;
			case "String":
				rArr[index++] = req.getParameter(name);
				break;
			case "HttpSession":
				rArr[index++] = req.getSession();
				break;
			default:
				rArr[index++] = WebUtil.getParamToVO(tClz, req);
			}
		}
		return rArr;
	}

}
