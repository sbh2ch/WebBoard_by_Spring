package framework;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class URLHandleMapping {

	private Map<String, CtrlAndMethod> mappings;
	private List<String> ctrlNameList;

	public URLHandleMapping() {
		mappings = new HashMap<>();
	}

	public URLHandleMapping(String scanPackage) {
		mappings = new HashMap<>();
		ctrlNameList = new ArrayList<>();

		try {
			getCtrlNameList(scanPackage);
			addMap();
		} catch (Exception e) {
			e.printStackTrace();
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

	private void addMap() throws Exception {
		for (String ctrlName : ctrlNameList) {
			Class<?> clz = Class.forName(ctrlName);
			Object target = clz.newInstance();
			for (Method m : clz.getMethods()) {
				RequestMapping rm = m.getDeclaredAnnotation(RequestMapping.class);
				if (rm == null)
					continue;
				this.mappings.put(rm.value(), new CtrlAndMethod(target, m));
			}
		}

	}

	/**
	 * @param scanPackage
	 *            scanPackage 밑의 모든 크래스중에서 @Controller 어노테이션이
	 *            설정된 컨트롤 클래스를 등록시키는것
	 * 
	 * 
	 */
	private void getCtrlNameList(String scanPackage) throws Exception {
		//kr.co.mlec
		//this 의 클래스를 들고오고 그 클래스를 들고온 클래스로더를 데려오고 
		//getResource 메소드로 어디서 리소스를 얻었는지 얻겠다 -> 반환 URL
		URL url = this.getClass().getClassLoader().getResource(scanPackage.replace(".", "\\"));

		File f = new File(url.toURI());
		String packagePath = f.getPath().replace(scanPackage.replace(".", "\\"), "");

		File[] fList = f.listFiles();
		for (File file : fList) {
			getClassNameByPackage(file, packagePath);
		}
	}

	/**
	 * file이 만약 디렉토리라면 디렉토리 하위의 모든 파일들을 찾아야함.
	 * 만약 파일이 디렉토리가 아닌 파일이라면 이름 추출해서 클래스 패키지 형태로 변환
	 * 
	 * 
	 * @param file
	 * @param packagePath
	 */
	private void getClassNameByPackage(File file, String packagePath) throws Exception {
		if (file.isDirectory()) {
			File[] fList = file.listFiles();

			for (File f : fList)
				getClassNameByPackage(f, packagePath);

		} else if (file.isFile()) {
			String filePath = file.getPath().replace(packagePath, "").replace(".class", "").replace("\\", ".");
			Class<?> clz = Class.forName(filePath);

			if (isControllerAnnotation(filePath))
				ctrlNameList.add(filePath);
		}
	}

	/**
	 * @param filePath
	 * @return
	 * 
	 * 		매개변수에 넘겨준 클래스에 @Controller 어노테이션이 선언되어있는지 판단.
	 */
	private boolean isControllerAnnotation(String filePath) throws Exception {
		Class<?> clz = Class.forName(filePath);
		Controller ctrl = clz.getDeclaredAnnotation(Controller.class);
		if (ctrl != null)
			return true;

		return false;
	}

	public CtrlAndMethod getCtrlAndMethod(String requestUri) {
		return mappings.get(requestUri);
	}
}
