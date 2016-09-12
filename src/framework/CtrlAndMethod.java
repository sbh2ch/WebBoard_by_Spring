package framework;

import java.lang.reflect.Method;

/**
 * @author son
 *
 *         사용자가 요청하는 URL에 대한 처리를 진행할 컨트롤러와 메서드 정보를 관리
 *
 */
public class CtrlAndMethod {
	private Object target; //컨트롤러
	private Method method; //메소드

	public CtrlAndMethod(Object target, Method method) {
		super();
		this.target = target;
		this.method = method;
	}

	public Object getTarget() {
		return target;
	}

	public Method getMethod() {
		return method;
	}

}
