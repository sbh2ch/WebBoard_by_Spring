package framework;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

public class URLHandleMapping {

	private Map<String, Controller> mappings;

	public URLHandleMapping() {
		mappings = new HashMap<>();
	}

	public URLHandleMapping(String ctrlNames) {
		mappings = new HashMap<>();
		String[] ctrlList = ctrlNames.split(";");
		try {
			for (String s : ctrlList) {
				String[] sArr = s.trim().split("=");
				this.mappings.put(sArr[0], (Controller) Class.forName(sArr[1]).newInstance());
			}
		} catch (Exception e) {
			new ServletException(e);
		}
	}

	public Controller getController(String requestUri) {
		return mappings.get(requestUri);
	}
}
