package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.BoardDAO;
import board.BoardVO;
import file.FileDAO;
import file.FileVO;
import framework.Controller;
import member.MemberVO;

public class WriteController implements Controller{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO bDao = new BoardDAO();
		FileDAO fDao = new FileDAO();
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");
		String path = req.getServletContext().getRealPath("/upload");
		String filePath = new SimpleDateFormat("\\yyyy\\MM\\dd\\").format(new Date());
		File dir = new File(path + filePath);

		if (!dir.exists())
			dir.mkdirs();

		MultipartRequest mRequest = new MultipartRequest(req, path + filePath, 1024 * 1024 * 50, "utf-8", new DefaultFileRenamePolicy());

		String title = mRequest.getParameter("title");
		String content = mRequest.getParameter("content");

		int no = bDao.insert(new BoardVO(title, user.getName(), content, user.getEmail()));

		File newFile = mRequest.getFile("attachFile");

		if (newFile != null) {
			fDao.insert(new FileVO(no, mRequest.getOriginalFileName("attachFile"), mRequest.getFilesystemName("attachFile"), filePath, (int) newFile.length()));
		}
		
		
		return "redirect:/Test04/board/detail.do?no=" + no;
	}
}
