package framework;

import java.util.HashMap;
import java.util.Map;

import controller.DeleteController;
import controller.DetailController;
import controller.ListController;
import controller.ReplyDeleteController;
import controller.ReplyUpdateController;
import controller.ReplyWriteController;
import controller.UpdateController;
import controller.UpdateFormController;
import controller.WriteController;
import controller.WriteFormController;
import login.Login;
import login.Logout;

public class URLHandleMapping {
	private Map<String, Controller> mappings;

	public URLHandleMapping() {
		mappings = new HashMap<>();
		mappings.put("/board/list.do", new ListController());
		mappings.put("/board/detail.do", new DetailController());
		mappings.put("/board/delete.do", new DeleteController());
		mappings.put("/board/updateForm.do", new UpdateFormController());
		mappings.put("/board/update.do", new UpdateController());
		mappings.put("/board/write.do", new WriteController());
		mappings.put("/board/writeForm.do", new WriteFormController());
		mappings.put("/reply/write.do", new ReplyWriteController());
		mappings.put("/reply/delete.do", new ReplyDeleteController());
		mappings.put("/reply/update.do", new ReplyUpdateController());
		mappings.put("/login/login.do", new Login());
		mappings.put("/login/logout.do", new Logout());
	}

	public Controller getController(String requestUri) {
		return mappings.get(requestUri);
	}
}
