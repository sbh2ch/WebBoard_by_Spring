package framework;

import java.util.HashMap;
import java.util.Map;

/**
 * @author son
 *
 *         작업 후 포출할 페이지 : view
 *         화면페이지에서 사용할 공유데이터 : model
 *
 */
public class ModelAndView {
	private String view;
	private Map<String, Object> model = new HashMap<>();

	public ModelAndView() {
		super();
	}

	public ModelAndView(String view) {
		super();
		this.view = view;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

	public void addAttribute(String key, Object value) {
		model.put(key, value);
	}

}
